package com.mvcdemo.Mvc.Demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.mvcdemo.Mvc.Demo.entity.Student;
import com.mvcdemo.Mvc.Demo.repository.StudentRepository;
import com.mvcdemo.Mvc.Demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student create(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findById(int studentId) {
		return studentRepository.findOneById(studentId);
	}

	@Override
	public List<Student> findAll() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student updateById(int studentId, Student student) {
		Student existingStudent = this.findById(studentId);
		if (student != null) {
			if (!StringUtils.isEmpty(student.getFirstName())) {
				existingStudent.setFirstName(student.getFirstName());
			}
			if (!StringUtils.isEmpty(student.getLastName())) {
				existingStudent.setLastName(student.getLastName());
			}
			if (!StringUtils.isEmpty(student.getRollNo())) {
				existingStudent.setRollNo(student.getRollNo());
			}
			if (!CollectionUtils.isEmpty(student.getCourses())) {
				existingStudent.setCourses(student.getCourses());
			}
			return studentRepository.save(existingStudent);
		}
		return null;

	}

	@Override
	public void deleteById(long studentId) {
		studentRepository.deleteById(studentId);
	}

}
