package com.example.studentservice.service;

import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    public String addStudent(Student student);
    List<Student> getAllStudents();

    boolean deleteStudent(Long id);



}
