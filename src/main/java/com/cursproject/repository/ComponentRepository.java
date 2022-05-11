package com.cursproject.repository;

import com.cursproject.Model.Components;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComponentRepository extends JpaRepository<Components, Long> {
    Optional<Components> findByName(String name);
}