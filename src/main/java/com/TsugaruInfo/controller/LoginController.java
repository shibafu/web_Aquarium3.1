package com.TsugaruInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TsugaruInfo.formmodel.RegisterForm;

@Controller
public class LoginController {

//	/**
//	 * フォームセッション追加
//	 * @return
//	 */
//	@ModelAttribute(name = "RegisterForm")
//	public RegisterForm initForm(){
//		RegisterForm registerForm = new RegisterForm();
//		return registerForm;
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView login_authenticate() {
//		ModelAndView mv = new ModelAndView("login");
//		return mv;
//	}
}
