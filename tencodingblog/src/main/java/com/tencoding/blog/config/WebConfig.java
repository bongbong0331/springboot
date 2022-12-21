package com.tencoding.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${file.path}")
	private String uploadFolder;
	
	//인터셉터같은놈 낚아채는놈
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
//		file:///C:/workspace_blog/springbootwork/upload/d6f6a1ae-e93e-4d3c-88da-f1cbd6b32616_0001187331_001_20221206172201236.jpg  << 이거다
		
		// --> /upload/** 낚아 채어 간다. url 패턴이 : /upload/파일명 --> 가져감
		registry.addResourceHandler("/upload/**")    //낚
		.addResourceLocations("file:///" + uploadFolder)     //실제 파일 서버 물리적인 경로
		.setCachePeriod(60 * 10 * 6) // 초단위 > 캐쉬 지속시간 설정
		.resourceChain(true)    //  내컴터 리소스 찾는것을 최적화 하기 위하여 설정
		.addResolver(new PathResourceResolver());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 등록
	// 객체

	// 루시 안써서 우ㅡ선 주석
//	@Bean
//	public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
//
//		FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//		filterRegistrationBean.setFilter(new XssEscapeServletFilter());
//		filterRegistrationBean.setOrder(1);
//		filterRegistrationBean.addUrlPatterns("/*");
//		
//		System.out.println("WebMvcConfigurer 생성 >>>>>>>>>>");
//		return filterRegistrationBean;
//	}

}
