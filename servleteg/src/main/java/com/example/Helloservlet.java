package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends HttpServlet and overrides the doGet() method.
 * It is used to handle GET requests sent to the /hello endpoint.
 */
public class Helloservlet extends HttpServlet {

     // This method is automatically called when a GET request is made to /hello
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        System.out.println("servlet running");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2><b>Hello Worrrld!</h2></b>");

        //1.  Log a message to the console when the servlet is hit
        //2.  Set the response content type to HTML
        // 3. Get a PrintWriter object to write the response body
        // 4. Send a simple HTML response to the browser
    }

    
    
}

