package com.cursproject;
import com.cursproject.Entity.Role;
import com.cursproject.Entity.User;
import com.cursproject.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

//    private final List<User> users;

    public UserService() {
//        this.users = List.of(
//                new User("peter", "1234", "Peter", "Krotov", Collections.singleton(Role.USER))
//        );
    }

//    public Optional<User> getByLogin(@NonNull String login) {
//        return users.stream()
//                .filter(user -> login.equals(user.getLogin()))
//                .findFirst();
//    }


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        log.info("Find all users");
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Find user with username {}", username);
        if (userRepository.findByUsername(username).isEmpty()) {
            log.warn("There is no user with username - {}", username);
            throw new UsernameNotFoundException("Пользователя с таким именем не существует");
        }
        return userRepository.findByUsername(username).get();
    }

    @Transactional
    public void create(User user) {
        log.info("Create new user with username {}", user.getUsername());
        userRepository.save(user);
    }

    @Transactional
    public void delete(User user) {
        log.info("Delete user with username {}", user.getUsername());
        userRepository.delete(user);
    }

    @Transactional
    public void update(User user) {
        log.info("Update profile info of user with username {}", user.getUsername());
        userRepository.save(user);
    }
}

