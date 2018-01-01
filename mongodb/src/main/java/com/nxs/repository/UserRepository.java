package com.nxs.repository;

import com.nxs.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);
}
