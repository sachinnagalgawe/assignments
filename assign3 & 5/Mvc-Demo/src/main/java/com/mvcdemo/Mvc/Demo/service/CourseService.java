package com.mvcdemo.Mvc.Demo.service;

import java.util.List;

import com.mvcdemo.Mvc.Demo.entity.Course;

public interface CourseService {

	public Course create(Course course);

	public List<Course> findAll();

	public Course findById(int courseId);

	public Course updateById(int courseId, Course course);

	public void deleteById(long courseId);

}
