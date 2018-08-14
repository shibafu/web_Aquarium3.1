package com.TsugaruInfo.event;

import org.springframework.context.ApplicationListener;

/**
 * アプリケーションイベントリスナー
 * イベントを呼び出す
 * 現在は未使用
 * @author pratula
 *
 */
public class MyBeanEventListener implements ApplicationListener<MyBeanEvent> {

	@Override
	public void onApplicationEvent(MyBeanEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Event Has Finished!!");
	}

}
