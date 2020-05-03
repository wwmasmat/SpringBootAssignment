package com.studentcourse.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentcourse.entity.CourseEntity;
import com.studentcourse.entity.StudentEntity;
import com.studentcourse.pojo.Course;
import com.studentcourse.pojo.Student;
import com.studentcourse.repository.CourseRepository;
import com.studentcourse.repository.StudentRepository;

@Repository
public class StudentCourseDao {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public Student addStudentWithCourse(Student student) {
		StudentEntity studentEntity = convertStudentToStudentEntity(student);
		courseRepository.saveAll(studentEntity.getCourseEntities());
		studentRepository.save(studentEntity);
		
		Optional<StudentEntity> studentEntityDb = studentRepository.findById(studentEntity.getId());
		if(studentEntityDb.isPresent()) {
			student = convertStudentEntityToStudent(studentEntityDb.get());
			return student;
		}
		return null;
	}

	public Student findStudentById(Integer id) {
		Optional<StudentEntity> studentEntity = studentRepository.findById(id);
		if(studentEntity.isPresent()) {
			return convertStudentEntityToStudent(studentEntity.get());
		}
		return null;
	}

	public List<Student> findAllStudents() {
		List<StudentEntity> studentEntityList = studentRepository.findAll();
		if(studentEntityList.size() > 0) {
			return studentEntityList.stream().map(studentEntity -> convertStudentEntityToStudent(studentEntity)).collect(Collectors.toList());
		}
		return null;
	}

	public List<Student> deleteStudent(Integer id) {
		Optional<StudentEntity> studentEntity = studentRepository.findById(id);
		if (studentEntity.isPresent()) {
			studentRepository.deleteById(id);
		}
		return findAllStudents();
	}

	public Student updateStudent(Student student) {
		Optional<StudentEntity> studentEntityOptional = studentRepository.findById(student.getId());
		if (studentEntityOptional.isPresent()) {
			StudentEntity studentEntity = studentEntityOptional.get();
			studentEntity.setStudentName(student.getStudentName());

			List<CourseEntity> courseEntities = new ArrayList<>();
			for (Course course : student.getCourseList()) {
				CourseEntity courseEntity = new CourseEntity();
				courseEntity.setCourseName(course.getCourseName());
				courseEntity.setCourseDuration(course.getCourseDuration());
				courseRepository.saveAndFlush(courseEntity);
				courseEntities.add(courseEntity);
			}

			studentEntity.setCourseEntities(courseEntities);
			studentRepository.saveAndFlush(studentEntity);
			
			studentEntityOptional = studentRepository.findById(student.getId());
			return convertStudentEntityToStudent(studentEntityOptional.get());
		}
		return null;
	}
	
	private static StudentEntity convertStudentToStudentEntity(Student student) {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentName(student.getStudentName());
		
		List<CourseEntity> courseEntities = student.getCourseList()
				.stream()
				.map(e-> convertCourseToCourseEntity(e,null))
				.collect(Collectors.toList());
		studentEntity.setCourseEntities(courseEntities);
		return studentEntity;	
	}

	
	 private static Student convertStudentEntityToStudent(StudentEntity studentEntity) {
			Student student = new Student();
			student.setId(studentEntity.getId());
			student.setStudentName(studentEntity.getStudentName());
			
			List<Course> courseList = studentEntity.getCourseEntities()
					.stream()
					.map(courseEntity-> convertCourseEntityToCourse(courseEntity))
					.collect(Collectors.toList());
			student.setCourseList(courseList);
			return student;
	 }
	 
	
	private static CourseEntity convertCourseToCourseEntity(Course course, CourseEntity courseEntity) {
		if(courseEntity == null) {
			courseEntity = new CourseEntity();
		}
		courseEntity.setId(course.getId());
		courseEntity.setCourseName(course.getCourseName());
		courseEntity.setCourseDuration(course.getCourseDuration());
		return courseEntity;
	}

	private static Course convertCourseEntityToCourse(CourseEntity courseEntity) {
		Course course = new Course();
		course.setId(courseEntity.getId());
		course.setCourseName(courseEntity.getCourseName());
		course.setCourseDuration(courseEntity.getCourseDuration());
		return course;
	}
}
