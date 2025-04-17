package com.example.springdatajpa;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.repo.StudentRepo;

// STEP 1: Add dependencies for Spring Data JPA and PostgreSQL driver in pom.xml
// STEP 2: Add DB config in application.properties:
//   spring.datasource.url=jdbc:postgresql://localhost:5432/yourdbname
//   spring.datasource.username=yourusername
//   spring.datasource.password=yourpassword
//   spring.datasource.driver-class-name=org.postgresql.Driver
// Hibernate config :
//   spring.jpa.hibernate.ddl-auto=update  --> auto create/update tables based on entity

// STEP 3: Create your Entity class (e.g. Student) and annotate with @Entity and @Id for primary key
// STEP 4: Create a Repository interface extending JpaRepository<Entity, PrimaryKeyType>
// STEP 5: Inject repository and use built-in and custom methods

@SpringBootApplication // Combines @Configuration + @EnableAutoConfiguration + @ComponentScan
public class SpringdatajpaApplication {

	public static void main(String[] args) {

		// Bootstraps Spring context and returns ApplicationContext
		ApplicationContext context = SpringApplication.run(SpringdatajpaApplication.class, args);

		// Retrieving Student bean instances from Spring container
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		// Injecting repository bean to perform database operations
		StudentRepo repo = context.getBean(StudentRepo.class);

		// -------------------------- SAVE EXAMPLES --------------------------
		// Saving new entities - if primary key not present in DB, INSERT occurs
		// s1.setRno(101);
		// s1.setName("Navin");
		// s1.setMarks(75);

		// repo.save(s1);

		// s2.setRno(102);
		// s2.setName("Kiran");
		// s2.setMarks(80);

		// repo.save(s2);

		// s3.setRno(103);
		// s3.setName("Harsh");
		// s3.setMarks(70);
		
		// repo.save(s3);

		// -------------------------- FIND EXAMPLES --------------------------
		// Find all records
		// System.out.println((repo.findAll()));

		// Find by ID - returns Optional to handle null
		// Optional<Student> s = repo.findById(103);
		// System.out.println(s.orElse(new Student())); // if not found, returns new Student

		// Custom Finder Method - defined in Repo interface
		// System.out.println(repo.findByName("Navin")); // custom JPQL query
		// System.out.println(repo.findByMarks(80)); // derived query method
		// System.out.println(repo.findByMarksGreaterThan(72)); // with comparison operator

		// -------------------------- UPDATE EXAMPLE --------------------------
		// Updating an existing record (same rno = primary key)
		s2.setRno(102);
		s2.setName("Kiran");
		s2.setMarks(65);
		// repo.save(s2); // If record exists, performs UPDATE

		// -------------------------- DELETE EXAMPLE --------------------------
		repo.delete(s2); // Deletes record where rno=102 (using entity object)

		// -------------------------- DISPLAY FINAL DATA --------------------------
		System.out.println(repo.findAll()); // show remaining records
	}
}
