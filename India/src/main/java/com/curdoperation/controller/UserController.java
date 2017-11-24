package com.curdoperation.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curdoperation.bo.UserBo;
import com.curdoperation.dao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
@Controller
public class UserController {
	 
	 @Autowired
	 private UserDao userdao;
	    @RequestMapping("/hello")
	    @ResponseBody
	    public String showMessage() {  
	        System.out.println("from controller");  
	        return "index";
	    } 
	    @RequestMapping(value="/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE) 
	    @ResponseBody
	    public ResponseEntity<String> addUser(@RequestBody UserBo userbo) { 
	    	/*
	    	UserBo bo=new UserBo();
	    	bo.setfName("Rajanikanta");
	    	bo.setlName("Pradhan");
	    	bo.setGender("Male");
	    	bo.setState("Odisha");
	    	bo.setZip("761125");
	    	bo.setMobile("8895247580");
	    	bo.setPassword("wellcome1");
	    	bo.setEmail("rajani769@gmail.com");*/
	    	System.out.println(userbo);
	        System.out.println("from controller");
	        System.out.println(userdao.saveUser(userbo));
	        return new ResponseEntity<String>("User Added Successfully",HttpStatus.OK);
	    }
	    
	    @RequestMapping(value="/finduser",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public ResponseEntity<UserBo> findUserByMail() throws JsonProcessingException { 
	    	
	    	
	        System.out.println(userdao.findUser("rajani769@gmail.com"));
	        
	       /* 
	        ObjectMapper mapper = new ObjectMapper();

				//Convert object to JSON string
				String jsonInString = mapper.writeValueAsString(userdao.findUser("rajani769@gmail.com"));
				System.out.println(jsonInString);

				//Convert object to JSON string and pretty print
				//jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
	        */
	        
	        return new ResponseEntity<UserBo>(userdao.findUser("rajani769@gmail.com"), HttpStatus.OK);
	        
	       // return userdao.findUser("rajani769@gmail.com");
	    }
	    
	    @RequestMapping("/getallusers") 
	    public ResponseEntity<List<UserBo>> getAllUsers() throws JsonProcessingException { 
	       /* System.out.println(userdao.getUsers());
	        ObjectMapper mapper=new ObjectMapper();
	      String jsonInString = mapper.writeValueAsString(userdao.getUsers());*/
	     return new ResponseEntity<List<UserBo>>(userdao.getUsers(),HttpStatus.OK);
	    }
	    
	    @RequestMapping(value="/addUser",method=RequestMethod.GET)
	  
	    public String saveUser(@RequestParam(value = "fname", required = false) String fname) {  
	        System.out.println("adduser controller");  
	        System.out.println(fname);
	       // System.out.println(state);
	        return "addUser";
	    }
	    @RequestMapping(value="selectlist",method=RequestMethod.GET)
	    @ResponseBody
	    public List<String> fetchStates(){
	    	System.out.println("Select List");
	    	List<String> states=new ArrayList<>();
	    	states.add("Odisha");
	    	states.add("Telengana");
	    	states.add("Andrapradesh");
	    	states.add("Maharastra");
	    	states.add("Bihar");
	    	states.add("UttarPradesh");
	    	return states;
	    }
	    
}
