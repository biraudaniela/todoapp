package com.dabi.todoapp.repository;

import com.dabi.todoapp.model.ListGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListGroupRepository extends JpaRepository<ListGroup, Integer> {
    List<ListGroup> findByUserId(Integer id);
}
