package com.example.demo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import com.example.demo.entity.Student;

@Service
public class StudentService {

	// mock to store
	private List<Student> stuDao = new ArrayList();
	
	//init
	{
		stuDao.add(new Student(1, "stuA", 11, "131........"));
		stuDao.add(new Student(2, "stuB", 12, "132........"));
		stuDao.add(new Student(3, "stuC", 13, "133........"));
	}

	public List<Student> getAllStudent() {
		return stuDao;
	}

	public Student getStudentById(int id) {
		List<Student> result = stuDao.stream()
				.filter(stu -> stu.getId() == id)
				.collect(Collectors.toList());
		return result.size() == 0 ? null : result.get(0);
	}
	
	private int getMinIdStudent(){
		return stuDao.stream().min(Comparator.comparing(stu->stu.getId())).get().getId();
	}
	
	private int getMaxInStudent() {
		return stuDao.stream().max(Comparator.comparing(stu->stu.getId())).get().getId();
	}
}
