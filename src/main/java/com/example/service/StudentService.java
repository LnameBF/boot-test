package com.example.service;

import com.example.Mapper.StudentMapper;
import com.example.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentService {

    @Autowired
    StudentMapper studentMapper;


    public Student getStudentByAge(Long age){
        Student student = studentMapper.getStudent(age);
        log.info(student.getSName());

        return student;


    }
}
