package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    @ResponseBody
    public Student getStudentByAge(@RequestParam Long age){

        return service.getStudentByAge(age);
    }

}
