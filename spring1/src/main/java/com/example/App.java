package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //immediately creates beans of all classes in xml file

        // Alien obj = (Alien) context.getBean("alien2");
        // obj.age=21;
        // System.out.println(obj.age);

        // Alien obj2 = (Alien) context.getBean("alien2");
        // System.out.println(obj2.age);

        Alien obj = (Alien) context.getBean("alien3");
        System.out.println(obj.getAge());
    }
}
