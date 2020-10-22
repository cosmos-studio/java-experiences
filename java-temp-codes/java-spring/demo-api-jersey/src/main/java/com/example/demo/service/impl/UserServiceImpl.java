package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDaoMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoMapper userDao;

	@Override
	public int add(User user) {
		return userDao.add(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public int deleteByIds(String[] ids) {
		return userDao.deleteByIds(ids);
	}

	@Override
	public User queryById(String user_id) {
		return userDao.queryById(user_id);
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

}
