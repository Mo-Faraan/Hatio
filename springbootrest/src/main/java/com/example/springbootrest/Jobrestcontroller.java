package com.example.springbootrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrest.model.JobPost;
import com.example.springbootrest.service.JobService;

@RestController //tells spring that the mappings return state rather than view
@CrossOrigin(origins = "http://localhost:3000") //security constraint; to allow requestst from this url
public class Jobrestcontroller {

    @Autowired
    private JobService service;

    @GetMapping(path="jobPosts", produces = {"application/json"}) //content negotiation. the jackson inbuilt dependency will automatically convert java objects to json while returning.
    // we can add jackson xml dependency to convert it into xml format. in that case we can tell spring that this method will ONLY return json data by using path, produces
//  @ResponseBody used for returning data to the server. tells spring we are returning data and not view. dont need as we are using @RestController
    public List<JobPost> getalljobs(){
        return service.getalljobs();
    }
    
    @GetMapping("jobPost/{postId}") //passing values through the url (Different from query parameters (?id=...) and we used @RrequestParm)
    public JobPost getjobpost(@PathVariable("postId") int postId){ //accepting values from the url use @PathVariable
        return service.getjob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> keywordsearch(@PathVariable("keyword") String keyword){
        return service.getjobsbykeyword(keyword);
    }


    
    @PostMapping(path = "jobPost", consumes = {"application/xml", "application/json"}) // similarly can also specify what content the post mapping should recieve as part of content negotiation.
    public JobPost addjobpost(@RequestBody JobPost jobPost){ //@RequestBody tells Spring to deserialize incoming JSON/XML to JobPost object. used to send data to the server in json format.
        service.addjob(jobPost);
        return service.getjob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updatejob(@RequestBody JobPost jobPost){
        service.updatejob(jobPost);
        return service.getjob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deletejob(@PathVariable int postId){
        service.deletejob(postId);
        return "deleted";
    }

    @GetMapping("load")
    public String loaddata(){
        service.loaddata();
        return "Data loaded";
    }
}
