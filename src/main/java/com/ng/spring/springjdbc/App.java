package com.ng.spring.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ng.spring.springjdbc.dao.StudentDaoInterface;
import com.ng.spring.springjdbc.entity.Student;

public class App {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ng/spring/springjdbc/jdbc_config.xml");

		JdbcTemplate template = context.getBean(JdbcTemplate.class);

		// ------------Normal Flow---------------------

		String query = "insert into student values (?, ?, ?)";

		int res = template.update(query, null, "Nirmal Gurjar", "Mumbai");

		System.out.println("Total record inserted direct flow: " + res);

		// ------------DAO Flow Insert---------------------

		StudentDaoInterface studentdao = context.getBean("studentDao", StudentDaoInterface.class); // Note: we are
																									// passing interface

		Student student = new Student(0, "Charan", "Dabdi");

		res = studentdao.insert(student);

		System.out.println("Total record inserted using DAO design pattern: " + res);

		// ------------DAO Flow Update---------------------

		Student studentUpdate = new Student(1, "Charan", "Dabdi");

		res = studentdao.update(studentUpdate);

		System.out.println("Total record updated using DAO design pattern: " + res);

		// ------------DAO Flow Delete---------------------

		res = studentdao.delete(1);

		System.out.println("Total record deleted using DAO design pattern: " + res);

		// ------------DAO Flow Select for Single row using query for
		// object---------------------

		Student std = studentdao.get(10);

		System.out.println("Record fetched using DAO design pattern: " + std);

		// ------------DAO Flow Select for List of Student row using
		// query---------------------

		List<Student> studentList = studentdao.getAll();

		for (Student stdnt : studentList) {

			System.out.println("Records List fetched using DAO design pattern: " + stdnt);

		}

	}
}
