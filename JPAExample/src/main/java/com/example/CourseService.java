package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository cr;
	
	public void addCourse(Course c){
		cr.save(c);
	}
	
	public void delCourse(String id){
		cr.delete(id);
	}
	
	public Course getCourse(String id){
		return cr.findOne(id);
	}
	
}
