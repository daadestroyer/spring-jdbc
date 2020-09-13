package com.spring.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.Dao.StudentDao;
import com.spring.springjdbc.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbctemplate;

	public int insert(Student student) {
		String query = "insert into student(id,name,city) values (?,?,?)";
		int result = this.jdbctemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int change(Student student) {
		// updating data
		String query = "update student set name = ? , city = ? where id = ? ";
		int result = this.jdbctemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(int studentId) {
		// delete data
		String query = "delete from student where id = ? ";
		int res = this.jdbctemplate.update(query, studentId);
		return res;
	}

	public Student getStudent(int studentId) {
		// selecting single data
		String query = "select * from student where id = ? ";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbctemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		// selecting multiple student
		String query = "select * from student";
		List<Student> students = this.jdbctemplate.query(query, new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

}
