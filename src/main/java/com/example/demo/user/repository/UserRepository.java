package com.example.demo.user.repository;

import com.example.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userName = :name")
    User getUserByUserName(@Param("name") String name);

    User findUserById(Long id);

    Boolean existsUserByEmail(String email);
}
