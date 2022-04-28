package com.example.table_connection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.List;

@Entity(name = "groups")  //we should do it because of db error near word Group
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne     //many groups for one faculty
    private Faculty faculty;

    @OneToMany    //one group to many students
    private List<Student> students; //it opens new table in db groups_students

}
