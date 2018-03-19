package com.TsugaruInfo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/", method = GET)
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	
	@RequestMapping(value = "/index", method = GET)
	public ModelAndView index_url(){
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
}