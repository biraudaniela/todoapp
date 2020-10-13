package com.dabi.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ListGroup {
    private String groupName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;

    @OneToMany(mappedBy = "listGroup", cascade = CascadeType.ALL)
    private List<Todo> todos;

}
