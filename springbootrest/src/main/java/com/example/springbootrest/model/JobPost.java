package com.example.springbootrest.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok annotation = generates getter and setters
@NoArgsConstructor //default constructor
@AllArgsConstructor // all arg constructor
@Component
@Entity
public class JobPost{
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
    

}