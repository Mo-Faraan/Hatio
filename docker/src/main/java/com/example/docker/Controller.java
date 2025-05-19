package com.example.docker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private Repo repo;

    @GetMapping("allStudents")
    public List<Student> getAllStudents(){
        return repo.findAll();

    }

    @GetMapping("addStudent")
    public void addStudent() {
        Student s = new Student();
        s.setName("farhan");
        s.setAge(22);
        repo.save(s);
    }
    
    
}
