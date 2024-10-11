package com.bhim.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/greetmng/{name}")
	public String greetMsg(@PathVariable("name")  String name) {
		return name + "good morning";
	}
	
	
	
	
	@GetMapping("/greet/{name}")
	public String getGreetMsg(@PathVariable("name") String name) {
		String msg = name + ", Good Morning..!!";
		return msg;
	}
	
	

	@GetMapping("/greet")
	public String getMethodName(@RequestParam String str) {
		return str;
	}

//	localhost:9090/login?username=bheema&password=12345&email=bheema@gmail.com
	@GetMapping("/login")
	public String login(@RequestParam String username, @RequestParam String  password , @RequestParam String email) {
		return   username+"   "+password+" "+email;
	}
	
	@GetMapping(value = "/msg", produces = "text/plain")
	public ResponseEntity<String> getMsg() {
		String msg = "Welcome to Andhra pradeshT";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	
}
