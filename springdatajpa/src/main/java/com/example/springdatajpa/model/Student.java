package com.example.springdatajpa.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Scope("prototype")
@Entity // To create table from class
public class Student {

    @Id // to make rno primary key
    private int rno;
    private String name;
    private int marks;
    
    public int getRno() {
        return rno;
    }
    public void setRno(int rno) {
        this.rno = rno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
    @Override
    public String toString() {
        return "Student [rno=" + rno + ", name=" + name + ", marks=" + marks + "]";
    }

    
    
}
