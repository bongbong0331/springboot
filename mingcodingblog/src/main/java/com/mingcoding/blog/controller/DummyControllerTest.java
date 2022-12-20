//package com.mingcoding.blog.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.mingcoding.blog.dto.User;
//import com.mingcoding.blog.model.RoleType;
//import com.mingcoding.blog.repository.UserRepository;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RestController
//@RequestMapping("/dummy")
//public class DummyControllerTest {
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@PostMapping("/signup")
//	public String signUp(@RequestBody User user) {
//		
//		log.info(">>>> User : {} ", user);
//		user.setRole(RoleType.USER);
//		userRepository.save(user);
//		
//		return "회원가입완료";
//	}
//	
//	// 기본
////	@GetMapping("/user/{id}")
////	public User detail(@PathVariable int id) {
////		User user = userRepository.findById(id).orElseGet(() -> {
////			return new User();
////		});
////		return user;
////	}
//	
//	//커스텀
//	@GetMapping("/user/{id}")
//	public User detail(@PathVariable int id) {
//		User user = userRepository.findById(id).orElseThrow(() -> {
//			return new IllegalArgumentException("해당 유저는 ㅇ벗다 : " + id);
//		});
//		return user;
//	}
//	
//	//유저 전체 조회
//	@GetMapping("/user")
//	public List<User> list(){
//		return userRepository.findAll();
//	}
//	
//	// 페이징
//	@GetMapping("/userspaging")
//	public Page<User> pageList(@PageableDefault(size = 5,
//			sort = "id", direction = Direction.DESC) Pageable pageable){
//		
//		Page<User> userPage = userRepository.findAll(pageable);
//		List<User> users = userRepository.findAll(pageable).getContent();
//		
//		return userPage;
//	}
//	
//	@PutMapping("/user/{id}")
//	public User updateUser(@PathVariable int id, @RequestBody User reqUser) {
//		
//		log.info(">>>id: {}, >>> password : {}, email :{}",
//			id, reqUser.getPassword(), reqUser.getEmail());
//		
//		User user = userRepository.findById(id).orElseThrow(() -> {
//			return new IllegalArgumentException("잘못된 요청이다");
//		});
//		
//		user.setPassword(reqUser.getPassword());
//		user.setEmail(reqUser.getEmail());
//		
//		userRepository.save(user);
//		
//		return null;
//	}
//	
//	// 삭제
//	@DeleteMapping("/user/{id}")
//	public String delete(@PathVariable int id) {
//		
//		try {
//			userRepository.deleteById(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return id + ": 삭제되엇다";
//	}
//	
//	
//	
//	
//	
//	
//	@GetMapping("/uset/test")
//	public String getTest(String name, int age) {
//		
//		System.err.println("name : " + name);
//		System.err.println("age:" + age);
//		
//		return "";
//	}
//	
//	
//	@PostMapping("/signup2")
//	public String signUp2(String username, String password, String email) {
//		
//		
//		User reqUser = new User();
//		reqUser.setUsername(username);
//		reqUser.setPassword(password);
//		reqUser.setEmail(email);
//		reqUser.setRole(RoleType.USER);
//		userRepository.save(reqUser);
//		
//		return "회원가입이 완료되었다";
//	}
//	
//	
//	
//}
