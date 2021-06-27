package com.navigus.gamingapp.dto;

import java.io.Serializable;
import java.util.Date;
import static com.navigus.gamingapp.utils.Constants.PENDING;

public class GamingDTO implements Serializable {
	
	private String courseName;
	private String courseDesc;
	private String courseId;
	private String status;
	private Date date;
	
	private GamingDTO() {
		date= new Date();
		status= PENDING;
	}
	
	public GamingDTO(String courseName, String courseDesc, String courseId) {
		this();
		this.courseName= courseName;
		this.courseDesc= courseDesc;
		this.courseId=courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "gamingDTO [courseName=" + courseName + ", courseDesc=" + courseDesc + ", courseId=" + courseId
				+ ", status=" + status + ", date=" + date + "]";
	}

}
