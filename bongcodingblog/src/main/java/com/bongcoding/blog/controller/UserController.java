package com.bongcoding.blog.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.bongcoding.blog.dto.KakaoAccount;
import com.bongcoding.blog.dto.KakaoProfile;
import com.bongcoding.blog.dto.OAuthToken;
import com.bongcoding.blog.dto.User;
import com.bongcoding.blog.service.UserService;

@Controller
public class UserController {
	
	@Value("${bongco.key}")
	private String bongcoKey;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private HttpSession session;
	
	
	
	
	@GetMapping("/auth/join_form")
	public String joinForm() {
	
		return "user/join_form";
	}
	
	@GetMapping("/auth/login_form")
	public String loginForm() {
		return "user/login_form";
	}
	
	@GetMapping("/user/update_form")
	public String updateForm() {
		return "user/update_form";
	}
	
	
	
	
	
	
	
	@GetMapping("/auth/kakao/callback")
	public String kakaoCallback(@RequestParam String code) {
		
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "46628ebab17dc3a014293d7a4706b4be");
		params.add("redirect_uri", "http://localhost:7080/auth/kakao/callback");
		params.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> requestKakaoToken=
				new HttpEntity<>(params, headers);
		
		
		ResponseEntity<OAuthToken> response =
				rt.exchange(
						"https://kauth.kakao.com/oauth/token",
						HttpMethod.POST,
						requestKakaoToken,
						OAuthToken.class);
		
		OAuthToken authToken = response.getBody();
		System.out.println("authToken:" + authToken);
		
		RestTemplate rt2 = new RestTemplate();
		
		HttpHeaders headers2 = new HttpHeaders();
		
		headers2.add("Authorization", "Bearer " + authToken.access_token);
		headers2.add("Content-Type", "application/x-www-form-urlencoded;");
		
		HttpEntity<MultiValueMap<String, String>> kakaoDataRequest =
				new HttpEntity<>(headers2);
		
		ResponseEntity<KakaoProfile> kakaoDataResponse = 
				rt2.exchange("https://kapi.kakao.com/v2/user/me", 
						HttpMethod.POST, kakaoDataRequest, KakaoProfile.class);
		
		KakaoAccount account = kakaoDataResponse.getBody().kakaoAccount;
		
		User kakaoUser = User
				.builder()
				.username(account.profile.nickname + "_" + kakaoDataResponse.
						getBody().id)
				.email(account.email)
				.password(bongcoKey)
				.oauth("kakao")
				.build();
		
		User originUser = userService.searchUserName(kakaoUser.getUsername());
		if (originUser.getUsername() == null) {
			System.out.println("신규 회원이기 떔에, 회원가압해랴ㅏ");
			userService.saveUser(kakaoUser);
		}
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(), bongcoKey));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
		
		
		
		return "redirect:/";
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
