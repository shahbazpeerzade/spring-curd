package com.example.springcurd.repository;

 import com.example.springcurd.entity.Hobies;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobieRepo extends JpaRepository<Hobies, Long> {
}
