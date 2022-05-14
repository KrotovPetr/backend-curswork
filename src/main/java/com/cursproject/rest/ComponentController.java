package com.cursproject.rest;


import java.util.List;

import com.cursproject.Model.Components;
import com.cursproject.repository.ComponentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("")
@CrossOrigin("*")
public class ComponentController {

    @Autowired
    private ComponentsRepository cRepo;

    @GetMapping("/components")
    public List<Components> getAllComponents() {
        return cRepo.findAll();
    }

    @GetMapping("/components/{id}")
    public Components getComponentById(@PathVariable Long id) {
        return cRepo.findById(id).get();
    }

    @PostMapping("/components")
    public Components saveComponentDetails(@RequestBody Components employee) {
        return cRepo.save(employee);
    }

    @PutMapping("/components")
    public Components updateComponent(@RequestBody Components employee) {
        return cRepo.save(employee);
    }

    @DeleteMapping("/components/{id}")
    public ResponseEntity<HttpStatus> deleteComponentsById(@PathVariable Long id) {
        cRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}