package com.dabi.todoapp.repository;
import com.dabi.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
  List<Todo> findByUserName(String user);
}
