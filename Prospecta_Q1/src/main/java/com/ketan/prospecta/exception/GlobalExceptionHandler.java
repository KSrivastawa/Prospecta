package com.ketan.prospecta.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntryException.class)
	public ResponseEntity<MyError> entryExceptionHandler(EntryException exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exceptionHandler(Exception exception, WebRequest request){
		
		MyError error = new MyError(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);		
	}
	
	
}
