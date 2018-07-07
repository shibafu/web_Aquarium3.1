package com.TsugaruInfo.event;

import org.springframework.context.ApplicationListener;

public class MyBeanEventListener implements ApplicationListener<MyBeanEvent> {

	@Override
	public void onApplicationEvent(MyBeanEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Event Has Finished!!");
	}

}
