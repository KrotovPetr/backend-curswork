package com.cursproject.rest;



import com.cursproject.Model.Components;
import com.cursproject.Model.Developer;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/components")
public class DeveloperRestControllerV1 {
    private List<Developer> COMPONENTS =

    @GetMapping
    public List<Developer> getAll() {
        return COMPONENTS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id) {
        return COMPONENTS.stream().filter(component -> component.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public Components create(@RequestBody Components components) {
        this.COMPONENTS.add(components);
        return components;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id) {
        this.COMPONENTS.removeIf(developer -> developer.getId().equals(id));
    }
}