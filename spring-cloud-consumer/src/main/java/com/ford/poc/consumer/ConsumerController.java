package com.ford.poc.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	 private final String URI = "http://localhost:8080/hello";
	 
	 RestTemplate restTemplate = new RestTemplate();   
	
	@GetMapping("/test-gateway")
	public String testGateway() {
		
		 return restTemplate.getForObject(URI, String.class);
	}
	
}
