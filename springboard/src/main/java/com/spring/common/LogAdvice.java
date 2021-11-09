package com.spring.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.spring..*Impl.*(..))")
	public void allPointcut() {	}
	
	@Before("allPointcut()")
	public void printLog() {
		
		System.out.println("[공통 로그] 비지니스 로직 수행 전 동작");
		
	}
}
