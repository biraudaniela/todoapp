package com.dabi.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String username;
    private String emailAddress;

    private String password;

    @OneToOne(mappedBy = "user")
    private PendingUser pendingUser;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Todo> todoList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ListGroup> listGroups;
}
