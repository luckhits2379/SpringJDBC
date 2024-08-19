package com.ng.spring.springjdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ng.spring.springjdbc.entity.Student;

public class StudentDaoImp implements StudentDaoInterface {
	
	
	JdbcTemplate template;
	

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
	@Override
	public int insert(Student student) {

		String query = "insert into student values (?, ?, ?)";
		
		String id = student.getId()==0 ? null : String.valueOf(student.getId());

		int res = template.update(query, id, student.getName(), student.getAddress());

		return res;
	}

}
