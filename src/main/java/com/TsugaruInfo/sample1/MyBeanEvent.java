package com.TsugaruInfo.sample1;

import org.springframework.context.ApplicationEvent;

public class MyBeanEvent extends ApplicationEvent {

	public MyBeanEvent(Object source) {
		super(source);
		// TODO 自動生成されたコンストラクター・スタブ
		System.out.println("Create MyBeanEvent");
	}

}
