package com.TsugaruInfo.restcontroller;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/APITransport")
@Controller
public class APIRecieverController {

	@RequestMapping(value="recieverClient")
	public ModelAndView recieverClient(Model model) {
		ModelAndView mv = new ModelAndView("ViewForAPI/APIRecieverView");
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://api.localhost:8080")
			    .path("/WebAquarium3.1/APITransport/APIAccessParametors");
			 
		String result = "";
			try {
			    result = target.request().get(String.class);
			} catch (BadRequestException e) {
			    System.out.println("受信に失敗しました＞＜");
			    throw e;
			}
			
		mv.addObject("APIMessage", result);
		return mv;
	}
}
