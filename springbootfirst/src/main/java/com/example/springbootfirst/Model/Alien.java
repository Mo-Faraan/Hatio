package com.example.springbootfirst.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// @Component marks this class as a Spring-managed bean.
// During component scanning, Spring will detect this class and create an object (bean) of it automatically.
@Component
public class Alien {

    // @Autowired for wiring spring to create objects of other classes from a class. Automatically injects dependencies. Here, it injects the Laptop bean into Alien
    private Computer com;
    @Value("25")
    private int age;

    public void code(){
        com.code();
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    @Qualifier("laptop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    
}
