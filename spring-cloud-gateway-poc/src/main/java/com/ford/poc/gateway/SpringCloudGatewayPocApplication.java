package com.ford.poc.gateway;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

/**
 * Spring cloud gateway POC
 * @author DDEVADO1
 */
@SpringBootApplication
public class SpringCloudGatewayPocApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCloudGatewayPocApplication.class, args);
	}

	/**
	 * This is custom KeyResolver which is used as key resolver for storing information
	 * related to request in Redis
	 * 
	 * @return KeyResolver
	 */
	//@Bean
	KeyResolver customKeyResolver() throws IOException {
		return exchange -> Mono.just("key");
	}

	/**
	 * This is request header KeyResolver which uses USER_ID key in header, if
	 * USER_ID is not present in request then 500 error will be thrown
	 * 
	 * @return KeyResolver
	 */
	@Bean
	KeyResolver requestHeaderKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getHeaders().getFirst("USER_ID"));
	}

}
