package com.curdoperation.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curdoperation.bo.UserBo;
import com.curdoperation.dao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
@RestController
public class UserController {
	 String message = "Welcome to your 1st Maven Spring project !";  
	 
	 @Autowired
	 private UserDao userdao;
	    @RequestMapping("/hello")
	    @ResponseBody
	    public String showMessage() {  
	        System.out.println("from controller");  
	        return "index";
	    } 
	    @RequestMapping("/add") 
	    @ResponseBody
	    public String addUser() { 
	    	
	    	UserBo bo=new UserBo();
	    	bo.setfName("Rajanikanta");
	    	bo.setlName("Pradhan");
	    	bo.setGender("Male");
	    	bo.setState("Odisha");
	    	bo.setZip("761125");
	    	bo.setMobile("8895247580");
	    	bo.setPassword("wellcome1");
	    	bo.setEmail("rajani769@gmail.com");
	        System.out.println("from controller");
	        System.out.println(userdao.saveUser(bo));
	        return "addUser";
	    }
	    
	    @RequestMapping(value="/finduser",method = RequestMethod.GET, headers="Accept=*/*",  produces=MediaType.APPLICATION_JSON_VALUE)
	   
	    public UserBo findUserByMail() throws JsonProcessingException { 
	    	
	    	
	        System.out.println(userdao.findUser("rajani769@gmail.com"));
	        
	       /* 
	        ObjectMapper mapper = new ObjectMapper();

				//Convert object to JSON string
				String jsonInString = mapper.writeValueAsString(userdao.findUser("rajani769@gmail.com"));
				System.out.println(jsonInString);

				//Convert object to JSON string and pretty print
				//jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
	        */
	        
	        
	        return userdao.findUser("rajani769@gmail.com");
	    }
	    
	    @RequestMapping("/getallusers") 
	    @ResponseBody
	    public List<UserBo> getAllUsers() throws JsonProcessingException { 
	       /* System.out.println(userdao.getUsers());
	        ObjectMapper mapper=new ObjectMapper();
	      String jsonInString = mapper.writeValueAsString(userdao.getUsers());*/
	     return userdao.getUsers();
	    }
	    
	    @RequestMapping(value="/addUser",method=RequestMethod.GET)
	  
	    public String saveUser(@RequestParam(value = "fname", required = false) String fname) {  
	        System.out.println("adduser controller");  
	        System.out.println(fname);
	       // System.out.println(state);
	        return "addUser";
	    }
	    
}
