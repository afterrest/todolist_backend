package com.example.todolist;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter//getter 메소드 자동생성
@Setter//setter 메소드 자동생성
public class Sections {
    @Id
    private String id;
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name="section_id")
    private List<Tasks> tasks;
}
