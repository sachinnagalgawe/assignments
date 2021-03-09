package com.mvcdemo.Mvc.Demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.mvcdemo.Mvc.Demo.entity.Course;
import com.mvcdemo.Mvc.Demo.repository.CourseRepository;
import com.mvcdemo.Mvc.Demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course create(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course findById(int courseId) {
		return courseRepository.findOneById(courseId);
	}

	@Override
	public List<Course> findAll() {
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public Course updateById(int courseId, Course course) {
		Course existingCourse = this.findById(courseId);
		if (course != null) {
			if (!StringUtils.isEmpty(course.getCourseName())) {
				existingCourse.setCourseName(course.getCourseName());
			}
			if (!CollectionUtils.isEmpty(course.getStudents())) {
				existingCourse.setStudents(course.getStudents());
			}
			return courseRepository.save(existingCourse);
		}
		return null;

	}

	@Override
	public void deleteById(long courseId) {
		courseRepository.deleteById(courseId);
	}

}
