package com.example.todolist;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController //RESTful 웹 서비스의 컨트롤러임을 나타냅니다.
// 이 클래스의 메서드들은 HTTP 요청에 대한 응답으로 JSON 또는 XML 형식의 데이터를 반환합니다.
@RequestMapping("/todolist")
@CrossOrigin //CORS 활성화
public class TodolistController {
    @Autowired //의존성 주입
    private SectionsRepository SectionsRepository;

    @GetMapping("/sections") //HTTP GET 요청을 처리하는 메서드
    public List<Sections> GetSections(){
        return SectionsRepository.findAll();
    }
    @Autowired //의존성 주입
    private TasksRepository TasksRepository;
    @GetMapping("/tasks") //HTTP GET 요청을 처리하는 메서드
    public List<Tasks> GetTasks(){
        return TasksRepository.findAll();
    }

}