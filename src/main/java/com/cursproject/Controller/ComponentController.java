package com.cursproject.Controller;


import com.cursproject.Entity.Components;
import com.cursproject.Mapper.ComponentMapper;
import com.cursproject.repository.ComponentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ComponentController {
    private final ComponentMapper componentMapper;
    @Autowired
    public ComponentController(ComponentMapper componentMapper) {
        this.componentMapper = componentMapper;
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
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("component")
    public Components saveOrderDetails(@RequestBody Components components) {
        return cRepo.save(components);
    }
    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("component")
    public Components updateOrder(@RequestBody Components components) {
        return cRepo.save(components);
    }
    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("component/{id}")
    public ResponseEntity<HttpStatus> deleteOrderById(@PathVariable Long id) {
        cRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

