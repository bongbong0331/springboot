package com.example.lsw;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class MtBase64Encoder implements IComponent{

	@Override
	public String encodeComponent(String msg) {
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}

}
