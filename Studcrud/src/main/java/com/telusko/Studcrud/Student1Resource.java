package com.telusko.Studcrud;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("stud")
public class Student1Resource {

	Student1Repository repo=new Student1Repository();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Student1> getStudents()
	{
		return repo.getStudents();
	}
	
	@POST
	@Path("student")
	@Consumes(MediaType.APPLICATION_XML)
	public Student1 createStudent1(Student1 s1)
	{
		System.out.println(s1);
		repo.createStudent1(s1);
		return s1;
	}
	@PUT
	@Path("student")
	@Consumes(MediaType.APPLICATION_XML)
	public Student1 updateStudent1(Student1 s1)
	{
		System.out.println(s1);
		
		repo.update(s1);
		return s1;
	}
	
	@GET
	@Path("student/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student1 getStudent1(@PathParam("id") int id)
	
	{
		
		
		return repo.getStudent1(id);
		
	}
	
	@DELETE
	@Path("student/{id}")
	public Student1 deleteStudent(@PathParam("id") int id)
	{
		Student1 s1=repo.getStudent1(id);
		if(s1.getStudent1_no()!=0)
		{
			repo.delete(id);
		}
		return s1;
		
	}
}
