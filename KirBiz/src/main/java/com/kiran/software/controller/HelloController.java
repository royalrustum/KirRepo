package com.kiran.software.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

@Controller
@RequestMapping("/hello")
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/message")
	public String display() {

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		StatusPrinter.print(lc);

		logger.info("Hi Nagarpamma");
		logger.debug("Hi Nagarpamma");

		System.out.println("God Nagarpamma");

		return "message";
	}

}
