package com.example.table_connection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String kocha;

    @Column(nullable = false)
    private int uyRaqami;

    @ManyToOne
    private District district;

    @OneToOne
    private University university;

    @OneToOne
    private Student student;
}
