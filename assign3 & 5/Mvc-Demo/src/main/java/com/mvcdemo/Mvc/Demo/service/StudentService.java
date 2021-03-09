package com.mvcdemo.Mvc.Demo.service;

import java.util.List;

import com.mvcdemo.Mvc.Demo.entity.Student;

public interface StudentService {

	public Student create(Student student);

	public List<Student> findAll();

	public Student findById(int studentId);

	public Student updateById(int studentId, Student student);

	public void deleteById(long studentId);
}
