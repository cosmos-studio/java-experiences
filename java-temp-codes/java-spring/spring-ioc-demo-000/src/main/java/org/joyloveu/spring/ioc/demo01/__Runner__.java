package org.joyloveu.spring.ioc.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class __Runner__ {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		BeanService beanService = context.getBean(BeanService.class);
		beanService.sayHello();
	}

}
