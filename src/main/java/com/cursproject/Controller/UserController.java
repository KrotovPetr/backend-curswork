package com.cursproject.Controller;


//import com.cursproject.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("")
//@CrossOrigin("*")
//public class UserController {
//
//    @Autowired
//    private UserRepository uRepo;
//
//    @GetMapping("/user")
//    public List<User> getAllOrders() {
//        return uRepo.findAll();
//    }
//
//    @GetMapping("/user/{id}")
//    public User getOrderById(@PathVariable Long id) {
//        return uRepo.findById(id).get();
//    }
//
//    @PostMapping("/user")
//    public User saveOrderDetails(@RequestBody User user) {
//        return uRepo.save(user);
//    }
//
//    @PutMapping("/user")
//    public User updateOrder(@RequestBody User user) {
//        return uRepo.save(user);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<HttpStatus> deleteOrderById(@PathVariable Long id) {
//        uRepo.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}