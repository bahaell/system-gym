package com.gymsystem.gymsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
	@GetMapping(value = "/testController")
	public String testController() 
	{
		return "bonjour baahaa ell !!!!!!!! ";
	}

}
