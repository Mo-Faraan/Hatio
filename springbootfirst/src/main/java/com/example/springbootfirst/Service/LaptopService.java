package com.example.springbootfirst.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootfirst.Model.Laptop;
import com.example.springbootfirst.Repo.LaptopRepository;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laprepo;

    public void add(Laptop laptop){
        laprepo.save(laptop);
    
    }

    public boolean isgoodforprog(Laptop lap){
        return true;
    }
    
}
