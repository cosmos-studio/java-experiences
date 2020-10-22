package com.example.demo.res;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hi")
public class HiResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> hi() {
		return Arrays.asList("hello spring boot", "Jersey-json");
	}
}
