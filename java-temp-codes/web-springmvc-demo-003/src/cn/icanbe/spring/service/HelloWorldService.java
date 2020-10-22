package cn.icanbe.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloWorldService {


	public String getMsg() {
		return "Gradle + Spring MVC Hello World Example";
	}

	public String getTitle(String name) {
		if(StringUtils.isEmpty(name)){
			return "Hello World";
		}else{
			return "Hello " + name;
		}
	}

}