package com.TsugaruInfo.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 教材の残り
 * @author pratula
 *
 */
@Component
public class MyBean {
	private List<String> messages = new ArrayList<String>();

	public MyBean() {
		super();
		messages.add("This is Bean Message Who!?");
	}

	public void addMessage(String message) {
		messages.add(message);
	}

	public String getMessage(int n) {
		return messages.get(n);
	}

	public String setMessage(int n, String message) {
		return messages.set(n, message);
	}

	public List<String> getMessage() {
		return messages;
	}

	@Override
	public String toString() {
		String result = "My Bean [\n";
		for(String message : messages) {
			result += "\t'" + message + "'\n";
		}
		result += "]";
		return result;
	}
}

