package com.example;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@Autowired
	private CourseService cs;
	
	@RequestMapping(method=RequestMethod.POST,value="/courses")
	public void addCourse(@RequestBody Course c){
		cs.addCourse(c);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/courses/{id}")
	public Course getCourse(@PathParam("id") String id){
		return cs.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/courses/{id}")
	public void delCourse(@PathParam("id") String id){
		cs.delCourse(id);
	}
}
