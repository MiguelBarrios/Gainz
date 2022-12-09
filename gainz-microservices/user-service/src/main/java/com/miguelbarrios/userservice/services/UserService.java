package com.miguelbarrios.userservice.services;

import com.miguelbarrios.userservice.models.AppUser;
import com.miguelbarrios.userservice.models.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
