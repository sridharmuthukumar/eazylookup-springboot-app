package com.elp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.elp" })
public class EazylookupSpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazylookupSpringbootAppApplication.class, args);
	}
}
