package com.service.coupon.repository;

import com.service.coupon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
