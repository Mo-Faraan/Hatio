package com.example.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// additionally here we are adding spring data jpa (editing the repository layer)
//1. add jpa and driver dependencies in pom file
//2. update the repository layer as interface extending the JpaRepository<Entity, primary key type> 
// 3. make postId as primary key using @Id and add @Entity in model
// 4. configure applocation.properties by adding db and hibernate config
// 5. change custom repo methods to jpa methods


@SpringBootApplication
public class SpringbootrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestApplication.class, args);
	}

}
