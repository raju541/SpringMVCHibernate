package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = "com.cts")
@EnableAutoConfiguration
@EnableCaching
public class HdfcApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdfcApplication.class, args);
	}

}
