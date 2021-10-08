package com.target.training;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/hello")
@Slf4j
@SpringBootApplication
public class HelloServiceApplication {


	@GetMapping(produces = "application/json")
	public Map<String, Object> handleGetHelloMessage(
			@RequestParam(required = false, defaultValue = "friend") String name){
		log.debug("Received '{}' for name", name);
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("message", String.format("Hello, %s!", name));
		map.put("timestamp", new Date());
		map.put("success", true);

		log.debug("Responding to th clietn with {}");
		return map;

	}

	public static void main(String[] args) {

		log.debug("Starting HelloServiceApplication");
		SpringApplication.run(HelloServiceApplication.class, args);
		log.debug("HelloServiceApplication started");
	}

}
