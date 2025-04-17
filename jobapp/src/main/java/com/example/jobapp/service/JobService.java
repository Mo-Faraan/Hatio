package com.example.jobapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobapp.model.JobPost;
import com.example.jobapp.repo.JobRepo;

@Service
public class JobService {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
	new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
	new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
	new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
	new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
    ));
    
    @Autowired
    public JobRepo repo;

    public void addjob(JobPost jobpost){
        repo.addjob(jobpost);
    }

    public List<JobPost> getalljobs(){
        return repo.getalljobs();
    }
}
