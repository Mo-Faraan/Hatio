package com.example.springbootfirst.Model;

import org.springframework.stereotype.Component;

@Component //(value = "lap")
public class Laptop implements Computer {
    public void code(){
        System.out.println("Laptop Compiling...");
    }
}
