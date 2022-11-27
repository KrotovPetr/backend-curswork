package com.cursproject.Entity;


import com.cursproject.DTO.GetUsersDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "role")
    private Role roles;
    @Column(name = "is_active")
    private boolean isActive;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>(roles.getAuthorities());
    }

    public Role getRole() {
        return roles;
    }
    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public GetUsersDTO toDTO() {
        return GetUsersDTO.builder().id(this.id).username(this.username).password(this.password)
                .first_name(this.firstName).last_name(this.lastName)
                .role(this.roles).isActive(this.isActive).build();
    }
}