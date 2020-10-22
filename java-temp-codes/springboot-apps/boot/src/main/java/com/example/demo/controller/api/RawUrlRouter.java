package com.example.demo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.biz.IResLinkService;
import com.example.demo.domain.ResLink;

@RestController
@RequestMapping("api/url/")
public class RawUrlRouter {
	
	@Autowired
	private IResLinkService rawUrlService;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResLink queryById(@PathVariable("id") Integer id) {
		return this.rawUrlService.queryRawUrl(id);
	}
	
	@RequestMapping(value="count", method=RequestMethod.GET)
	public Integer queryCount() {
		return this.rawUrlService.queryCount();
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public List<ResLink> queryListByPage(@RequestParam("page") int pageNum, @RequestParam("size") int pageSize) {
		return this.rawUrlService.queryRawUrlByPage(pageNum, pageSize);
	}

}
