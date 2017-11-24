package com.curdoperation.exceptions;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curdoperation.bo.UserBo;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionResolver {
	
	
	
	@ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
	@ResponseBody
	public ErrorMessage exceptionreolver(MySQLIntegrityConstraintViolationException ex){
		System.out.println("MySQLIntegrityConstraintViolationException");
		return new ErrorMessage(ex.getMessage(),"405");
	}
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorMessage exceptionreolver(Exception ex){
		return new ErrorMessage(ex.getMessage(),"405");
		
	} 
    

}
