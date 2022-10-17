package com.example.springcurd.entity;

import javax.persistence.*;

@Entity
@Table(name = "hobies")
public class Hobies{
    @Column(name = "hobies_name")
    private String hobiesname;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long hobiesid;

      Hobies(){
        super();
    }

    public Hobies(String hobiesname, long hobiesid) {
        this.hobiesname = hobiesname;
        this.hobiesid = hobiesid;
    }

    public String getHobiesname() {
        return hobiesname;
    }

    public void setHobiesname(String hobiesname) {
        this.hobiesname = hobiesname;
    }

    public long getHobiesid() {
        return hobiesid;
    }

    public void setHobiesid(long hobiesid) {
        this.hobiesid = hobiesid;
    }


}
