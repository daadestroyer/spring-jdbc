package com.spring.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

 
@Configuration
@ComponentScan(basePackages = {"com.spring.DaoImpl"})
public class JdbcConfig {
	@Bean(name = {"ds"} )
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("shubham");
		ds.setPassword("shubham");
		return ds;
	}
	@Bean(name = { "jdbcTemplate" })
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	/*
	@Bean(name = {"studentDao"})
	public StudentDao getStudentDao() {
		StudentDaoImpl studentdao = new StudentDaoImpl();
		studentdao.setJdbctemplate(getTemplate());
		return studentdao;
	}
	*/
	
}
