package com.TsugaruInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 画面開発用アクセスコントローラー
 * @author pratula
 *
 */
@Controller
@RequestMapping(value ="/development")
public class DisplayDevelopmentController {

	@RequestMapping(value = "/display")
	public ModelAndView develop1() {
		ModelAndView disp = new ModelAndView("Dev/topDev");

		return disp;
	}

}
