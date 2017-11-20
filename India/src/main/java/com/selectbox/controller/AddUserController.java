package com.selectbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AddUserController {
	 String message = "Welcome to your 1st Maven Spring project !";  
	  
	    @RequestMapping("/hello")  
	    public String showMessage() {  
	        System.out.println("from controller");  
	        return "index";
	    }  
}
