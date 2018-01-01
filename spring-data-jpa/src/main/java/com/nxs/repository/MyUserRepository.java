package com.nxs.repository;

import com.nxs.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    MyUser findByName(String name);

    MyUser findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    MyUser findUser(@Param("name") String name);
}
