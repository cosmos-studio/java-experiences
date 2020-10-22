package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.User;

public interface UserService {
	int add(User user);

	int update(User user);

	int deleteByIds(String[] ids);

	User queryById(String user_id);

	List<User> queryAll();
}
