package com.example.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootrest.model.JobPost;
import com.example.springbootrest.repo.JobRepo;

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

    public JobPost getjob(int postId){
        return repo.getjob(postId);
    }

    public void updatejob(JobPost jobPost) {
        repo.updatejob(jobPost);
    }

    public void deletejob(int postId) {
        repo.deletejob(postId);
    }
}
