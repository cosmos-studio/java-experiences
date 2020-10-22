package com.example.demo.biz;

import java.util.List;

import com.example.demo.domain.ResLink;

public interface IResLinkService {
	public ResLink queryRawUrl(Integer id);
	public Integer queryCount();
	public List<ResLink> queryRawUrlByPage(int pageNum, int pageSize);
	public void addResLink(ResLink resLink);
}
