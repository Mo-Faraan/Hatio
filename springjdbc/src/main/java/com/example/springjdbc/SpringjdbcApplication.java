package com.example.springjdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springjdbc.model.Student;
import com.example.springjdbc.service.StudentService;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringjdbcApplication.class, args);
		Student s = context.getBean(Student.class);
		s.setRno(101);
		s.setName("farhan");
		s.setMarks(100);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);
		
		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
