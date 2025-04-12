package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("21")
    private int age;
    // @Autowired //field injection, constructor injection not preffered, setter injection preffered
    // @Qualifier("desktop")
    private Computer com;

    public Alien(){
        System.out.println("Alien obj created");
    }
    

    public Alien(int age, Computer com) {
        this.age = age;
        this.com = com;
    }

    public void code(){
        System.out.println("Coding...");
    }
    
    public void printcom(){
        com.compile();
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getcom() {
        return com;
    }
    @Autowired
    @Qualifier("desktop") //name is class name in lowercase
    public void setcom(Computer com) {
        this.com = com;
    }

    
}
