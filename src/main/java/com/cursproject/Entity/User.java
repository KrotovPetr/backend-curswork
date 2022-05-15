package com.cursproject.Entity;
//
//import com.cursproject.Entity.Role;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
////@Entity
////@Table(name = "users")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class User {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////    @Column(name = "login")
//    private String login;
////    @Column(name = "password")
//    private String password;
////    @Column(name = "firstname")
//    private String firstName;
////    @Column(name = "lastname")
//    private String lastName;
////    @Column(name = "roles")
//    private Set<Role> roles;
//
//
//}
//

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles;

}