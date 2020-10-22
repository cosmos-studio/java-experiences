package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Url;

@RestController
public class HelloController {
	
	@Value("${msg.hello}")
	private String msg;
	
	@Autowired
	private Url url;
	
	@RequestMapping("/")
	public String sayHello() {
		System.out.println(url);
		return msg;
	}

}
