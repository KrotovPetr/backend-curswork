package com.cursproject.repository;

import com.cursproject.Entity.Components;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComponentsRepository extends JpaRepository<Components, Long> {
    Optional<Components> findByName(String name);
}