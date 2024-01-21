package com.deepak.springjdbc;

import com.deepak.springjdbc.model.Student;
import com.deepak.springjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setId(104);
		student.setName("deepak");
		student.setMarks(95);
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(student);
		List<Student> students = service.getStudents();
		System.out.println(students);
	}
}
