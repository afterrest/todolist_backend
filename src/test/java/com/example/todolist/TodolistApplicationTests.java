package com.example.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodolistApplicationTests {
    @Autowired
    private SectionsRepository SectionsRepository;
    @Test
    void contextLoads() {
        Sections s1 = new Sections();
        s1.setId("3");
        s1.setName("3");
        this.SectionsRepository.save(s1);
    }

}
