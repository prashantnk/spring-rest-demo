package com.spring.rest.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.rest.demo.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandlers {
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleError(StudentNotFoundException exc) {

		ErrorResponse error = new ErrorResponse();
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleGenericExc(Exception exc) {

		ErrorResponse error = new ErrorResponse();
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setStatus(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
