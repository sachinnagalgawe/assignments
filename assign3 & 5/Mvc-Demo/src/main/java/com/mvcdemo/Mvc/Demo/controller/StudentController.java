package com.mvcdemo.Mvc.Demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvcdemo.Mvc.Demo.entity.Student;
import com.mvcdemo.Mvc.Demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	/**
	 * Student service
	 */
	@Autowired
	private StudentService studentService;

	/**
	 * Create student
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student createStudent(@RequestBody Student student) {
		logger.info("Api call received to Create Student");
		return studentService.create(student);
	}

	/**
	 * Get all students
	 * 
	 * @return
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() {
		logger.info("Api call received to get all Students");
		return studentService.findAll();
	}

	/**
	 * Get student by id
	 * 
	 * @param studentId
	 * @return
	 */
	@GetMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentById(@PathVariable("studentId") int studentId) {
		logger.info("Api call received to get Student by id: " + studentId);
		return studentService.findById(studentId);
	}

	/**
	 * Update student by id
	 * 
	 * @param studentId
	 * @param student
	 * @return
	 */
	@PutMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudentById(@PathVariable("studentId") int studentId, @RequestBody Student student) {
		logger.info("Api call received to update Student by id: " + studentId);
		return studentService.updateById(studentId, student);
	}

	/**
	 * Delete student by id
	 * 
	 * @param studentId
	 */
	@DeleteMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudentById(@PathVariable("studentId") int studentId) {
		logger.info("Api call received to delete Student by id: " + studentId);
		studentService.deleteById(studentId);
	}

}
