package com.dabi.todoapp.controller;

import com.dabi.todoapp.model.ListGroup;
import com.dabi.todoapp.model.Todo;
import com.dabi.todoapp.model.User;
import com.dabi.todoapp.repository.UserRepository;
import com.dabi.todoapp.service.ListGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.security.Principal;

@Controller
public class ListGroupController {

    @Autowired
    private ListGroupService listGroupService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("listtodo")
    public String showAllGroups(Model model, Principal principal, Authentication authentication) {
        System.out.println(principal.getName());
        System.out.println(authentication.getName());

        User user = userRepository.findByUsername(principal.getName()).get();

        List<ListGroup> listGroups = listGroupService.findAllByUser(user.getUserId());

        model.addAttribute("listgroups", listGroups);

        return "todo/listtodo";
    }

    @GetMapping("/addlistgroup")
    public String addListGroup(Model model) {
        model.addAttribute("listgroup", new ListGroup()); // initial bind with the form, to say to the webpage
        // what is the type of student th:object

        return "todo/addlistgroup";
    }

    @PostMapping("/addlistgroup")
    public String addListGroup(@ModelAttribute ListGroup listGroup, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        listGroup.setUser(user);
        listGroupService.save(listGroup);
        return "redirect:/listtodo";
    }

    @GetMapping("/group/{id}/todos")
    public String viewTodosInGroup(Model model, @PathVariable Integer id) {
        model.addAttribute("todos", listGroupService.findTodosByGroup(id));
        return "todo/viewtodos";
    }

    @GetMapping("/deletelistgroup/{id}")
    public String deleteListGroup(@PathVariable Integer id) {
        listGroupService.deleteById(id);
        return "redirect:/listtodo";
    }
}
