package com.example.springcurd.controller;

import com.example.springcurd.entity.Student;
import com.example.springcurd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    @GetMapping("/home")
    public String get(){
        return "Home Page";
    }

    @Autowired
    private StudentService studentService;
    //create
    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student student1 = this.studentService.create(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }
    // update
    @PutMapping("/update/{id}")
    public  ResponseEntity<Student> update(@RequestBody Student student, @PathVariable long id){
            Student student1 = this.studentService.update(student, id);
        return new ResponseEntity<>(student1 ,HttpStatus.CREATED);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String ,String>> creatProduct(@PathVariable long id){
        this.studentService.delete(id);
        Map<String, String> message = Map.of("message", " deleted successfully");
        return  new ResponseEntity<>(message, HttpStatus.OK );
    }

    //get single product
    @GetMapping ("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Student id){
        Student student=  this.studentService.getById(id);
        return  new ResponseEntity<>(student, HttpStatus.OK);
    }

    //get all product
    @GetMapping ("/all/{id}"   )
    public ResponseEntity<List<Student>> getall(){
        List<Student>all= this.studentService.getAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }

}
