package com.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

/*	@Pointcut("execution(* com.spring..*Impl.*(..))")
	public void allPointcut() {}	*/
	
//	@Before("allPointcut()")
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[어노테이션 사전 처리]" + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	}
}
