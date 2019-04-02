package com.llx.summer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Chapter313Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter313Application.class, args);
	}

}