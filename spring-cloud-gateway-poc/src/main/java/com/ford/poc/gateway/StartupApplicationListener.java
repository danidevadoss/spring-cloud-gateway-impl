package com.ford.poc.gateway;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import redis.embedded.RedisServer;

/**
 * This class will execute {@code onApplicationEvent } method once the spring
 * boot application started successfully. This is used to start Redis mock
 * service. This bean is not needed while building application. Use only for Dev
 * purpose
 */
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(StartupApplicationListener.class);

	/**
	 * Method is to start Redis mock service after application starts
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//RedisServer redisServer;
//		try {
//			LOG.info("Staring Redis mock service........");
//			//redisServer = new RedisServer(6379);
//			// Comment below code if service needs to be stopped
//			//redisServer.stop();
//			// Comment below code if service need not to be started
//			//redisServer.start();
//			LOG.info("Redis mock Started  successfully");
//		} catch (IOException e) {
//			LOG.info("Errror while starting Redis mock ={}", e);
//		}
	}
}