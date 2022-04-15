package com.spring.rest.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.demo.entity.Student;
import com.spring.rest.demo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/student")
public class StudentController {
	List<Student> students;

	@PostConstruct
	public void retrieveStudents() {
		students = new ArrayList<Student>();
		students.add(new Student("Prashant", "Ranjan"));
		students.add(new Student("Ritik", "Kumar"));
		students.add(new Student("Gaurav", "Ray"));
	}

	@GetMapping("/")
	public List<Student> getAllStudents() {
		return this.students;
	}

	@GetMapping("/{studentId}")
	public Student getTheStudent(@PathVariable int studentId) {

		if (studentId < 0 || studentId >= students.size()) {
			throw new StudentNotFoundException("Student is not found of Id : " + studentId);
		}
		return this.students.get(studentId);
	}

// this exception is specific for this class only 
//	@ExceptionHandler
//	public ResponseEntity<ErrorResponse> handleError(StudentNotFoundException exc) {
//
//		ErrorResponse error = new ErrorResponse();
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//
//		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
//	}
//
//	@ExceptionHandler
//	public ResponseEntity<ErrorResponse> handleGenericExc(Exception exc) {
//
//		ErrorResponse error = new ErrorResponse();
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//
//		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
//	}

}
