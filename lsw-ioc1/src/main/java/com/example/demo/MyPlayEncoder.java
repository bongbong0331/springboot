package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyPlayEncoder {

	
	private IPlay iPlay; 
	
	public MyPlayEncoder(IPlay iPlay) {
		// TODO Auto-generated constructor stub
		this.iPlay = iPlay;
	}


	public void setiPlay(IPlay iPlay) {
		this.iPlay = iPlay;
	}
	
	public String playencode(String pmessage) {
		
		return iPlay.play(pmessage);
	}
	
	
}
