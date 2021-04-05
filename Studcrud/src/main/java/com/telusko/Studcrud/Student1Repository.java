package com.telusko.Studcrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Student1Repository {

	
	Connection con=null;
	public Student1Repository()
	{
		String url="jdbc:mysql://localhost:3306/stud1restdb";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection(url, username, password);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public List<Student1> getStudents() {
		// TODO Auto-generated method stub
		List<Student1> students=new ArrayList<Student1>();
		String sql="Select * from Student1";
		Statement st;
		try {
			st=con.createStatement();
		
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			Student1 a=new Student1();
			a.setStudent1_no(rs.getInt(1));
			a.setStudent1_name(rs.getString(2));
			a.setStudent1_dob(rs.getDate(3));
			a.setStudent1_doj(rs.getDate(4));
			
			students.add(a);
			
		}
		}
		
	 catch(Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return students;
		
		
		
		
	}
	
	public void createStudent1(Student1 s1)
	{
		String sql="Insert into student1 values(?,?,?,?)";
		PreparedStatement st;
		
		try {
			st=con.prepareStatement(sql);
		
		st.setInt(1, s1.getStudent1_no());
		st.setString(2, s1.getStudent1_name());
		try{
		st.setDate(3,  new java.sql.Date(s1.getStudent1_dob().getTime()));
		st.setDate(4, new java.sql.Date(s1.getStudent1_doj().getTime()));
		}
		catch(ClassCastException e){	
			System.out.println("catched");
			e.printStackTrace();}

		st.executeUpdate();
	}
		catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}

public 	void update(Student1 s1)
{
	String sql="update student1 set student1_name=?,student1_dob=?,student1_doj=? where student1_no=?";
	PreparedStatement st;
	try {
		st=con.prepareStatement(sql);
	 
	st.setString(1, s1.getStudent1_name());
	st.setDate(2, new java.sql.Date(s1.getStudent1_dob().getTime()));
	st.setDate(3, new java.sql.Date(s1.getStudent1_doj().getTime()));
	st.setInt(4, s1.getStudent1_no());
	st.executeUpdate();
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public Student1 getStudent1(int id) 

{
	List<Student1> students=new ArrayList<>();
	String sql="select * from student1 where student1_no="+id;
	Student1 a=new Student1();
	Statement st;
	try {
		st = con.createStatement();
	
	ResultSet rs=st.executeQuery(sql);
	
	if(rs.next())
	{
		
		a.setStudent1_no(rs.getInt(1));
		a.setStudent1_name(rs.getString(2));
		a.setStudent1_dob(rs.getDate(3));
		a.setStudent1_doj(rs.getDate(3));

	}}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;
}	
public void delete(int id)
{
	String sql="Delete from student1 where student1_no=?";
	PreparedStatement st;
	try {
		st=con.prepareStatement(sql);
	
	st.setInt(1, id);
			st.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
}


