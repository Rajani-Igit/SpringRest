package com.curdoperation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.curdoperation.bo.UserBo;
import com.curdoperation.dao.UserDao;
@Controller
public class UserController {
	 String message = "Welcome to your 1st Maven Spring project !";  
	 
	 private UserDao userdao;
	    @RequestMapping("/hello")  
	    public String showMessage() {  
	        System.out.println("from controller");  
	        return "index";
	    } 
	    @RequestMapping("/add")  
	    public String addUser() { 
	    	userdao=new UserDao();
	    	UserBo bo=new UserBo();
	    	bo.setfName("Rajanikanta");
	    	bo.setlName("Pradhan");
	    	bo.setGender("Male");
	    	bo.setState("Odisha");
	    	bo.setZip("761125");
	    	bo.setMobile("8895247580");
	    	bo.setPassword("wellcome1");
	        System.out.println("from controller");
	        System.out.println(userdao.saveUser(bo));
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
