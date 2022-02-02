package com.ebill.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHome()
	{
		return "success";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getTest()
	{
		return "success";
	}

}
