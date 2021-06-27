package com.navigus.gamingapp.dto;

import java.io.Serializable;
import java.util.Date;

public class StudentDetailsDTO implements Serializable {

	int rollNo;
	String name;
	int age;
	String collegeName;
	String stream;
	Date date;
	
	StudentDetailsDTO(){
		date=new Date();
	}
	public StudentDetailsDTO(int rollNo,String StudentName, int age, String streamD, String collegeName){
		this();
		this.rollNo= rollNo;
		this.name= StudentName;
		this.age= age;
		this.stream= streamD;
		this.collegeName= collegeName;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "StudentDetailsDTO [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", collegeName="
				+ collegeName + ", stream=" + stream + ", date=" + date + "]";
	}	
}
