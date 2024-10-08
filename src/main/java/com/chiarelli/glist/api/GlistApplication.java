package com.chiarelli.glist.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlistApplication {
	public static void main(String[] args) {
		SpringApplication.run(GlistApplication.class, args);
	}

	//TODO: add CORS configuration: CorsFilter..
}
