package com.navigus.gamingapp.dto;

import java.io.Serializable;
import java.util.Date;

public class TeacherDetailsDTO implements Serializable {
		int id;
		String name;
		String designation;
		String department;
		Date date;
		
		public TeacherDetailsDTO() {
			date= new Date();
		}
		public TeacherDetailsDTO(int teacherId, String teacherName, String teacherDesignation,String teacherDepartment) {
			this();
			this.id= teacherId;
			this.name= teacherName;
			this.designation= teacherDesignation;
			this.department= teacherDepartment;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		@Override
		public String toString() {
			return "TeacherDetailsDTO [id=" + id + ", name=" + name + ", designation=" + designation + ", department="
					+ department + ", date=" + date + "]";
		}		
}


