package com.TsugaruInfo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TsugaruInfo.entity.UserMaster;
import com.TsugaruInfo.form.ErrorMessageForm;
import com.TsugaruInfo.form.RegisterForm;
import com.TsugaruInfo.service.MessageLoaderService;
import com.TsugaruInfo.service.UserService;

/**
 * ユーザー登録コントローラー
 * ユーザーの登録を行う
 * @author pratula
 *
 */
@RequestMapping(value = "/register")
@Controller
@SessionAttributes(types = RegisterForm.class)
public class RegisterController {

	@Autowired
	UserService uService;

	//@Autowired
	MessageLoaderService messageLoader;

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
	public ModelAndView register(@ModelAttribute("errorCount")String ErrorCount,
			@ModelAttribute("errorMap")ModelMap modelMap){

		ErrorMessageForm errorObj = (ErrorMessageForm) modelMap.get("errorObject");

		ModelAndView mv = new ModelAndView("UserControll/Register/register");
		return mv;
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public ModelAndView registerConfirm(@Valid RegisterForm registerForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttribute
			){
		ModelAndView mv = new ModelAndView("UserControll/Register/register_confirm");

		UserMaster res = new UserMaster();
		res.setUsername(registerForm.getUsername());
		res.setPassword(registerForm.getPassword());
		res.setEmail(registerForm.getEmail());
		res.setRole("ROLE_USER");
		res.setEnabled(true);

		//入力チェックエラーがある場合リダイレクト
		if(result.hasErrors()) {
			//エラーオブジェクトを設定。可変式のエラーコードを送信する。
			ErrorMessageForm errorObj = new ErrorMessageForm();
			errorObj.getError().put("errorMsg1", "フィールドエラーです");

			//リダイレクトパラーメーターを送信
			ModelMap modelMap = new ModelMap();
			modelMap.addAttribute("errorObject", errorObj);
			redirectAttribute.addFlashAttribute("errorMap",modelMap);
			redirectAttribute.addFlashAttribute("errorCount",result.getErrorCount());

			//リダイレクト
			ModelAndView errorBack = new ModelAndView("redirect:/register");
			return errorBack;

		} else if(uService.judgeRegisterdUser(res) == 1) {
			//エラーオブジェクトを設定。1件のみ
			ErrorMessageForm errorObj = new ErrorMessageForm();
			errorObj.getError().put("errorMsg1", "既存のユーザーが存在します。");

			//リダイレクトパラーメーターを送信
			ModelMap modelMap = new ModelMap();
			modelMap.addAttribute("errorObject", errorObj);
			redirectAttribute.addFlashAttribute("errorMap",modelMap);
			redirectAttribute.addFlashAttribute("errorCount",1);

			//リダイレクト
			ModelAndView errorBack = new ModelAndView("redirect:/register");
			return errorBack;
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
		ModelAndView mv = new ModelAndView("UserControll/Register/register_complete");



		//登録ユーザー情報をセット
		UserMaster res = new UserMaster();
		res.setUsername(registerForm.getUsername());
		res.setPassword(registerForm.getPassword());
		res.setEmail(registerForm.getEmail());
		res.setRole("ROLE_USER");
		res.setEnabled(true);

		//入力チェック
		if(uService.judgeRegisterdUser(res) == 1) {
			return new ModelAndView("UserControll/Register/register");
		}

		uService.register(res);

		return mv;
	}
}