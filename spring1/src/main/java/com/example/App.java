package com.example;

import java.text.NumberFormat.Style;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Desktop desk = context.getBean("desktop",Desktop.class);
        // desk.compile();
        // Desktop desk1 = context.getBean("desktop",Desktop.class);
        // desk1.compile();

        Alien alien = context.getBean("alien",Alien.class);
        System.out.println(alien.getAge());
        alien.printcom();
        
        
        
        
        
        
        
        
        
        
        
        
        // XML CONFIG :
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //immediately creates beans of all classes in xml file

        // Alien obj = (Alien) context.getBean("alien2");
        // obj.age=21;
        // System.out.println(obj.age);

        // Alien obj2 = (Alien) context.getBean("alien2");
        // System.out.println(obj2.age);

        // Alien obj = (Alien) context.getBean("alien6");
        // System.out.println(obj.getAge());
        // obj.printcom();

        // Desktop desk = context.getBean("com",Desktop.class); 
        // Laptop lap = context.getBean(Laptop.class); 
        //creating bean by type, selectes bean with primary true if there are multiple beans of same type

    
    }
}
