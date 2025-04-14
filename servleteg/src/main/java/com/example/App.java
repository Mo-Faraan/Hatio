package com.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "Helloservlet", new Helloservlet());
        context.addServletMappingDecoded("/hello", "Helloservlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
