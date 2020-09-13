package com.spring.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 
 
import com.spring.Dao.StudentDao;

 
public class App {
	public static void main(String[] args) {
		System.out.println("My Program Started.....");
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao sd = context.getBean("studentDao", StudentDao.class);
		Student student = new Student();
		 /*
		student.setId(555);
		student.setName("kshitij");
		student.setCity("kanpur");
		int res = sd.insert(student);
		System.out.println("student added "+res);
		  */
		
		 /*
		student.setId(333);
		student.setName("newname");
		student.setCity("newcity");
		int change = sd.change(student);
		System.out.println("data updated "+change);
		 */
		
		 /*
		int res = sd.delete(444);
		System.out.println("data deleted "+res);
		 */
		
		List<Student> students = sd.getAllStudents();
		for(Student s : students) {
			System.out.println(s);
		}
	}
}
