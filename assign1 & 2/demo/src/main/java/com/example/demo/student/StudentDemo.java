package com.example.demo.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDemo {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Tushar", 20, "Cpp", 4000.0));
		studentList.add(new Student("Kamal", 22, "Java", 2500.0));
		studentList.add(new Student("Rina", 22, "Php", 1000.0));
		System.out.println("List: "+studentList.toString());
		Collections.sort(studentList);
		System.out.println("List: "+studentList.toString());
	}
}
