package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware{

	private static ApplicationContext appcc;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		appcc = applicationContext;
	}

	// 어플리케이션컨텍스트 가져갈수있게 처리
	
	public static ApplicationContext getContext() {
		return appcc;
	}
}
