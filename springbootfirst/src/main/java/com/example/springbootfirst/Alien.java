package com.example.springbootfirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// @Component marks this class as a Spring-managed bean.
// During component scanning, Spring will detect this class and create an object (bean) of it automatically.
@Component
public class Alien {

    @Autowired //for wiring spring to create objects of other classes from a class. Automatically injects dependencies. Here, it injects the Laptop bean into Alien
    Laptop laptop;

    public void code(){
        laptop.code();
    }
    
}
