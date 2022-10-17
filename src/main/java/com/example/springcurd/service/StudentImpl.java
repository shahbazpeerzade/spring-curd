package com.example.springcurd.service;

import com.example.springcurd.entity.Student;
import com.example.springcurd.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class StudentImpl  implements StudentService{
    public StudentImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Autowired
    private StudentRepo studentRepo;


    @Override
    public Student create(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public Student update(Student student, long id) {
        Student student1 = this.studentRepo.findById(id).orElseThrow(
                () -> new RuntimeException(" not found"));
        student1.setId(student.getId());
        student1.setName(student.getName());
        student1. setHobies(student.getHobies());
        this.studentRepo.save(student1);
        Student save = this.studentRepo.save(student1);
        return save;

    }

    @Override
    public void delete(long id) {
        Student student1 = this.studentRepo.findById(id).orElseThrow(
                () -> new RuntimeException(" not found  "));

        this.studentRepo.delete(student1);
    }

    @Override
    public Student getById(Student student) {

        return student;
    }
@Override
    public Student getById(long id) {
        Student student1 = this.studentRepo.findById(id).orElseThrow(
                () -> new RuntimeException(" not found  "));
        return student1;
    }

    @Override
    public List<Student> getAll() {
        List<Student> all = this.studentRepo.findAll();
        return all;
    }

}
