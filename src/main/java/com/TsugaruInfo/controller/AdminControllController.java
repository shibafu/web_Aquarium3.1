package com.TsugaruInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * ログインコントローラー
 * UiSecurityConfigによって指定されたログインページを提供する。
 * @author pratula
 *
 */
@Controller
@RequestMapping(value = "/AdminController", method = RequestMethod.GET)
public class AdminControllController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("UserControll/AdminControll/usercontroll");
		return mv;
	}
}
