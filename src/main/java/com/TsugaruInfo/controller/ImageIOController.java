package com.TsugaruInfo.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.TsugaruInfo.entity.PictureMaster;
import com.TsugaruInfo.formmodel.ImageUploadForm;
import com.TsugaruInfo.formmodel.RegisterForm;
import com.TsugaruInfo.service.LoginUserDetails;
import com.TsugaruInfo.service.PictureService;

@Controller
public class ImageIOController {

	@Autowired
	PictureService pictureService;
	
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
	public ModelAndView imageUploadComplete(ImageUploadForm imageUploadForm,
			Principal principal) {
		
		//認証情報を取得する
        Authentication auth = (Authentication)principal;
        LoginUserDetails LoginUser = (LoginUserDetails)auth.getPrincipal();
		
		//バイナリデータを取得
		Integer FileSize = (int) (imageUploadForm.getImage().getSize());
		byte[] imageBinary = new byte[FileSize];
		
		try {
			 imageBinary = imageUploadForm.getImage().getBytes();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		

	    //ログインユーザーディテールを取得する。
	    System.out.println(LoginUser.getUserId());
	    System.out.println(LoginUser.getUsername());
		
	    //画像を登録
		pictureService.addPicture(imageBinary, "seaPictureDorphin", imageUploadForm.getImage().getOriginalFilename(), LoginUser.getUserId());
		
		ModelAndView mv = new ModelAndView("ImageComplete");
		return mv;
	}
	
	@RequestMapping(value = "/imageView", method = RequestMethod.GET)
	public ModelAndView imageView(Principal principal) {
		
		//認証情報を取得する
        Authentication auth = (Authentication)principal;
        LoginUserDetails LoginUser = (LoginUserDetails)auth.getPrincipal();
		
		//ユーザーの登録画像を取得
		ModelAndView mv = new ModelAndView("ImageView");
		List<PictureMaster> UserPicutres = pictureService.readUserPicture(LoginUser.getUserId());
		
		for(PictureMaster pict:UserPicutres) {
			//拡張子を取得
			pict.setExtension(pict.getOriginalName().substring(pict.getOriginalName().length() - 4, pict.getOriginalName().length()));
			//BASE64に変換
			pict.setBase64string(Base64.getEncoder().encodeToString(pict.getPictureData()));
			//バイナリデータを削除
			pict.setPictureData(null);
		}
		
		mv.addObject("UserName",LoginUser.getUsername());
		mv.addObject("UserPictures", UserPicutres);
		
		return mv;
	}
}
