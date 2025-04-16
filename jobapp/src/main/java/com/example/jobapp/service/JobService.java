package com.example.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobapp.model.JobPost;
import com.example.jobapp.repo.JobRepo;

@Service
public class JobService {
    
    @Autowired
    public JobRepo repo;

    public void addjob(JobPost jobpost){
        repo.addjob(jobpost);
    }

    public List<JobPost> getalljobs(){
        return repo.getalljobs();
    }
}
