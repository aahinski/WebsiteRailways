package com.ahinski.website.repo;

import com.ahinski.website.models.Ticket;
import com.ahinski.website.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}