package com.tan.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studentsRecord")
public class Students {
	
	@Id
	private int rollno;
	private String name;
	private String enrollmentno;
	private String projecttopic;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnrollmentno() {
		return enrollmentno;
	}
	public void setEnrollmentno(String enrollmentno) {
		this.enrollmentno = enrollmentno;
	}
	public String getProjecttopic() {
		return projecttopic;
	}
	public void setProjecttopic(String projecttopic) {
		this.projecttopic = projecttopic;
	}
		

}
