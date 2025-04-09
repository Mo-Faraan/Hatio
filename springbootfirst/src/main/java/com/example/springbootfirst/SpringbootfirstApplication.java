package com.example.springbootfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootfirstApplication {

	public static void main(String[] args) {
		// SpringApplication.run() starts the Spring application and returns an ApplicationContext,
		// which is the container that manages all the beans (objects) in the application

		ApplicationContext context = SpringApplication.run(SpringbootfirstApplication.class, args);

		/*
		 * We are not using 'new Alien()' here.
		 * Instead, we're asking Spring's IoC container to give us an instance (a bean) of the Alien class.
		 * This is the core concept of Dependency Injection: let the framework manage the dependencies.
		 */

		Alien obj;
		obj = context.getBean(Alien.class); // Get the Alien bean from the Spring container
		obj.code();

	}

}
