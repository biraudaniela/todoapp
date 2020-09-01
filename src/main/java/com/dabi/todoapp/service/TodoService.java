package com.dabi.todoapp.service;

import com.dabi.todoapp.model.Todo;
import com.dabi.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("ITodoService")
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void save(Todo todo) {
        todoRepository.save(todo);
    }
    public Todo findById(Integer id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return todo.get();
        }

        return null;
    }

    public void deleteById(Integer id) {
        todoRepository.deleteById(id);
    }
}

