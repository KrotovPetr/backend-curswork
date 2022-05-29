package com.cursproject.Controller;


import java.util.List;

import com.cursproject.Entity.Components;
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



@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ComponentController {

    @Autowired
    private ComponentsRepository cRepo;
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("components")
    public List<Components> getAllComponents() {
        return cRepo.findAll();
    }




}