package com.example.todolist;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

@RestController //RESTful 웹 서비스의 컨트롤러임을 나타냅니다.
// 이 클래스의 메서드들은 HTTP 요청에 대한 응답으로 JSON 또는 XML 형식의 데이터를 반환합니다.
@RequestMapping("/todolist")
@CrossOrigin //CORS 활성화
public class TodolistController {
    @Autowired //의존성 주입
    private SectionRepository sectionRepository;

    @GetMapping("/section") //HTTP GET 요청을 처리하는 메서드
    public List<Section> getSections(){
        return sectionRepository.findAll();
    }






    @Autowired //의존성 주입
    private TodolistCRUD todolistCRUD;

    @PostMapping("/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = todolistCRUD.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer taskId, @RequestBody Task updatedTask) {
        Task task = todolistCRUD.updateTask(taskId, updatedTask);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/task") //HTTP GET 요청을 처리하는 메서드
    public List<Task> getTasks(){
        return todolistCRUD.getAllTasks();
    }
    @DeleteMapping("/task/{taskId}")
    public void deleteTask(@PathVariable Integer taskId){
        boolean deleted = todolistCRUD.deleteTask(taskId);
    }

}