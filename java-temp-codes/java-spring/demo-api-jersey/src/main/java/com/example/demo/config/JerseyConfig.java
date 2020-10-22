package com.example.demo.config;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;

import com.example.demo.res.HiResource;
import com.example.demo.res.UserResource;

@Named
public class JerseyConfig extends ResourceConfig {
	// public JerseyConfig() { packages("com.activenetwork.demo.res"); }

	public JerseyConfig() {
		register(HiResource.class);
		register(UserResource.class);
	}

}
