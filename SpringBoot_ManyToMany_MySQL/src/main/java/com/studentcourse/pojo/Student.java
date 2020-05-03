package com.studentcourse.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private Integer id;
	private String studentName;
	private List<Course> courseList;
	

}
