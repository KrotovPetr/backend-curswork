package com.cursproject.Controller;


import com.cursproject.DTO.UpdateComponentDTO;
import com.cursproject.Entity.Components;
import com.cursproject.Exceptions.WrongIdException;
import com.cursproject.Mapper.ComponentMapper;
import com.cursproject.repository.ComponentsRepository;
import com.cursproject.security.JWTProvider;
import com.cursproject.service.ComponentService;
import com.cursproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ComponentController {
    private final ComponentMapper componentMapper;
    private final ComponentService componentService;
    private final JWTProvider provider;
    private final UserService userService;
    @Autowired
    public ComponentController(ComponentMapper componentMapper, ComponentService componentService, JWTProvider provider, UserService userService) {
        this.componentMapper = componentMapper;
        this.componentService = componentService;
        this.provider = provider;
        this.userService = userService;
    }
    @Autowired
    private ComponentsRepository cRepo;

    @GetMapping("component")
    public List<Components> getAllComponents() {
        return cRepo.findAll();
    }

    @GetMapping("component/{id}")
    public Components getComponentById(@PathVariable Long id) {
        return cRepo.findById(id).get();
    }

    @PostMapping("component")
    public Components saveComponentDetails(@RequestBody Components components, HttpServletRequest request) {
        String user = provider.getUsernameFromToken(provider.resolveToken(request));
        String role = userService.loadUserByUsername(user).getAuthorities().toString();
        System.out.println(role);
        return cRepo.save(components);
    }

    @PutMapping("component")
    public Components updateComponent(@RequestBody Components components) {
        return cRepo.save(components);
    }

    @PatchMapping("component/{id}")
    public ResponseEntity<?> patchComponent(@PathVariable(name="id") long id, @RequestBody @Valid UpdateComponentDTO dto, HttpServletRequest request) throws WrongIdException {
//        Components components = (Components) componentService.findById(id);
        Components components = componentService.findById(id).orElseThrow(() -> new WrongIdException("Неправльный id"));
        componentMapper.updateComponentFromDto(dto, components);
        cRepo.save(components);
        return new ResponseEntity<>("Данные компонента обновлены", HttpStatus.OK);
    }

    @DeleteMapping("component/{id}")
    public ResponseEntity<?> deleteComponentById(@PathVariable Long id) {
        cRepo.deleteById(id);
        return new ResponseEntity<>("Данные компонента удалены",HttpStatus.NO_CONTENT);
    }
}

