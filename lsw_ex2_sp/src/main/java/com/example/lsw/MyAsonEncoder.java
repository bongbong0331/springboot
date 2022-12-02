package com.example.lsw;

public class MyAsonEncoder implements IComponent{

	@Override
	public String encodeComponent(String msg) {
		String result = "아녕" +msg + "잘가";
		
		return result;
	}

}
