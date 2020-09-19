package com.dabi.todoapp.repository;
import com.dabi.todoapp.model.Todo;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
 @Query("FROM Todo t WHERE t.user.userId=:userId")
  List<Todo> findByUserId(@Param("userId") Integer id);
}
