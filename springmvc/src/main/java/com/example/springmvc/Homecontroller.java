package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


// So here we are configuring spring mvc using xml configurations and manually without springboot using external tomcat server. 
// So install tomcat and add tomcat server runtime to the library. also add spring webmvc depenedency to pom file
// then we have to configure the tomcat server to look for the dispatcher servlet. for that  edit the web.xml file and add dispatcher servlet and map the url to 
// the dispatcher servlet.
// then we have to configure the dispatcher servlet by asking it to check the classes in the package and let it know we are using annotations in the dispatcher-servlet.xml
// then we have to configure the view resolver to properly handle the views (jsp files) in dispatcher_servlet.xml by adding its bean


@Controller 
public class Homecontroller {


    @RequestMapping("/")
    public String home(){
        return "index"; 
    }


    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num, @RequestParam("num2") int num2, ModelAndView mv){
        int result = num + num2;
        mv.addObject("result", result); 
        mv.setViewName("result");       
        return mv;
    }


    @RequestMapping("addalien")
    public String add(Alien alien){   //public String add(@ModelAttribute("addalien") Alien alien)
        return "alienresult";
    }


    @ModelAttribute("course")
    public String coursename(){
        return "java";
    }
}

