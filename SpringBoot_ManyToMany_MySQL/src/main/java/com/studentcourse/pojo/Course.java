package com.studentcourse.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	private Integer id;
	private String courseName;
	private Integer courseDuration;
	private List<Student> studentList;

}
