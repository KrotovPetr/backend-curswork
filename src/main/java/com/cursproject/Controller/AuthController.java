package com.cursproject.Controller;

import com.cursproject.DTO.*;
import com.cursproject.Entity.User;
import com.cursproject.Exceptions.DuplicateUsernameException;
import com.cursproject.Exceptions.PasswordCheckFailureException;
import com.cursproject.Mapper.UserMapper;
import com.cursproject.security.JWTProvider;
import com.cursproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager manager;
    private final UserService userService;
    private final JWTProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService,
                          JWTProvider jwtTokenProvider, PasswordEncoder passwordEncoder,
                          UserMapper userMapper) {
        this.manager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUserDTO userDTO) throws DuplicateUsernameException, PasswordCheckFailureException {
        try {
            userService.loadUserByUsername(userDTO.getUsername());
            throw new DuplicateUsernameException("Данная почта уже используется для другого аккаунта");
        } catch(UsernameNotFoundException ex) {
            userService.checkDTO(userDTO);
            User user = userDTO.toUser();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.create(user);
            return new ResponseEntity<>("Вы успешно зарегистрировались в системе", HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody @Valid AuthDTO request) throws UsernameNotFoundException {
        String username = request.getUsername();
        manager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));
        User user = (User) userService.loadUserByUsername(request.getUsername());
        String token = jwtTokenProvider.generateToken(user);
        AuthResponseDTO response = AuthResponseDTO.builder()
                .username(user.getUsername()).token(token)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editProfile(@RequestBody @Valid UpdateUserDTO dto, HttpServletRequest request)
            throws PasswordCheckFailureException {
        String pass = userService.checkDTO(dto);
        String token = jwtTokenProvider.resolveToken(request);
        String username = jwtTokenProvider.getUsernameFromToken(token);
        User user = (User) userService.loadUserByUsername(username);
        userMapper.updateUserFromDto(dto, user);
        if (pass != null) {
            user.setPassword(pass);
        }
        userService.update(user);
        return new ResponseEntity<>("Данные профиля обновлены", HttpStatus.OK);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler handler = new SecurityContextLogoutHandler();
        handler.logout(request, response, null);
    }
}