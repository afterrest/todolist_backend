package com.example.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface SectionsRepository extends JpaRepository<Sections,Integer>{
}
