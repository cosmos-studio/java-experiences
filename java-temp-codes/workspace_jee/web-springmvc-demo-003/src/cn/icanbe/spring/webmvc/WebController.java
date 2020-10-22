package cn.icanbe.spring.webmvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.icanbe.spring.service.HelloWorldService;

@Controller
public class WebController {

	private final HelloWorldService helloWorldService;

	@Autowired
	public WebController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		model.put("title", this.helloWorldService.getTitle("NO-Title."));
		model.put("msg", this.helloWorldService.getMsg());
		return "index";
	}

	@RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("name") String name) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", this.helloWorldService.getTitle(name));
		modelAndView.addObject("msg", this.helloWorldService.getMsg());
		return modelAndView;
	}
}
