package strategy;

import java.util.Base64;

public class Base64Strategy implements EncodingStrategy{

	@Override
	public String encode(String text) {
		
		return Base64.getEncoder().encodeToString(text.getBytes());
	}
	
//	public static void main(String[] args) {
//		Base64Strategy base64Strategy = new Base64Strategy();
//		String g = base64Strategy.encode("이밍밍시동걸어드릉드릉");
//		System.out.println(g);
//	}

}
