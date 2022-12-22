/*
 * package com.bongcoding.blog.service;
 * 
 * import java.net.URI;
 * 
 * import org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Service; import
 * org.springframework.web.client.RestTemplate; import
 * org.springframework.web.util.UriComponentsBuilder;
 * 
 * import com.bongcoding.blog.dto.UserResponse;
 * 
 * @Service public class RestTemplateService {
 * 
 * 
 * 
 * public UserResponse hello() {
 * 
 * URI uri = UriComponentsBuilder .fromUriString("http://localhost:7080")
 * .path("/api/server/hello") .encode() .build() .toUri();
 * System.out.println("주소확인 : " + uri.toString());
 * 
 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<UserResponse>
 * result = restTemplate.getForEntity(uri, UserResponse.class);
 * System.out.println(result.getStatusCode());
 * System.out.println(result.getBody());
 * 
 * return result.getBody(); }
 * 
 * public UserResponse hello1() { URI uri = UriComponentsBuilder
 * .fromUriString("http://localhost:7080")
 * .path("/api/server/hello1/{name}/name/{age}") .encode() .build()
 * .expand("홍길동", "100") .toUri();
 * 
 * System.out.println("주소확인:" + uri.toString());
 * 
 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<UserResponse>
 * result= restTemplate.getForEntity(uri, UserResponse.class);
 * System.out.println(result.getStatusCode());
 * System.out.println(result.getBody());
 * 
 * return result.getBody(); }
 * 
 * public UserResponse hello2() {
 * 
 * URI uri = UriComponentsBuilder .fromUriString("http://localhost:7080")
 * .path("/api/server/hello2") .queryParam("name", "홍길동") .queryParam("age",
 * "10") .encode() .build() .toUri();
 * 
 * System.out.println("주소확인 : " + uri.toString());
 * 
 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<UserResponse>
 * result = restTemplate.getForEntity(uri, UserResponse.class);
 * System.out.println(result.getStatusCode());
 * System.out.println(result.getBody());
 * 
 * return result.getBody();
 * 
 * } }
 */