package com.test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect	//보조 업무 객체
//aspect는 빈이 아니다(스프링이 관리하는 객체가 아니다)
public class Log {
	
	//포인트 컷 : 주업무 메소드를 aspectJ 표현식으로 나타낸다.
	@Pointcut("execution(* com.test.controller.AOPController.add(..))")
	public void pc1() {
		//pointcut이 필요하여 만든 메소드므로 구현부가 없다.
		
	}
	
	//보조 업무
	//포인트 컷과 연결한다.
	@After("pc1()")
	public void m1() {
		System.out.println("After [보조업무] 기록을 남깁니다.");
		
	}
	
	@Before("pc1()")
	public void m2() {
		System.out.println("Before [보조업무] 기록을 남깁니다.");
		
	}
	
	//재사용이 불가하다.
	@After("execution(* com.test.controller.AOPController.list(..))")
	public void m3() {
		System.out.println("After [보조업무] 기록을 남깁니다.");
	}

	//글쓰기, 수정하기, 삭제하기 기능에 권한체크할 때 사용
	
	
}
