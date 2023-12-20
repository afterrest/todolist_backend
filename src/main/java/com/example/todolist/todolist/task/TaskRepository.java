package com.example.todolist.todolist.task;

import com.example.todolist.todolist.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer>{
}
