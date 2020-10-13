package com.dabi.todoapp.repository;

import com.dabi.todoapp.model.ListGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListGroupRepository extends JpaRepository<ListGroup, Integer> {
    @Query("FROM ListGroup l WHERE l.user.userId=:userId")
    List<ListGroup> findByUserId(@Param("userId")Integer id);
}
