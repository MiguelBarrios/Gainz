package com.miguelbarrios.userservice.repositories;

import com.miguelbarrios.userservice.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
