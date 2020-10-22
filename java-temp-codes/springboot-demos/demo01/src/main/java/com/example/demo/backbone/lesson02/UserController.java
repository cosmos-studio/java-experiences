package com.example.demo.backbone.lesson02;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/")
public class UserController {

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") String id) {
		User user = new User();
		user.setName("小白兔");
		user.setAge(5);
		user.setAddr("西安市");
		return user;
	}

}
