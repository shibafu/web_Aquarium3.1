package com.TsugaruInfo.sample1;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

public class MySampleApplicationListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		
		if(event instanceof ContextRefreshedEvent) {
				System.out.println("リフレッシュされたよ！");
		}
		
		if(event instanceof ContextClosedEvent) {
			System.out.println("クローズしたよ！");
	}
	
	}

}
