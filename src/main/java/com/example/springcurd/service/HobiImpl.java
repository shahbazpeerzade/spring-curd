package com.example.springcurd.service;

import com.example.springcurd.entity.Hobies;
 import com.example.springcurd.repository.HobieRepo;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component

public class HobiImpl implements HobiesService  {
    public HobiImpl(HobieRepo hobieRepo) {
        this.hobieRepo = hobieRepo;
    }


    @Autowired
    private HobieRepo hobieRepo;


    @Override
    public Hobies create(Hobies hobies) {
        return this.hobieRepo.save(hobies);
    }

    @Override
    public Hobies update(Hobies hobies, long id) {
        Hobies hobies1 = this.hobieRepo.findById(id).orElseThrow(
                () -> new RuntimeException(" not found"));
        hobies1.setHobiesname(hobies.getHobiesname());
        hobies1.setHobiesid(hobies.getHobiesid());
         this.hobieRepo.save(hobies1);
        Hobies save = this.hobieRepo.save(hobies1);
        return save;

    }

    @Override
    public void delete(long id) {
        Hobies hobies1 = this.hobieRepo.findById(id).orElseThrow(
                () -> new RuntimeException(" not found  "));

        this.hobieRepo.delete(hobies1);


    }

    @Override
    public Hobies getById(Hobies hobies) {

        return hobies;
    }
    @Override
    public Hobies getById(long id) {
        Hobies hobie1 = this.hobieRepo.findById(id).orElseThrow(
                () -> new RuntimeException(" not found  "));
        return hobie1;
    }

    @Override
    public List<Hobies> getAll() {
        List<Hobies> all = this.hobieRepo.findAll();
        return all;
    }

}
