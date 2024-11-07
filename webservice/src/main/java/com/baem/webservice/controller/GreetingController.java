package com.baem.webservice.controller;

import com.baem.webservice.restservice.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("요청이 들어오면 이부분이호출된다.");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}	
	
	@GetMapping("/path")
	public ResponseEntity<String> getMethodName(@RequestParam(value = "someName", defaultValue = "good") String name) {
		return new ResponseEntity<String>("1234", HttpStatus.OK);
	}
	
	@GetMapping("/goods")
	public Good getGood(@RequestParam String name) {
		System.out.println("here");
		return new Good("Good", 30);
	}

	
	static class Good {
		String name;
		int age;
		
		public Good() {
			
		}
		public Good(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		//getter setter 설정이 안되어 있으면406 Not Acceptable 오류 나옴.
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
}