package com.ng.spring.springjdbc.dao;

import java.util.List;

import com.ng.spring.springjdbc.entity.Student;

public interface StudentDaoInterface {
	
	public int insert(Student student);
	
	public int update(Student student);
	
	public int delete(int studentId);
	
	public Student get(int studentId);
	
	public List<Student> getAll();
}
