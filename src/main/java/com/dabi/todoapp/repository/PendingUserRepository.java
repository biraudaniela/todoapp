package com.dabi.todoapp.repository;

import com.dabi.todoapp.model.PendingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PendingUserRepository extends JpaRepository<PendingUser, Integer> {
    Optional<PendingUser> findByActivationCode(String activationCode);

    @Query("FROM PendingUser p where p.user.username = :username")
    Optional<PendingUser> findByUsername(@Param("username") String username);
}
