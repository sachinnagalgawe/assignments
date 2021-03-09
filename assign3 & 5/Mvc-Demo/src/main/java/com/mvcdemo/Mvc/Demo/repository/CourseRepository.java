package com.mvcdemo.Mvc.Demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvcdemo.Mvc.Demo.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	public Course findOneById(Integer courseId);
}
