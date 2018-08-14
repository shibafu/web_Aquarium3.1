package com.TsugaruInfo.bean;

import java.util.Calendar;
import java.util.Date;

/**
 * 教材の残り・
 * イベント用の簡単なBean
 * @author pratula
 *
 */
public class MyBeanEve {
	private Date date;
	private String message;
	public MyBeanEve() {
		super();
		this.date = Calendar.getInstance().getTime();
	}


	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "MyBean2 (" + message + ");\n" + date.toString() +"\n--end";
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public void addMessage(String message) {
		this.message = this.message +"\n" + message;
	}
}
