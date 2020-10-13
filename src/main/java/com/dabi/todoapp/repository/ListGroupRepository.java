package com.dabi.todoapp.repository;

import com.dabi.todoapp.model.ListGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListGroupRepository extends JpaRepository<ListGroup, Integer> {
}
