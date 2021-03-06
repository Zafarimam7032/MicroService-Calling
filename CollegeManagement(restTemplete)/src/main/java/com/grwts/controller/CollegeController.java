package com.grwts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.grwts.pojo.CollegeVo;

@RestController
public class CollegeController {
	@Autowired
	 private RestTemplate restTemplate;
	@GetMapping(path = "/college")
	public CollegeVo display()
	{
		CollegeVo collegeVo = restTemplate.getForObject("http://localhost:8080/student", CollegeVo.class);
		 new CollegeVo(1,"Zafar Imam","New Delhi");
		 return collegeVo;
	}

}
