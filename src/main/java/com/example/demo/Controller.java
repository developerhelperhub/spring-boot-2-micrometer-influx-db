package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Controller {

	@Autowired
	private MyTableRepository rep;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void hello() {

		log.info("Loading....");
		
		rep.findAll().forEach(e -> {
			log.info("{} ----- {}", e.getId(), e.getName());
		});
		
		log.info("Loading Completed!");
	}
}
