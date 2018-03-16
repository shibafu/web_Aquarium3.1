package com.TsugaruInfo.sevice;

import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Service
public abstract class AbstractDBService {

	public AbstractDBService() {
		SpringBeanAutowiringSupport
			.processInjectionBasedOnCurrentContext(this);
	}
}
