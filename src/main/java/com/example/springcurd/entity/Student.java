package com.example.springcurd.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )

     private long id;
     @OneToOne(cascade = CascadeType.ALL)
     private Hobies hobies;

    Student(){
        super();
    }

    public Student(String name, long id, Hobies hobies) {
        this.name = name;
        this.id = id;
        this.hobies = hobies;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Hobies getHobies() {
        return hobies;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobies(Hobies hobies) {
        this.hobies = hobies;
    }

}
