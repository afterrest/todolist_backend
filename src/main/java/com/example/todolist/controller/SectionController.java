package com.example.todolist.controller;

import com.example.todolist.todolist.entity.Section;
import com.example.todolist.todolist.dao.SectionCRUD;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/todolist/section")
@CrossOrigin(origins = "http://localhost:3000")
public class SectionController {

    @Autowired
    private SectionCRUD sectionCRUD;

    @PostMapping
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        Section createdSection = sectionCRUD.createSection(section);
        return new ResponseEntity<>(createdSection, HttpStatus.CREATED);
    }

    @PutMapping("/{sectionId}")
    public ResponseEntity<Section> updateSection(@PathVariable Integer sectionId, @RequestBody Section updatedSection) {
        System.out.println("PUT tried");
        Section section = sectionCRUD.updateSection(sectionId, updatedSection);
        if (section != null) {
            return new ResponseEntity<>(section, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Section> getSections() {
        return sectionCRUD.getAllSections();
    }

    @DeleteMapping("/{sectionId}")
    public ResponseEntity<Void> deleteSection(@PathVariable Integer sectionId) {
        boolean deleted = sectionCRUD.deleteSection(sectionId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
