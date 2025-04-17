package com.example.springbootrest.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootrest.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

        List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}

// public class JobRepo { // earlier, but we are using jpa in above
//     List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//         new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
// 	new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
// 	new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
// 	new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
// 	new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
//     ));

//     public List<JobPost> getalljobs(){
        
//         // return jobs;
//         return 
//     }

//     public void addjob(JobPost job){
//         jobs.add(job);
//     }
    
//     public JobPost getjob(int postId){
//         for(JobPost job : jobs){
//                 if (job.getPostId()==postId)
//                         return job;
//         }
//         return null;
//     }

//     public void updatejob(JobPost jobPost) {
//         for(JobPost job : jobs){
//                 if(job.getPostId() == jobPost.getPostId()){
//                         job.setPostDesc(jobPost.getPostDesc());
//                         job.setPostProfile(jobPost.getPostProfile());
//                         job.setPostTechStack(jobPost.getPostTechStack());
//                         job.setReqExperience(jobPost.getReqExperience());
//                 }
//         }
//     }

//     public void deletejob(int postId) {
//         for (JobPost job : jobs){
//                 if(job.getPostId() == postId)
//                         jobs.remove(job);
//         }
//     }
// }
