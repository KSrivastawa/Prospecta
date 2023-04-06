package com.ketan.prospecta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProspectaInterviewApplication {

	@Bean
	public RestTemplate getTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate;		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProspectaInterviewApplication.class, args);
	}

}
