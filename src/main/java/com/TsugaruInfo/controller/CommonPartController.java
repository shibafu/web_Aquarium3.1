package com.TsugaruInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * コモンパーツのコントローラー
 * @author pratula
 *
 */
@Controller
@RequestMapping(value ="/common")
public class CommonPartController {

	@RequestMapping(value = "/header")
	public ModelAndView develop1() {
		ModelAndView disp = new ModelAndView("common/header");

		return disp;
	}

}
