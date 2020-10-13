package com.dabi.todoapp.service;

import com.dabi.todoapp.model.ListGroup;
import com.dabi.todoapp.model.Todo;
import com.dabi.todoapp.repository.ListGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IListGroupService")
public class ListGroupService {

    @Autowired
    private ListGroupRepository listGroupRepository;

    public List<ListGroup> findAll() {
        return listGroupRepository.findAll();
    }

    public void save(ListGroup listGroup) {
        listGroupRepository.save(listGroup);
    }

    public List<Todo> findTodosByGroup(Integer id) {
        return listGroupRepository.findById(id).get().getTodos();
    }

    public void deleteById(Integer id) {
        listGroupRepository.deleteById(id);
    }

    public List<ListGroup> findAllByUser(Integer id) { return listGroupRepository.findByUserId(id);
    }
}
