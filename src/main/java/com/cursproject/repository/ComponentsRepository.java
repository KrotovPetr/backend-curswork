package com.cursproject.repository;

import com.cursproject.Entity.Components;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComponentsRepository extends JpaRepository<Components, Long> {
    Optional<Components> findByName(String name);
}