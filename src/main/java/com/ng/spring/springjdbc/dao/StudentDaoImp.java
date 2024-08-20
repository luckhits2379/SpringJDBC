package com.ng.spring.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ng.spring.springjdbc.entity.Student;

public class StudentDaoImp implements StudentDaoInterface {

	JdbcTemplate template;

	
	public StudentDaoImp(JdbcTemplate jdbcTemplate) {
		template = jdbcTemplate;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int insert(Student student) {

		String query = "insert into student values (?, ?, ?)";

		String id = student.getId() == 0 ? null : String.valueOf(student.getId());

		int res = template.update(query, id, student.getName(), student.getAddress());

		return res;
	}

	@Override
	public int update(Student student) {

		String query = "update student set name= ?, address = ? where id = ?";

		int res = template.update(query, student.getName(), student.getAddress(), student.getId());

		return res;

	}

	@Override
	public int delete(int studentId) {

		String query = "delete from student where id = ?";

		int res = template.update(query, studentId);

		return res;

	}

	@Override
	public Student get(int studentId) {

		String query = "select * from student where id = ?";

		return template.queryForObject(query, new StudentRowMaperImp(), studentId);
	}

	@Override
	public List<Student> getAll() {
		
		String query = "select * from student";

		List<Student> res = template.query(query, new StudentRowMaperImp());
		
		return res;
	}

}
