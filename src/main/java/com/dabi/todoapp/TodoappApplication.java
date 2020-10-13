package com.dabi.todoapp;

import com.dabi.todoapp.repository.ListGroupRepository;
import com.dabi.todoapp.repository.TodoRepository;
import com.dabi.todoapp.repository.UserRepository;
import com.dabi.todoapp.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoappApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private ListGroupRepository listGroupRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SendGridEmailService sendGridEmailService;



	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		try {
//			todoRepository.deleteById(1);
//		} catch (Exception ex) {
//
//		}
	}
}