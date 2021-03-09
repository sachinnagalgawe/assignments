package com.example.demo.student;

public class Student implements Comparable<Student> {

	private String name;

	private Integer age;

	private String course;

	private Double salary;

	public Student(String name, Integer age, String course, Double salary) {
		super();
		this.name = name;
		this.age = age;
		this.course = course;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\n Student [name=" + name + ", age=" + age + ", course=" + course + ", salary=" + salary + "]";
	}

	// Compare by salary
//	@Override
//	public int compareTo(Student o) {
//		int salaryDiff = salary.compareTo(o.salary);
//		return salaryDiff;
//	}

	// Compare by name
	@Override
	public int compareTo(Student o) {
        // Name compare to
		int nameDiff = name.compareToIgnoreCase(o.name);
		return nameDiff;
		
	}
}
