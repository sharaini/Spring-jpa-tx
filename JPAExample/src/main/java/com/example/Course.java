package com.example;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	public String id;
	public String name;
	public String professor;
	Course(){
		
	}
	Course(String id,String name,String prof){
		this.id=id;
		this.name=name;
		this.professor=prof;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
}
