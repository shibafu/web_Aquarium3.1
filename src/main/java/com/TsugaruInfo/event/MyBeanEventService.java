package com.TsugaruInfo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.TsugaruInfo.bean.MyBeanEve;

public class MyBeanEventService implements ApplicationEventPublisherAware{

	@Autowired
	private MyBeanEve beanEve;
	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		// TODO 自動生成されたメソッド・スタブ
		this.publisher = applicationEventPublisher;
		System.out.println("publisher set!!");
		
	}
	
	public void doService(String message) {
		System.out.println("Service Started!");
		beanEve.addMessage(message);
		publisher.publishEvent(new MyBeanEvent(this));
	}

}
