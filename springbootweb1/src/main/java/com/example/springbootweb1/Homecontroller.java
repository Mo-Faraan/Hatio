package com.example.springbootweb1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

/**
 * ➤ Spring MVC Flow in this controller:
 * Client Request (HTTP) → DispatcherServlet → Controller (this class) → View (JSP)
 */

@Controller // spring looks for controller to map the url and do processing
public class Homecontroller {

    // Default home route that loads index.jsp

    @RequestMapping("/")
    public String home(){
        return "index"; // Logical view name -> resolved to /views/index.jsp via application.properties
                        // We are adding spring.mvc.views.prefix and suffix properties in application properties and changing views to their names
    }

    /*
     * ➤ MVC Pattern with Different Approaches
     * 
     * Model       - carries data between controller and view (Model, ModelAndView, HttpSession)
     * View        - JSP pages (result.jsp, alienresult.jsp)
     * Controller  - this Java class handles URL mappings, user input, logic, and data transfer to view
     */

    // --[Old Approach using HttpServletRequest]-----------------------------------------
    // Not recommended anymore, more verbose and tightly coupled with servlet API
    
    // @RequestMapping("add")
    // public String add(HttpServletRequest req, HttpSession session){
    //
    //     int num1 = Integer.parseInt(req.getParameter("num1"));
    //     int num2 = Integer.parseInt(req.getParameter("num2"));
    //     int result = num1 + num2;
    //
    //     session.setAttribute("result", result);
    //     return "result";
    // }

    // Instead of HttpServletRequest, we use @RequestParam to directly extract parameters from the URL
    // If the parameter name in the URL matches the method argument, @RequestParam is optional for that param

    // @RequestMapping("add")
    // public String add(@RequestParam("num1") int num, int num2, HttpSession session){
    //     int result = num + num2;
    //     session.setAttribute("result", result);
    //     return "result";
    // }

    // Better approach: use `Model` to pass values to the view instead of using HttpSession
    // Model is part of the Spring Web MVC and is more decoupled from servlet API

    // @RequestMapping("add")
    // public String add(@RequestParam("num1") int num, int num2, Model model){
    //     int result = num + num2;
    //     model.addAttribute("result", result);
    //     return "result"; 
    // }

    // Best Practice: Use ModelAndView which wraps both view and model into one object

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView mv){
        int result = num + num2;
        mv.addObject("result", result); // Adds data to the model
        mv.setViewName("result");       // Sets logical view name to result.jsp
        return mv;
    }

    // --[Alien Form Submission]----------------------------------------------------------
    
    // Instead of passing individual form inputs, we can accept a full object (Alien) and Spring will map fields automatically
    // This is called **Data Binding** using POJOs — Spring binds form fields to matching properties in the Java object

    // Old manual approach:
    
    // @RequestMapping("addalien")
    // public ModelAndView add(@RequestParam("aid") int aid, String aname, ModelAndView mv){
    //     Alien alien = new Alien();
    //     alien.setAid(aid);
    //     alien.setAname(aname);
    //
    //     mv.addObject("alien", alien);
    //     mv.setViewName("alienresult");
    //     return mv;
    // }

    // Cleaner approach using @ModelAttribute or directly accepting the object
    // If the form field names match the object field names, no need for @ModelAttribute
    // Spring automatically adds the object to the model with the key "alien"

    @RequestMapping("addalien")
    public String add(Alien alien){   //add(@ModelAttribute("addalien") Alien alien)
        return "alienresult";
    }

    // @ModelAttribute (method-level) to add a common attribute to the model for every request
    // This adds the "course" variable with value "java" to the model for all views returned by this controller

    @ModelAttribute("course")
    public String coursename(){
        return "java";
    }
}

