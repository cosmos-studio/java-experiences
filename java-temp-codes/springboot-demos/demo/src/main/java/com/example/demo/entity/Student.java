package com.example.demo.entity;

public class Student {
	
	public Student(int id, String name, int age, String phone){
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	private int id;
	private String name;
	private int age;
	private String phone;

	public int getId() {
		System.out.println(id);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
