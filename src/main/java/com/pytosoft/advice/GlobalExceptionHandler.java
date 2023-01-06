package com.pytosoft.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pytosoft.exception.ResourceNotFoundException;
import com.pytosoft.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<String> handleIndexOutOfBound(IndexOutOfBoundsException boundsException)
	{
		return new ResponseEntity<String>("the data length is too high for this", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException exception)
	{
		ErrorResponse response = new ErrorResponse(exception.getMessage(),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}

}
