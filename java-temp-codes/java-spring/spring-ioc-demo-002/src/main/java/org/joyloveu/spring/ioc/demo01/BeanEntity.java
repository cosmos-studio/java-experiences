package org.joyloveu.spring.ioc.demo01;

import org.springframework.stereotype.Service;

@Service
public class BeanEntity {

	public void sayHello(String sth) {
		System.out.println("Hello " + sth);
	}

}
