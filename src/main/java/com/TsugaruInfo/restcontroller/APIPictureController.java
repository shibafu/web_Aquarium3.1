package com.TsugaruInfo.restcontroller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.TsugaruInfo.APIRequestBody.PictureAddResponse;
import com.TsugaruInfo.entity.PictureMaster;
import com.TsugaruInfo.service.PictureService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value="/api/picture", produces="application/json;charset=UTF-8")
@Consumes(MediaType.APPLICATION_JSON)
@RestController
public class APIPictureController {
	
	@Autowired
	PictureService pictureService;

	@POST
	@RequestMapping(value="/addPicture", method = RequestMethod.POST, headers = "X-SUBDOMEIN=api")
	public String addPicture( HttpServletRequest request, @RequestBody PictureMaster pictureMaster) {

		request.getHeaderNames();
		//画像を登録する
		Long ResultId = pictureService.addPicture(pictureMaster);
		
		PictureAddResponse response = new PictureAddResponse();
		
		response.setPictureId(ResultId.toString());
		response.setSuccessedIs(true);
		
		//Jacksonを使ってjson文字列に変換
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return "{\"result\":\"failure\"}";
		}
		
		//レスポンスを返す。
		return json;
	}
	
	@RequestMapping(value="readUserPicture")
	public List<PictureMaster> readUserPicture(Integer uploadUserId){
		return null;
	}
	
	@RequestMapping(value = "/picture_api", method = RequestMethod.GET, headers = "X-SUBDOMAIN=api")
	public String apiStreaming( HttpServletRequest request) {
		request.getHeaderNames();
		return "{\"text\":\"api_Sucessed\"}";
	}
	
	@RequestMapping(value = "/picture_api", method = RequestMethod.GET)
	public String normalStreaming( HttpServletRequest request) {

		request.getHeaderNames();
		return "{\"text\":\"api_notActivate\"}";
	}

}
