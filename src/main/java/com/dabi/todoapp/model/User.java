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
// TODO: to be sure that username is unique
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // start from 1  on each table
    private Integer userId;

    private String username; //nickname
    private String emailAddress;

    private String password;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Role role;

    @OneToOne(mappedBy = "user")
    private PendingUser pendingUser;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Todo> todoList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ListGroup> listGroups;
}
