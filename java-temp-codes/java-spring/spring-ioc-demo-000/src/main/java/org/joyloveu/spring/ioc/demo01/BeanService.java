package org.joyloveu.spring.ioc.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanService {
	
	@Autowired
	BeanEntity beanService;
	
	public void sayHello() {
		
		beanService.sayHello("Jacob");
		
	}
}
