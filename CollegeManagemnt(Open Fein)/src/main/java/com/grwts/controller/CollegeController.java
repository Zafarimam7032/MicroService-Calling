package com.grwts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grwts.feign.implementation.FeignProxy;
import com.grwts.pojo.CollegeVo;

@RestController
public class CollegeController {
	@Autowired
	private FeignProxy feignProxy;
	
	@Autowired 
	private Environment environment;
	@GetMapping(path = "/feign")
	public CollegeVo display()
	{
		CollegeVo collegeVo = feignProxy.display();
	String property = environment.getProperty("local.server.port");
	System.out.println(property);
	collegeVo.setPort(property);
		return collegeVo;
	}

}
