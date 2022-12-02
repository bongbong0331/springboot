package com.example.lsw;

import org.springframework.stereotype.Component;

@Component
public class MyEncoder {

	private IComponent myIComponent;

	public MyEncoder(IComponent myIComponent) {
		this.myIComponent = myIComponent;
	}

	public void setIComponent(IComponent myIComponent) {
		this.myIComponent = myIComponent;
	}

	public String encode(String message) {
		return myIComponent.encodeComponent(message);
	}

}
