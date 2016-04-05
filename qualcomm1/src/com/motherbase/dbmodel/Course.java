package com.motherbase.dbmodel;

public class Course {
	private String courseName;
	private String courseNum;
	private String section;
	private String status;
	private String desc;
	private String code;
	// set as String here cause in db we have some value as '1 to 5'
	private String hours; 
	
	public void setCourseNum(String num){this.courseNum = num;}
	
	public void setSection(String section){this.section = section;}
	
	public void setStatus(String s){this.status = s;}
	
	public String getCourseNum() {return this.courseNum;}
	
	public String getSection() {return this.section;}
	
	public String getStatus() {return this.status;}
}
