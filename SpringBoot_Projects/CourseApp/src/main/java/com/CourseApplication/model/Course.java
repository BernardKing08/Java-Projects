package com.CourseApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//using lombok auto-gen feature
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	private int courseId; 
	private String title; 
	private String description; 
	private String link;
	
	
	public Course(String title, String description, String link) {
		this.title = title;
		this.description = description;
		this.link = link;
	}
	
	/*

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	*/
}
