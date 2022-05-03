package com.ahinski.website.repo;

import com.ahinski.website.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
