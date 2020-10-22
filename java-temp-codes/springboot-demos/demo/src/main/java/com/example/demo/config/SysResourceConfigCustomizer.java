package com.example.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.jersey.ResourceConfigCustomizer;
import org.springframework.stereotype.Component;

import com.example.demo.res.RestResource;

@Component
public class SysResourceConfigCustomizer implements ResourceConfigCustomizer {

	@Override
	public void customize(ResourceConfig config) {
		// config.register(RestResource.class);
		config.packages("com.example.demo.res");
	}

}
