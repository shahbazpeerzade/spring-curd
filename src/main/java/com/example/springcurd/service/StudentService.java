package com.example.springcurd.service;

import com.example.springcurd.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    Student create(Student student);
    Student update(Student student ,long id);
    void delete(long id);
    Student getById(Student student);
    Student getById(long id);
    List<Student> getAll ();
}
