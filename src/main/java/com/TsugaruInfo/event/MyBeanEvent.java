package com.TsugaruInfo.event;

import org.springframework.context.ApplicationEvent;

/**
 * アプリケーションイベント
 * 現在は未使用
 * @author pratula
 *
 */
public class MyBeanEvent extends ApplicationEvent {

	public MyBeanEvent(Object source) {
		super(source);
		// TODO 自動生成されたコンストラクター・スタブ
		System.out.println("Create MyBeanEvent");
	}

}
