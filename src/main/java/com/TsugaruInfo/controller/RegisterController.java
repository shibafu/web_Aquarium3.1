package com.TsugaruInfo.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TsugaruInfo.entity.UserMaster;
import com.TsugaruInfo.repository.UserMasterRepository;

@Controller
public class RegisterController {

	@Autowired
	UserMasterRepository uRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(){
		ModelAndView mv = new ModelAndView("register");
		
		return mv;
	}
	
	@RequestMapping(value = "/register_complete", method = RequestMethod.GET)
	public ModelAndView registerComplete(){
		ModelAndView mv = new ModelAndView("register_complete");
		
		UserMaster res = new UserMaster();
		
		res.setUserId(1);
		res.setUsername("aaa");
		res.setPassword("pass");
		res.setEmail("aa@aaa");
		res.setEnabled(true);
		
		uRepository.saveAndFlush(res);
		
		return mv;
	}
}