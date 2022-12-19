package com.example.demo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ParameterAop {

	
	// controller 패키지 하위에 있는 모든 메소드를 찾아 보겠다 (관심을 갖겠다)
	@Pointcut(value = "execution(* com.example.demo.controller..*.*(..))")
	public void myPointCut() {
		
	}
	
	
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		// a o p 를 활용하여 어떤 클래스에 어떤 메소드가 동작 하였는지 먼저 알아볼 수 있다.
		// 1. 메소드 이름을 알아보자.
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//		System.out.println("리턴 타입, 실행 된 풀 패키지 메소드 명 " + methodSignature);
		
		System.out.println("-----------------------------------------------------------------");
		Method method = methodSignature.getMethod();
		log.info("mthod - {}", method);
		
		
		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			System.out.println("type: " + object.getClass().getSimpleName());
			System.out.println("value : " + object);
		}
		System.out.println("-----------------------------------------------------------------");
		
	}
	
	
	// returning 파라미터 이름과 같아야 한다 = Object
	@AfterReturning(value = "myPointCut()", returning = "returnObj")
	public void myAfterReturn(JoinPoint joinPoint, Object returnObj) {
		System.out.println("return value ");
		System.out.println(returnObj);
	}
	
	
	
	
	
}
