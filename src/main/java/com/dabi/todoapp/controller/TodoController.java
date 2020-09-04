package com.dabi.todoapp.controller;

import com.dabi.todoapp.model.Todo;
import com.dabi.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("showalltodos")
    public String showAllTodos(Model model) {
        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);
        return "/todo/showalltodos";
    }

    @GetMapping("/addtodo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "todo/addtodo";
    }

    @PostMapping("/addtodo")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.save(todo);
        return "redirect:/showalltodos";
    }

    @GetMapping("/edittodo/{id}")
    public String editTodo(Model model, @PathVariable Integer id) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo); // initial bind with the form, to say to the webpage
        //model.addAttribute("todos", todoService.findAll());
        return "todo/edittodo";
    }

    @PostMapping("/edittodo/{id}")
    public String editTodo(@ModelAttribute Todo todo, @PathVariable Integer id) {
        System.out.println(todo);
        todoService.save(todo); // save it again. SAVE acts as UPDATE
        return "redirect:/showalltodos";
    }

    @GetMapping("/deletetodo/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        todoService.deleteById(id);
        return "redirect:/showalltodos";
    }
}
