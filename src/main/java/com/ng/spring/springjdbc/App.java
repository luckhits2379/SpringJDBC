package com.ng.spring.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ng.spring.springjdbc.dao.StudentDaoInterface;
import com.ng.spring.springjdbc.entity.Student;

public class App {
    
	public static void main( String[] args ){
        
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ng/spring/springjdbc/jdbc_config.xml");
		
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		
		String query = "insert into student values (?, ?, ?)";
		
		int res = template.update(query, null, "Nirmal", "Mumbai");
		
		System.out.println("Total record updated direct flow: "+ res);
		
		StudentDaoInterface studentdao = context.getBean("studentDao", StudentDaoInterface.class); //Note: we are passing interface
		
		Student student= new Student(0, "Charan", "Dabdi");
		
		res = studentdao.insert(student);
		
		System.out.println("Total record updated using DAO design pattern: "+ res);
		
		
    }
}
