package com.TsugaruInfo.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TsugaruInfo.entity.UserMaster;
import com.TsugaruInfo.formmodel.RegisterForm;
import com.TsugaruInfo.repository.UserMasterRepository;
import com.TsugaruInfo.service.UserService;

@RequestMapping(value = "/register")
@Controller
@SessionAttributes(types = RegisterForm.class)
public class RegisterController {

	@Autowired
	UserService uService;
	
	/**
	 * フォームセッション追加
	 * @return
	 */
	@ModelAttribute(name = "RegisterForm")
	public RegisterForm initForm(){
		RegisterForm registerForm = new RegisterForm();
		/*
		初期設定
		*/
		return registerForm;
	}
	
	/**
	 * 登録フォーム
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView register(){
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public ModelAndView registerConfirm(@Valid RegisterForm registerForm,
			BindingResult result,
			Model model
			){
		ModelAndView mv = new ModelAndView("register_confirm");
		
		UserMaster res = new UserMaster();
		res.setUsername(registerForm.getUsername());
		res.setPassword(registerForm.getPassword());
		res.setEmail(registerForm.getEmail());
		res.setEnabled(true);
		
		//入力チェック
		if(result.hasErrors()) {
			return new ModelAndView("register");
		} else if(uService.judgeRegisterdUser(res) == 1) {
			return new ModelAndView("register");
		}
		
		//表示用ダミーをセット
		UserMaster dummyDisplay = new UserMaster();

		dummyDisplay.setUsername(registerForm.getUsername());
		dummyDisplay.setPassword(uService.dummyPassword(registerForm.getPassword()));
		dummyDisplay.setEmail(registerForm.getEmail());
		dummyDisplay.setEnabled(true);
		
		model.addAttribute("dummyDisplay", dummyDisplay);

		return mv;
	}
	
	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	public ModelAndView registerComplete(RegisterForm registerForm,
			Model model){
		ModelAndView mv = new ModelAndView("register_complete");
		
		//登録ユーザー情報をセット
		UserMaster res = new UserMaster();
		res.setUsername(registerForm.getUsername());
		res.setPassword(registerForm.getPassword());
		res.setEmail(registerForm.getEmail());
		res.setEnabled(true);
		
		uService.register(res);
		
		return mv;
	}
}