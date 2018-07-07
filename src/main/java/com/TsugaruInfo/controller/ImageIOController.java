package com.TsugaruInfo.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TsugaruInfo.entity.PictureMaster;
import com.TsugaruInfo.form.ImageUploadForm;
import com.TsugaruInfo.form.ImageUploadFormApi;
import com.TsugaruInfo.service.LoginUserDetails;
import com.TsugaruInfo.service.PictureService;

@Controller
public class ImageIOController {

	@Autowired
	PictureService pictureService;
	
	/**
	 * フォームを初期化
	 * @return
	 */
	@ModelAttribute(name = "ImageUploadForm")
	public ImageUploadForm initForm(){
		ImageUploadForm imageUploadForm = new ImageUploadForm();
		/*
		初期設定
		*/
		return imageUploadForm;
	}
	
	/**
	 * フォームを初期化（API用)
	 * @return
	 */
	@ModelAttribute(name = "ImageUploadFormApi")
	public ImageUploadFormApi initFormApi(){
		ImageUploadFormApi imageUploadFormApi = new ImageUploadFormApi();
		/*
		初期設定
		*/
		return imageUploadFormApi;
	}
	
	/**
	 * イメージアップロード用ページ
	 * @return
	 */
	@RequestMapping(value = "/imageUpload", method = RequestMethod.GET)
	public ModelAndView imageUpload() {
		ModelAndView mv = new ModelAndView("/ImageView/ImageUpload");
		return mv;
	}
	
	/**
	 * イメージアップロード処理を行うページ
	 * @param imageUploadForm
	 * @param principal
	 * @return
	 */
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
		
	    //画像を登録
		pictureService.addPicture(imageBinary, "seaPictureDorphin", imageUploadForm.getImage().getOriginalFilename(), LoginUser.getUserId());
		
		ModelAndView mv = new ModelAndView("/ImageView/ImageComplete");
		return mv;
	}
	
	/**
	 * イメージ閲覧処理
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/imageView", method = RequestMethod.GET)
	public ModelAndView imageView(Principal principal) {
		
		//認証情報を取得する
        Authentication auth = (Authentication)principal;
        LoginUserDetails LoginUser = (LoginUserDetails)auth.getPrincipal();
		
		//ユーザーの登録画像を取得
		ModelAndView mv = new ModelAndView("/ImageView/ImageView");
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
	

	/**
	 * APIアップロード用テスト
	 * @return
	 */
	@RequestMapping(value = "/imageUploadapi", method = RequestMethod.GET)
	public ModelAndView imageUploadApi() {
		ModelAndView mv = new ModelAndView("/ViewForAPI/ImageUploadApi");
		return mv;
	}
	
	/**
	 * イメージアップロードAPIテスト
	 * @param imageUploadFormApi
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/imageCompleteApi", method = RequestMethod.POST)
	public ModelAndView imageUploadCompleteApi(ImageUploadFormApi imageUploadFormApi,
			Principal principal) {
		
		//認証情報を取得する
        Authentication auth = (Authentication)principal;
        LoginUserDetails LoginUser = (LoginUserDetails)auth.getPrincipal();
		
		//バイナリデータを取得
		Integer FileSize = (int) (imageUploadFormApi.getImage().getSize());
		byte[] imageBinary = new byte[FileSize];
		
		try {
			 imageBinary = imageUploadFormApi.getImage().getBytes();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//Request準備
		PictureMaster pictureMaster = new PictureMaster();
		
		pictureMaster.setOriginalName(imageUploadFormApi.getImage().getOriginalFilename());
		pictureMaster.setPictureName(imageUploadFormApi.getFilename());
		pictureMaster.setExtension(imageUploadFormApi.getImage().getOriginalFilename()
				.substring(imageUploadFormApi.getImage().getOriginalFilename().length() - 4, imageUploadFormApi.getImage().getOriginalFilename().length()));
		pictureMaster.setBase64string(Base64.getEncoder().encodeToString(imageBinary));
		pictureMaster.setUploadUserId(LoginUser.getUserId());
	    //APIを呼び出して画像を登録
		

		ObjectMapper mapper = new ObjectMapper();
		
		Entity<String> requestBody = null;
		String result = null;
		
		//ヘッダーを設定する。
		MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
		headers.putSingle("X-SUBDOMEIN", "api");
		
		try {
			requestBody = Entity.json(mapper.writeValueAsString(pictureMaster));
			
			//自分サーバーへのAPIにポストリクエストを送る。
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://api.localhost:8080")
				    .path("/WebAquarium3.1/api/picture/addPicture");
			
			result = target
					.request()
					.headers(headers)
					.post(requestBody, String.class);
			
			
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
                		
        //受け取ったJSONをクラスに変換
		
		System.out.println(result);
		ModelAndView mv = new ModelAndView("/ImageView/ImageComplete");
		return mv;
	}
}
