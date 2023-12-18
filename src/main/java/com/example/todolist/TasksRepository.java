package com.example.todolist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks,Integer>{
}
