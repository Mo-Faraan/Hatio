package com.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Desktop implements Computer {
    public Desktop(){
        System.out.println("Desktop obj created");
    }
    public void compile(){
        System.out.println("Desktop Compiling...");
    }
    
}
