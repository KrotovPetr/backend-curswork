package com.cursproject.Entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("ADMIN"),
    USER("USER");

    private final String permissions;

    Role(String permissions) {
        this.permissions = String.valueOf(permissions);
    }

    public String getPermissions() {
        return permissions;
    }

    @Override
    public String getAuthority() {
        return permissions;
    }
}