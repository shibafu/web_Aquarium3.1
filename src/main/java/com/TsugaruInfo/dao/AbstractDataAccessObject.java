package com.TsugaruInfo.dao;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class AbstractDataAccessObject<T> {

	/**
	 * 初期化メソッド
	 * Autowiringを実行可能にする。
	 */
	public void init() {
		SpringBeanAutowiringSupport
			.processInjectionBasedOnCurrentContext(this);
	}
}
