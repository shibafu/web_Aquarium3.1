package com.TsugaruInfo.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TsugaruInfo.entity.PictureMaster;
import com.TsugaruInfo.service.LoginUserDetails;
import com.TsugaruInfo.service.PictureService;

/**
 * ログインコントローラー
 * UiSecurityConfigによって指定されたログインページを提供する。
 * @author pratula
 *
 */
@RequestMapping(value = "/MyAlbum", method = RequestMethod.GET)
@Controller
public class MyAlbumController {

	@Autowired
	PictureService pictureService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView albumTop(Model model,
			Principal principal) {

		//認証情報を取得
        Authentication auth = (Authentication)principal;
        LoginUserDetails userDetails = (LoginUserDetails)auth.getPrincipal();


        //画像を取得
		List<PictureMaster> albumPictures = pictureService.lastAlbumUserPicture(userDetails.getUserId());

		for(PictureMaster pict:albumPictures) {
			//拡張子を取得
			pict.setExtension(pict.getOriginalName().substring(pict.getOriginalName().length() - 4, pict.getOriginalName().length()));
			//BASE64に変換
			pict.setBase64string(Base64.getEncoder().encodeToString(pict.getPictureData()));
			//バイナリデータを削除
			pict.setPictureData(null);
		}


		ModelAndView mv = new ModelAndView("MyAlbum/myalbum");
		mv.addObject("albumPicutresList", albumPictures);
		return mv;
	}
}
