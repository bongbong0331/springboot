package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;



//해당 Class는 Rest API를 처리하는 Controller 로 사용하겠다.
// 컴포넌트 스캔이 어노테이션을 확인하여 IoC 를 넣어준다.
@RestController     
@RequestMapping("/api")    // http://localhost:9090/api
public class APIController {

	@GetMapping("/hello") // http://localhost:9090/api/hello
	public String hello() {
		System.out.println("http://localhost:9090/api/hello 여기로 왔네요 ?");
		return "Hello Spring boot World";
	}
	
	
	
	// Path Variable 방식의 이해
	
	// 예전 방식  >
	// http://localhost:9090/api/myInfo1 >>>> GET , POST , PUT , DELETE  다됨
	@RequestMapping("/myInfo1")
	public String myInfo1() {
		return "<p>홍길동</p>";
	}
	
	// 예전방식 >  GET 만 됨
	@RequestMapping(path =  "/myInfo2", method = RequestMethod.GET)  
	public String myInfo2() {
		return "<p>야스오</p>";
	}
	
	// 요점 사용하는 방식으로 Path Variable 을 이해 하자 
	// GET 맵핑의 이해
	@GetMapping("/path-variable")
	public String pathVariable1() {
		return "path : ...";
	}
	
	
	// >>> Path Variable 방법 <<<
	// http://localhost:9090/api/path-variable/{홍길동}
	// http://localhost:9090/api/path-variable/{이순신}
	// {홍길동} <== 값을 내 메서드 안으로 받는 방법
	@GetMapping("/path-variable/{name}")
	public String pathVariable2(@PathVariable String name) {
		return "path : " + name;
	}
	
	// http://localhost:9090/api/path-variable/{이순신}/{100}
	@GetMapping("/path-variable/{name}/{age}")
	public String pathVariable3(@PathVariable String name, @PathVariable int age) {
		return "path : " + name + ", age : " + age;
	}
	
	// 종종 주소 설계에 넘어오는 인자 key 값과 메서드 안에 인자 이름이 같을 경우 !!!!
	@GetMapping("/path-variable4/{name}/{age}")
	public String pathVariable4(@PathVariable(name = "name") String reqName, 
			@PathVariable int age, String name) {
		return "[[[[[path : " + reqName + ", age : " + age + "]]]]]]";
	}
	
	
	
	// Query Parameter 방식의 이해
	
	
	// search.naver.com/search.naver
	// ?where=nexearch
	// &sm=top_hty
	// &fbm=1
	// &ie=utf8
	// &query=월드컵
	
	
	
	// ? <=== 부터가 쿼리 파람 주소임 ! 
	// 쿼리 파라미터는 보통 검색할 때 많이 사용하게 된다. 
	
	// GET 맵핑
	// http://localhost:9090/api/query-param1?name=홍길동&email=a@nate.com
	// 쿼리 파람으로 값을 보낼 때 ==> 더 추가 해서 보내는것은 상관이 없다.
	// 받을 때 : 매개 변수에 선언한 값이 없이 보내게 된다면 ERROR PAGE 를 만날 꺼야 .
	@GetMapping("/query-param1")
	public String queryParam1(@RequestParam String name, @RequestParam String email) {
		System.out.println("맨 pathvariable");
		System.out.println("쿼리 파람에 대한 인자값 처리");
		return "<p>name = "+name+","+email+"</p>";
	}
	
	
//	http://localhost:9090/api/query-param2?name=홍길동&email=a@nate.com&age=100&context=반가우이
	@GetMapping("/query-param2")
	public String queryParam2(@RequestParam Map<String, String>data) {
		
		StringBuffer stringBuffer = new StringBuffer();
		
		
		data.entrySet().forEach(entry -> {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			stringBuffer.append(entry.getKey() + " = " + entry.getValue() + "\n");
		});
		
		return stringBuffer.toString();
	}
	
	// DTO 를 활용하여 받는 방식 - 보통 실무에서 많이 사용하는 방식
//	http://localhost:9090/api/query-param3?name=홍길동&email=a@nate.com&age=100&context=반가우이
	// DTO 설계 방식 때는 앞에 아무것도 적으면 안된다. 
	// @RequestParam 을 적으면 안되고 dto 속성을 필요한 것만 사용 가능하다.
	// 요청에 추가적인 부분이 더 많아도 상관 없고
	// dto 속성에 없는 녀석이 있어도 상관 없다.
	// Message Converter 가 알아서 동작 하고 있다.
	@GetMapping("/query-param3")
	public String queryParam3(UserDTO user) {
		
		return user.toString();
	}
	
	
}
