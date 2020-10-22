package com.example.demo.res;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("res")
public class RestResource {

	@Path("hello")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> hello(){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg","successful.");
		return map;
	}
}
