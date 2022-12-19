package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

	
	@Pointcut(value = "execution(* com.example.demo.controller..*.*(..))")
	public void cuuut() {
	}
	
	@Pointcut(value = "@annotation(com.example.demo.annota.Timer)")
	public void checkTimer() {
		
	}
	
	@Around("cuuut() && checkTimer()")
	private void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 실행전
		Object silhangjeon = proceedingJoinPoint.proceed();
		// 메소드 실행 완료
		stopWatch.stop();
		System.out.println("걸린시간 : 凸 " + stopWatch.getTotalTimeSeconds() + "山");
	}
}
