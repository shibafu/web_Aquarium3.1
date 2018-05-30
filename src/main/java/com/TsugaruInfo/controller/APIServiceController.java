package com.TsugaruInfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TsugaruInfo.formmodel.RegisterForm;

@RequestMapping(value = "/APITransport")
@RestController
public class APIServiceController {
	
	@RequestMapping(value="APIAccessParametors",produces="application/json;charset=UTF-8")
	public String APIAccessParametors() {
		String APIResponseJson = 
			"{\"user\": [\"AtsuAtsuUdon\", \"user\", true],"
			+ " \"toot\": [\"アツアツうどんですよろしく！\"]"
			+ "CWInfo: {CWSituationIs:[true, \"隠したいなんか\"], \"publicToot\", \"something\"]}";
		
		return APIResponseJson;
	}
}
