package com.spring.Dao;

import java.util.List;

import com.spring.springjdbc.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentId);
	public List<Student> getAllStudents();
}
