package com.zkteco.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException we, WebRequest req){
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),we.getMessage(),req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception we, WebRequest req){
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),we.getMessage(),req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
	
	
}
