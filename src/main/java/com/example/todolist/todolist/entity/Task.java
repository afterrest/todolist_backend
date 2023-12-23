package com.example.todolist.todolist.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter//getter 메소드 자동생성
@Setter//setter 메소드 자동생성
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer section_id;
    private String name;
    private boolean completed = false;

//    @ManyToOne
//    @JoinColumn(name = "section_id", referencedColumnName = "id")
//    private Sections sections;
}
