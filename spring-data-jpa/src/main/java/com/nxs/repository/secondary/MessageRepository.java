package com.nxs.repository.secondary;

import com.nxs.entity.secondary.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
