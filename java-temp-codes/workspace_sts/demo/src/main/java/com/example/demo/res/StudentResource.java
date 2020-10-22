package com.example.demo.res;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Component
@Path("res")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

	@Autowired
	private StudentService service;

	@Path("student")
	@GET
	public List<Student> listStudent() {
		return service.getAllStudent();
	}

	@Path("student/{id}")
	@GET
	public Student findStudentById(@PathParam("id") int id) {
		return service.getStudentById(id);
	}

}
