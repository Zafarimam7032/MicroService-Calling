package com.grwts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.grwts.pojo.CollegeVo;

@RestController
public class CollegeController {
	
	@Autowired
	private WebClient.Builder webBuilder;
	
	@GetMapping(path = "/college")
	public CollegeVo display()
	{
		CollegeVo collegeVo = webBuilder.build()
		.get()
		.uri("http://localhost:4040/student")
		.retrieve()
		.bodyToMono(CollegeVo.class)
		.block();
		
		 return collegeVo;
	}

}
