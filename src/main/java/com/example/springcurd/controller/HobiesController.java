package com.example.springcurd.controller;

import com.example.springcurd.entity.Hobies;
import com.example.springcurd.service.HobiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToOne;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/hobies")
public class HobiesController {
    @Autowired
    private HobiesService hobiesService;
    @PostMapping("/create")
    public ResponseEntity<Hobies> create(@RequestBody Hobies hobies){
        Hobies hobies1=this.hobiesService.create(hobies);
        return   new ResponseEntity<>( hobies1, HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public  ResponseEntity<Hobies> update(@RequestBody Hobies hobies,@PathVariable long id){
        Hobies hobies1=this.hobiesService.update(hobies, id);
        return new ResponseEntity<>(hobies1,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String ,String>> delete(@PathVariable long id ){
        this.hobiesService.delete(id);
        Map<String ,String> message = Map.of("message", " deleted successfully");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Hobies> getHobies(@PathVariable Hobies id) {
        Hobies hobies = this.hobiesService.getById(id);
        return new ResponseEntity<>(hobies,HttpStatus.OK);
    }
    //get all
    @GetMapping("/all")
    public ResponseEntity<List<Hobies>> getAll(){
        List<Hobies> all=this.hobiesService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
}
