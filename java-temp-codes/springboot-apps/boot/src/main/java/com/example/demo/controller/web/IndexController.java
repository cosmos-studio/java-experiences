package com.example.demo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.biz.IResLinkService;

@Controller
public class IndexController {

	@Autowired
	private IResLinkService resLinkService;

//	@RequestMapping("/")
//	public String index(Model m, @RequestParam(value="view", defaultValue="index") String view) {
//		return view;
//	}
	

	@RequestMapping(value = "/url/{id}", method = RequestMethod.GET)
	public ModelAndView url(@PathVariable("id") Integer id, Model m) {
		int count = resLinkService.queryCount();
		ModelAndView mv = new ModelAndView();
		mv.getModelMap().put("count", count);
		mv.setViewName("res/url/detail");
		return mv;
	}

}
