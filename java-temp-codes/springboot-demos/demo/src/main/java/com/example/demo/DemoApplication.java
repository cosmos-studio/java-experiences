package com.example.demo;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public ResourceConfig resourceConfig() {
		return new ResourceConfig();
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
