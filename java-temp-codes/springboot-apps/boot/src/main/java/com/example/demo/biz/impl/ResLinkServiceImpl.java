package com.example.demo.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.biz.IResLinkService;
import com.example.demo.dao.ResLinkDao;
import com.example.demo.domain.ResLink;

@Service
public class ResLinkServiceImpl implements IResLinkService {
	
	@Autowired
	private ResLinkDao rawUrlDao;

	@Override
	public ResLink queryRawUrl(Integer id) {
		return this.rawUrlDao.queryRawUrlById(id);
	}

	@Override
	public Integer queryCount() {
		return this.rawUrlDao.queryCount();
	}

	@Override
	public List<ResLink> queryRawUrlByPage(int pageNum, int pageSize) {
		return this.rawUrlDao.queryRawURLByPage(pageNum-1, pageSize);
	}

	@Override
	public void addResLink(ResLink resLink) {
		this.rawUrlDao.add(resLink);
	}

}
