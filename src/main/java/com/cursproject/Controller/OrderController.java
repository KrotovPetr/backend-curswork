package com.cursproject.Controller;


import java.util.List;

import com.cursproject.Entity.Order;
import com.cursproject.repository.OrderRepository;
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
public class OrderController {

    @Autowired
    private OrderRepository oRepo;
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("order")
    public List<Order> getAllOrders() {
        return oRepo.findAll();
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("order/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return oRepo.findById(id).get();
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("order/{email}")
    public Order getOrderById(@PathVariable String email) {
        return oRepo.findByEmail(email).get();
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("order")
    public Order saveOrderDetails(@RequestBody Order order) {
        return oRepo.save(order);
    }
    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("order")
    public Order updateOrder(@RequestBody Order order) {
        return oRepo.save(order);
    }
    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("order/{id}")
    public ResponseEntity<HttpStatus> deleteOrderById(@PathVariable Long id) {
        oRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}