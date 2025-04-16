package com.example.jobapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jobapp.model.JobPost;
import com.example.jobapp.service.JobService;

@Controller
public class Jobcontroller {

    @Autowired
    private JobService service;

    @RequestMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("addjob") //http method specific variant of @RequestMapping
    public String addjob(){
        return "addjob";
    }
    
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addjob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewalljobs(Model m){
        List<JobPost> jobs = service.getalljobs();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
    
}
