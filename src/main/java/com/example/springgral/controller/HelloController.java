package com.example.springgral.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springgral.config.HelloConfig;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	private HelloConfig config;
	
    private ResourceLoader resourceLoader;
    
	public HelloController(HelloConfig config, ResourceLoader resourceLoader) {
		this.config = config;
		this.resourceLoader = resourceLoader;
	}
	
	@GetMapping(path="/hello")
	public String hello() {
		
		return "Hello "+config.getHello()+"=="+config.getGreeting();
	}
	@GetMapping(path="/read-file")
	public String readFile() throws IOException {
		Resource resource = resourceLoader.getResource(config.getFile());

		InputStream input = resource.getInputStream();
		
		return "file content => "+ IOUtils.toString(input, StandardCharsets.UTF_8);
	}
	
	@GetMapping(path="/password")
	public String password() {
		
		return "password => "+ config.getPassword();
	}
}
