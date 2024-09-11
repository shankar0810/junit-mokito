package com.example.junit_mokito.repository;

import com.example.junit_mokito.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
