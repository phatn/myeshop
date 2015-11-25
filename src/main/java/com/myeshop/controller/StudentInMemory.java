package com.myeshop.controller;

import java.util.ArrayList;
import java.util.List;

public enum StudentInMemory {
	INSTANCE;
	private static int lastId = 0;
	
	private static List<Student> students = new ArrayList<>();
	
	private int getId() {
		return lastId++;
	}
	
	public void add(Student student) {
		student.setId(getId());
		students.add(student);
	}
	
	public List<Student> findAll() {
		return students;
	}
	
	public Student findById(int id) {
		for(Student student : students) {
			if(student.getId() == id)
				return student;
		}
		return null;
	}
}
