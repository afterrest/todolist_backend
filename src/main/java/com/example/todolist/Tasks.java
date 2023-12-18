package com.example.todolist;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter//getter 메소드 자동생성
@Setter//setter 메소드 자동생성
public class Tasks {
    @Id
    private String id;
    private String section_id;
    private String name;
    private boolean completed;

//    @ManyToOne
//    @JoinColumn(name = "section_id", referencedColumnName = "id")
//    private Sections sections;
}
