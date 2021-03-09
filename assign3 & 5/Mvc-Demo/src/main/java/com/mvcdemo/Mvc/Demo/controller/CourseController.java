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

import com.mvcdemo.Mvc.Demo.entity.Course;
import com.mvcdemo.Mvc.Demo.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	/**
	 * Course service
	 */
	@Autowired
	private CourseService courseService;

	/**
	 * Create course
	 * 
	 * @param course
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Course createCourse(@RequestBody Course course) {
		logger.info("Api call received to Create Course");
		return courseService.create(course);
	}

	/**
	 * Get all courses
	 * 
	 * @return
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getAllCourses() {
		logger.info("Api call received to get all Courses");
		return courseService.findAll();
	}

	/**
	 * Get course by id
	 * 
	 * @param courseId
	 * @return
	 */
	@GetMapping(value = "/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Course getCourseById(@PathVariable("courseId") int courseId) {
		logger.info("Api call received to get Course by id: " + courseId);
		return courseService.findById(courseId);
	}

	/**
	 * Update course by id
	 * 
	 * @param courseId
	 * @param course
	 * @return
	 */
	@PutMapping(value = "/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Course updateCourseById(@PathVariable("courseId") int courseId, @RequestBody Course course) {
		logger.info("Api call received to update Course by id: " + courseId);
		return courseService.updateById(courseId, course);
	}

	/**
	 * Delete course by id
	 * 
	 * @param courseId
	 */
	@DeleteMapping(value = "/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCourseById(@PathVariable("courseId") int courseId) {
		logger.info("Api call received to delete Course by id: " + courseId);
		courseService.deleteById(courseId);
	}

}
