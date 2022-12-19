package com.tencoding.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tencoding.blog.interceptor.AuthUserInterceptor;

import lombok.RequiredArgsConstructor;

// web.xml <-- port , 초기 파람
// WebMvcConfigurer 등록

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

	private final AuthUserInterceptor authUserInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(authUserInterceptor);

//		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
