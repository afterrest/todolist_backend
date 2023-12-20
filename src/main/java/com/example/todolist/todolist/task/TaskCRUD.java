package com.example.todolist.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskCRUD {
    @Autowired //의존성 주입
    private TaskRepository taskRepository;

    public TaskCRUD(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        // 추가적인 비즈니스 로직 수행 가능
        return taskRepository.save(task);
    }
    public Task getTaskById(Integer taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        return taskOptional.orElse(null);
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task updateTask(Integer taskId, Task updatedTask) {
        System.out.println("update tried");
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {

            Task existingTask = taskOptional.get();
            existingTask.setName(updatedTask.getName());
            // 추가적인 필드 업데이트
            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }
    public boolean deleteTask(Integer taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            taskRepository.deleteById(taskId);
            return true;
        } else {
            return false;
        }
    }



}
