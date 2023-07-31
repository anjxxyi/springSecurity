package com.springboot.anjaeyi.exam.repository;

import com.springboot.anjaeyi.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String var1);
}
