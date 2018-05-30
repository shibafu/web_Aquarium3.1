package com.TsugaruInfo.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.TsugaruInfo.formmodel.ImageUploadForm;
import com.TsugaruInfo.formmodel.RegisterForm;

@Controller
public class ImageIOController {

	@ModelAttribute(name = "ImageUploadForm")
	public ImageUploadForm initForm(){
		ImageUploadForm imageUploadForm = new ImageUploadForm();
		/*
		初期設定
		*/
		return imageUploadForm;
	}
	
	@RequestMapping(value = "/imageUpload", method = RequestMethod.GET)
	public ModelAndView imageUpload() {
		ModelAndView mv = new ModelAndView("ImageUpload");
		return mv;
	}
	
	@RequestMapping(value = "/imageComplete", method = RequestMethod.POST)
	public ModelAndView imageUploadComplete(ImageUploadForm imageUploadForm) {
		System.out.println(imageUploadForm.getImage().getOriginalFilename());
		
		Integer FileSize = (int) (imageUploadForm.getImage().getSize());
		
		byte[] ImageBinary = new byte[FileSize];
		
		try {
			 ImageBinary = imageUploadForm.getImage().getBytes();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("ImageComplete");
		return mv;
	}
}
