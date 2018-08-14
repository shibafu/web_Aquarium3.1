package com.TsugaruInfo.restcontroller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APIテスト用アクセスコントローラー
 * 色んなものを試したりする。
 * 基本的に簡単なJSONを返却する。
 * @author pratula
 *
 */
@RequestMapping(value = "/api/APITransport",produces="application/json;charset=UTF-8")
@RestController
public class APIServiceController {

	/**
	 * APIを送信する
	 * @return
	 */
	@RequestMapping(value="APIAccessParametors", headers = "X-SUBDOMAIN=api")
	public String APIAccessParametors() {
		String APIResponseJson =
			"{\"user\": [\"AtsuAtsuUdon\", \"user\", true],\n"
			+ " \"toot\": [\"アツアツうどんですよろしく！\"],\n"
			+ "\"CWInfo\": [true, \"隠したいなんか\", \"publicToot\", \"something\"]\n"
			+ "}";

		return APIResponseJson;
	}

	/**
	 * ヘッダーを列挙する
	 * @param request
	 * @return
	 */
	@RequestMapping(value="header")
	public String requestHeaderConfirm(HttpServletRequest request) {
		System.out.println(request.toString());

		Enumeration headernames = request.getHeaderNames();
	    while (headernames.hasMoreElements()){
	      String name = (String)headernames.nextElement();
	      Enumeration headervals = request.getHeaders(name);

	        StringBuffer sb = new StringBuffer();
	        sb.append(name);

	      while (headervals.hasMoreElements()){
		    String val = (String)headervals.nextElement();
	        sb.append(":");
	        sb.append(val);
	      }
	      System.out.println(sb.toString());
	    }


		return "{\"text\":\"( ^^) _旦~~\"}";
	}
}
