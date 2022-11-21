package com.cursproject.Controller;


import com.cursproject.DTO.UpdateComponentDTO;
import com.cursproject.Entity.Components;
import com.cursproject.Exceptions.WrongIdException;
import com.cursproject.Mapper.ComponentMapper;
import com.cursproject.repository.ComponentsRepository;
import com.cursproject.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    public ComponentController(ComponentMapper componentMapper, ComponentService componentService) {
        this.componentMapper = componentMapper;
        this.componentService = componentService;
    }
    @Autowired
    private ComponentsRepository cRepo;
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("component")
    public List<Components> getAllComponents() {
        return cRepo.findAll();
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("component/{id}")
    public Components getOrderById(@PathVariable Long id) {
        return cRepo.findById(id).get();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("component")
    public Components saveOrderDetails(@RequestBody Components components) {
        return cRepo.save(components);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("component")
    public Components updateOrder(@RequestBody Components components) {
        return cRepo.save(components);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("component/{id}")
    public ResponseEntity<?> patchOrder(@PathVariable(name="id") long id, @RequestBody @Valid UpdateComponentDTO dto, HttpServletRequest request) throws WrongIdException {
//        Components components = (Components) componentService.findById(id);
        Components components = componentService.findById(id).orElseThrow(() -> new WrongIdException("Неправльный id"));
        componentMapper.updateComponentFromDto(dto, components);
        cRepo.save(components);
        return new ResponseEntity<>("Данные компонента обновлены", HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("component/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long id) {
        cRepo.deleteById(id);
        return new ResponseEntity<>("Данные компонента удалены",HttpStatus.NO_CONTENT);
    }
}

