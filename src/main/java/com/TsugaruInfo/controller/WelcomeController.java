package com.TsugaruInfo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/hello", method = GET)
	public String showMessage(){
		return "showMessage";
	}
}