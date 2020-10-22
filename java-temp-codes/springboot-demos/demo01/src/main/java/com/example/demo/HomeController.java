package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index(Model m, @RequestParam(value = "view", defaultValue = "index") String view) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(view);
		return mv;
	}

}
