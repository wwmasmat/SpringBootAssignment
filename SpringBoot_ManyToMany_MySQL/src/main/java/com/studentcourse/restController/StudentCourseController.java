package com.studentcourse.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentcourse.pojo.Student;
import com.studentcourse.service.StudentCourseService;

@RestController
@RequestMapping("/studentCourse")
public class StudentCourseController {
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	@PostMapping("/add")
	public Student addStudentWithCourse(@RequestBody Student student) {
		return studentCourseService.addStudentWithCourse(student);
	}
	
	@GetMapping("/find/{id}")
	public Student findStudentById(@PathVariable Integer id) {
		return studentCourseService.findStudentById(id);
	}
	
	@GetMapping("/findAll")
	public List<Student> findAllStudents() {
		return studentCourseService.findAllStudents();
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentCourseService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Student> deleteStudent(@PathVariable("id") Integer studentId) {
		return studentCourseService.deleteStudent(studentId);
	}
}
