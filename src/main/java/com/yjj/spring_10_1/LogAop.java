package com.yjj.spring_10_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
public class LogAop {
	

//	@Pointcut("execution(public void get*(..))") //public void인 모든 get메서드
//	@Pointcut("execution(* com.javagyojin.ex.*.*())") //com.javagyojin.ex 패키지에 파라미터가 없는 모든 메서드	
//	@Pointcut("execution(* com.javagyojin.ex..*.*())") //com.javagyojin.ex 패키지 & com.javagyojin.ex 하위 패키지에 파라미터가 없는 모든 메서드 
//	@Pointcut("execution(* com.javagyojin.ex.Worker.*())") //com.javagyojin.ex.Worker 클래스안에 있는 모든 메서드
		
//	@Pointcut("within(com.javagyojin.ex.*)") //com.javagyojin.ex 패키지 안에 있는 모든 메서드
//	@Pointcut("within(com.javagyojin.ex..*)") //com.javagyojin.ex 패키지 & 하위 패키지 안에 있는 모든 메서드
//	@Pointcut("within(com.javagyojin.ex.Worker)") //com.javagyojin.ex.Worker 클래스 안에 있는 모든 메서드
	
//	@Pointcut("bean(student)") //student 빈에만 적용
//	@Pointcut("bean(*ker)") //*ker로 끝나는 이름의 빈에만 적용
	

	
//	@Pointcut("within(com.yjj.spring_10_1.*)")
	@Pointcut("bean(*1)")
	private void pointcutMethod() {
		
	}
	
	
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString();
		// 공통 기능이 적용될 메서드 (joinPoint)의 이름 불러오기
		System.out.println(signatureStr + " 메서드가 시작되었습니다.");
		// joinPoint(메서드)의 이름 출력 
		
		long st = System.currentTimeMillis(); // 현재시간 가져오기
		
		try {
			Object obj = joinPoint.proceed(); // joinpoint 메서드 실행
			return obj;
		} finally {
			long et = System.currentTimeMillis(); // 현재시간 가져오기
			System.out.println(signatureStr + "메서드가 종료되었습니다.");
			System.out.println(signatureStr + "경과시간 : " + (et-st));
			
		}

	}
	
	@Before("pointcutMethod()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice가 실행됨");
		
	}
	
	@AfterReturning("pointcutMethod()")
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice가 실행됨");
		
	}
	
	@AfterThrowing("pointcutMethod()")
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice가 실행됨");
		
	}
	
	@After("pointcutMethod()")
	public void afterAdvice() {
		System.out.println("afterAdvice가 실행됨");
		
	}
	
	
	
	
	
	

}
