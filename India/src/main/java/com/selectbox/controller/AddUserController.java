package com.selectbox.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class AddUserController {
	 String message = "Welcome to your 1st Maven Spring project !";  
	  
	    @RequestMapping("/hello")  
	    public String showMessage() {  
	        System.out.println("from controller");  
	        return "index";
	    } 
	    @RequestMapping("/add")  
	    public String addUser() {  
	        System.out.println("from controller");  
	        return "addUser";
	    }
	    
	    @RequestMapping(value="/addUser",method=RequestMethod.GET)
	  
	    public String saveUser(@RequestParam(value = "fname", required = false) String fname) {  
	        System.out.println("adduser controller");  
	        System.out.println(fname);
	       // System.out.println(state);
	        return "addUser";
	    }
	    
}
