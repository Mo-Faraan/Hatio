package com.example.jobapp.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok annotation = generates getter and setters
@NoArgsConstructor //default constructor
@AllArgsConstructor // all arg constructor
@Component
public class JobPost{
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
    

}