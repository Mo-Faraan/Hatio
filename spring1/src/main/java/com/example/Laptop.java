package com.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class Laptop implements Computer {

    public Laptop(){
        System.out.println("Laptopobj created");
    }

    @Override
    public void compile(){
        System.out.println("Laptop compiling...");
    }
    
}
