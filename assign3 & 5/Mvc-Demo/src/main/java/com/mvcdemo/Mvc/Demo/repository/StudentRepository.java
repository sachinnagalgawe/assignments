package com.mvcdemo.Mvc.Demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvcdemo.Mvc.Demo.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	public Student findOneById(Integer studentId);

}
