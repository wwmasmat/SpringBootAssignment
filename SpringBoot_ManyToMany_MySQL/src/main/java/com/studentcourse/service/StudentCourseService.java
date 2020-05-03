package com.studentcourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentcourse.dao.StudentCourseDao;
import com.studentcourse.pojo.Student;

@Service
public class StudentCourseService {

	@Autowired
	private StudentCourseDao studentCourseDao;
	
	public Student addStudentWithCourse(Student locality) {
		return studentCourseDao.addStudentWithCourse(locality);
	}

	public Student findStudentById(Integer id) {
		return studentCourseDao.findStudentById(id);
	}

	public List<Student> findAllStudents() {
		return studentCourseDao.findAllStudents();
	}

	public Student updateStudent(Student locality) {
		return studentCourseDao.updateStudent(locality);
	}

	public List<Student> deleteStudent(Integer localityId) {
		return studentCourseDao.deleteStudent(localityId);
	}

}
