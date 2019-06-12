package com.ford.poc.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller
 * @author DDEVADO1
 */
@RestController
public class TestController {

	@RequestMapping(value = "/local-test",method = RequestMethod.GET)
	public String test() {
		return "test";
	}
}
