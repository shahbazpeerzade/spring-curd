package com.example.springcurd.service;

import com.example.springcurd.entity.Hobies;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HobiesService {
    Hobies create(Hobies hobies);
    Hobies update(Hobies hobies ,long id);
    void delete(long id);
    Hobies getById(Hobies hobies);
    Hobies getById(long id);


    List<Hobies> getAll ();


}
