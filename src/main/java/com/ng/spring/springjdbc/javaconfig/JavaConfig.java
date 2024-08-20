package com.ng.spring.springjdbc.javaconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ng.spring.springjdbc.dao.StudentDaoImp;
import com.ng.spring.springjdbc.dao.StudentDaoInterface;

@Configuration
public class JavaConfig {

	@Bean("datasource")
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("Admin@123");

		return dataSource;

	}

	@Bean
	@Autowired
	public JdbcTemplate getTemplate(DataSource dataSource) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();

		jdbcTemplate.setDataSource(dataSource);

		return jdbcTemplate;

	}

	@Bean
	@Autowired
	public StudentDaoInterface getStudentDao(JdbcTemplate jdbcTemplate) {

		StudentDaoInterface studentDaoInterface = new StudentDaoImp(jdbcTemplate);

		return studentDaoInterface;

	}

}
