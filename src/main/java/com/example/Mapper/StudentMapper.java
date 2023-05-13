package com.example.Mapper;

import com.example.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    public Student getStudent(Long age);

    Student updataStudent(Student student);
}
