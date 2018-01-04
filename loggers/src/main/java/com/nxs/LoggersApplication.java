package com.nxs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LoggersApplication {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/test")
	public String testLogLevel(){
		logger.debug("Logger Level : DEBUG");
		logger.info("Logger Level : INFO");
		logger.error("Logger Level : ERROR");
		return "";
	}

	public static void main(String[] args) {
		SpringApplication.run(LoggersApplication.class, args);
	}
}
