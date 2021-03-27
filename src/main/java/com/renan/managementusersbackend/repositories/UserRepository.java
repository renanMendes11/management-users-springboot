package com.renan.managementusersbackend.repositories;

import com.renan.managementusersbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User,Long> {
    @Transactional
    @Modifying
    @Query("update User u " +
            "set u.name = :#{#user.name}, " +
            "u.email = :#{#user.email}, " +
            "u.gender = :#{#user.gender}, " +
            "u.age = :#{#user.age} " +
            "where u.id = :id")
    void update(@Param("user") User user, @Param("id") Long id);
}
