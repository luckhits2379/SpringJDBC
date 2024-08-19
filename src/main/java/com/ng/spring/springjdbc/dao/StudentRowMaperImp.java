package com.ng.spring.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ng.spring.springjdbc.entity.Student;

public class StudentRowMaperImp implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAddress(rs.getString("address"));
		
		return student;
	}

}
