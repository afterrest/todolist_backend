package com.example.todolist;

import com.example.todolist.todolist.section.Section;
import com.example.todolist.todolist.section.SectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.testng.Assert.assertTrue;

@SpringBootTest
class TodolistApplicationTests {
    @Autowired
    private SectionRepository sectionRepository;
/*    @Test
    void contextLoads() {
        Sections s1 = new Sections();
        s1.setId("3");
        s1.setName("3");
        this.sectionsRepository.save(s1);
    }*/
/*    @Test
    void contextChange() {
        Optional<Sections> sc = this.sectionsRepository.findById(3);
        assertTrue(sc.isPresent()); //존재 체크용. 잘 모르겠음.
        Sections s1 = sc.get();
        s1.setName("4");
        this.sectionsRepository.save(s1);
    }*/
    @Test
    void contextDelete() {
        Optional<Section> sc = this.sectionRepository.findById(3);
        assertTrue(sc.isPresent());
        Section s1 = sc.get();
        this.sectionRepository.delete(s1);
    }

}
