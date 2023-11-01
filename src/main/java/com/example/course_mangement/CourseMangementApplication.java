package com.example.course_mangement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class CourseMangementApplication {
	public static void main(String[] args) {
		SpringApplication.run(CourseMangementApplication.class, args);
	}

	@Autowired
	MethodOperations aMethodOperations;


	@GetMapping("/test")
	//@Transactional
	void testData() throws Exception {
		aMethodOperations.test2();
	}



}
