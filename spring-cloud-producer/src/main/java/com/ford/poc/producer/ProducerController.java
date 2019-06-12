package com.ford.poc.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Producer controller that is used as data provider for other microservices.
 * used for microservice communication
 * 
 * @author DDEVADO1
 */
@RestController
public class ProducerController {

	@GetMapping("test-path")
	public String testPath() {
		return "Test path Success...!";
	}

	@GetMapping("test-before-time")
	public String testBeforeTime() {
		return "Test before time Success...!";
	}

	@GetMapping("test-before-time-fail")
	public String testBeforeTimeFail() {
		return "ERROR: Test before time failed";
	}

	@GetMapping("test-request-rate-limit")
	public String requestRateLimiter() {
		return "Success..!";
	}
}
