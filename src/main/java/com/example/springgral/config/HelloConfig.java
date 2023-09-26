package com.example.springgral.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class HelloConfig {
	
	@Value("${hello}")
	private String hello;
	
	@Value("${greeting}")
	private String greeting;
	
	@Value("${file}")
	private String file;
	
	@Value("${password}")
	private String password;

}
