package com.cursproject.Entity;
public enum Permission {
    USERS_PERMISSION("users:permission"),
    ADMIN_PERMISSION("admin:permission");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}