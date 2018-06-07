package com.TsugaruInfo.restcontroller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TsugaruInfo.entity.PictureMaster;

@RequestMapping(value="/api/picture", produces="application/json;charset=UTF-8")
@RestController
public class APIPictureController {

	@RequestMapping(value="addPicture")
	public String addPicture(byte[] picturedata, String pictureName,String originalName, Integer uploadUserId, HttpServletRequest request) {
		

		
		return "{\"text\":\"( ^^) _旦~~\"}";
	}
	
	@RequestMapping(value="readUserPicture")
	public List<PictureMaster> readUserPicture(Integer uploadUserId){
		return null;
	}

}
