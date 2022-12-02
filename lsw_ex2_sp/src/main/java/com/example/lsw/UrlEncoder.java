package com.example.lsw;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;



@Component
public class UrlEncoder implements IComponent{


	@Override
	public String encodeComponent(String msg) {
		
		String result = null;
		
		try {
			result = URLEncoder.encode(msg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}
	
	

}
