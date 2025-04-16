package com.example.jobapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1. add the dependencies : tomcat jasper, jstl api etc
// 2. add the views to main/webapp/views
// 3. configure the application.properties to set suffix and prefix to handle the jsp
// 4. Configure the controller @Controller and map the request @MapRequest
// 5. Create model and add the JobPost component. use lombok and add @Data, @NoArgsConstructor, @AllArgsConstructor
// 6. accept the post data through the @PostMapping in the controller by passsing the jobpost object
// 7. create the service layer to do processing
// 8. create repository layer to store the data 
// 9. we are creating DTO data transfer objects in the service, repo, conteroller layers



@SpringBootApplication
public class JobappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobappApplication.class, args);
	}

}
