package com.example.todolist.todolist.dao;

import com.example.todolist.todolist.entity.Section;
import com.example.todolist.todolist.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionCRUD {
    @Autowired
    private SectionRepository sectionRepository;

    public SectionCRUD(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    public Section getSectionById(Integer sectionId) {
        Optional<Section> sectionOptional = sectionRepository.findById(sectionId);
        return sectionOptional.orElse(null);
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section updateSection(Integer sectionId, Section updatedSection) {
        Optional<Section> sectionOptional = sectionRepository.findById(sectionId);
        if (sectionOptional.isPresent()) {
            Section existingSection = sectionOptional.get();
            existingSection.setName(updatedSection.getName());
            // Update additional fields as needed
            return sectionRepository.save(existingSection);
        } else {
            return null;
        }
    }

    public boolean deleteSection(Integer sectionId) {
        Optional<Section> sectionOptional = sectionRepository.findById(sectionId);
        if (sectionOptional.isPresent()) {
            sectionRepository.deleteById(sectionId);
            return true;
        } else {
            return false;
        }
    }
}
