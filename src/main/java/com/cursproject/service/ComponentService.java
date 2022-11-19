package com.cursproject.service;

import com.cursproject.Entity.Components;
import com.cursproject.repository.ComponentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Slf4j
@Service
public class ComponentService {
    @PersistenceContext
    protected EntityManager entityManager;
    private final ComponentsRepository componentsRepository;
    @Autowired
    public ComponentService(ComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Components> findById(long id) {
        log.info("Find post by id = {}", id);
        return componentsRepository.findById(id);
    }


    @Transactional
    public void create(Components components) {
        log.info("Create new component");
        entityManager.persist(components);
    }

    @Transactional
    public void delete(Components components) {
        log.info("Delete components with id {}", components.getId());
        entityManager.remove(components);
    }

    @Transactional
    public void update(Components components) {
        log.info("Update components with id {}", components.getId());
        entityManager.persist(components);
    }




}
