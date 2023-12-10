package com.obs.test;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@PostConstruct
	public void display() {
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("*     Application for Test OBS - Yusal Sumardi   *");
		System.out.println("*      Created at Sun, 10 Dec 23 - 20:26 WIB     *");
		System.out.println("*                                                *");
		System.out.println("**************************************************");
	}
}
