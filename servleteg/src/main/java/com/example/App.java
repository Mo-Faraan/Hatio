package com.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * This is the entry point of the application that manually sets up an embedded Tomcat server.
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        // Step 1: Create a new Tomcat server instance
        // Step 2: Set the port on which the server will listen (e.g., http://localhost:8080)
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);


        // Step 3: Add a context to the Tomcat server
        // "" means root context (i.e., base path)
        // null means using default temp directory for deployment

        // Step 4: Register the servlet class to Tomcat
        // First param is context, second is servlet name, third is servlet instance
    
        // Step 5: Map a URL pattern to the servlet
        // This tells Tomcat to call Helloservlet when /hello is accessed
        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "Helloservlet", new Helloservlet());
        context.addServletMappingDecoded("/hello", "Helloservlet");


        // Step 6: Start the Tomcat server
        // Step 7: Keep the server running and waiting for requests
        tomcat.start();
        tomcat.getServer().await();
    }
}
