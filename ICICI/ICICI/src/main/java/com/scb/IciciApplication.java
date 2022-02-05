package com.scb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.scb")
@EnableAutoConfiguration
@EnableCaching
public class IciciApplication {

	public static void main(String[] args) {
		SpringApplication.run(IciciApplication.class, args);
	}

}
