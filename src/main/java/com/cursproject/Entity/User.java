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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq",
            sequenceName = "users_id_seq",
            allocationSize = 1
    )
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Role roles;
    private String accessToken;
    private String refreshToken;
    @Column(name = "activity")
    private boolean isActive;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "user")
    private List<Post> posts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>(role.getAuthorities());
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

}