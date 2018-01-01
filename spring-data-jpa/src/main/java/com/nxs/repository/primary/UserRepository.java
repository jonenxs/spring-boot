package com.nxs.repository.primary;

import com.nxs.entity.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
