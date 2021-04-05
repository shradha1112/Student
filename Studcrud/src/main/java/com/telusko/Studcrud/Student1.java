package com.telusko.Studcrud;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student1 {
  private int student1_no;
  private String student1_name;
  private Date student1_dob;
  private Date student1_doj;
public int getStudent1_no() {
	return student1_no;
}
public void setStudent1_no(int student1_no) {
	this.student1_no = student1_no;
}
public String getStudent1_name() {
	return student1_name;
}
public void setStudent1_name(String student1_name) {
	this.student1_name = student1_name;
}
public Date getStudent1_dob() {
	return student1_dob;
}
public void setStudent1_dob(Date student1_dob) {
	this.student1_dob = student1_dob;
}
public Date getStudent1_doj() {
	return student1_doj;
}
public void setStudent1_doj(Date student1_doj) {
	this.student1_doj = student1_doj;
}
@Override
public String toString() {
	return "Student1 [student1_no=" + student1_no + ", student1_name=" + student1_name + ", student1_dob="
			+ student1_dob + ", student1_doj=" + student1_doj + "]";
}
  
  
  
}
