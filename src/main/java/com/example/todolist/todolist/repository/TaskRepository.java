package com.example.todolist.todolist.repository;

import com.example.todolist.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer>{
}
