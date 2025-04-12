package com.example.springbootfirst.Repo;

import org.springframework.stereotype.Repository;

import com.example.springbootfirst.Model.Laptop;

@Repository
public class LaptopRepository {

    public void save(Laptop lap){
        System.out.println("Laptop saved");
    }
    
}
