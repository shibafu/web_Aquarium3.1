package com.TsugaruInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/development")
public class DisplayDevelopmentController {

	@RequestMapping(value = "/display")
	public ModelAndView develop() {
		ModelAndView disp = new ModelAndView("dev");
		
		return disp;
	}


}
