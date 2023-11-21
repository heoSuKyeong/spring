package com.test.spring.aop1;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

	public void log() {
		
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n", now, now);
		
	}

	public void time(ProceedingJoinPoint jp) {
		
		//주업무를 실행하는 소요시간
		long begin = System.nanoTime();
		System.out.println("[LOG] 기록을 시작합니다.");
		
		//주업무 실행 > aop의 around와 사용
		//주업무 객체의 가상 객체 참조
		try {
			
			jp.proceed();	//주업무 객체의 주업무 메소드를 의미한다. xml에서 지정한다.
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		System.out.println("[LOG] 기록을 종료합니다.");
		
		System.out.printf("[LOG] 쇼요 시간 %,dns\n", end-begin);
	}
	
	public void history(String memo) {
		
		System.out.println("[LOG] 읽기 기록 > " + memo);
		
	}
	
	public void check(Exception e) {
		
		//예외처리가 아닌 에러메시지만 출력하는 역할
		System.out.println("[LOG]예외 발생: " + e.getMessage());
		
	}
	
}
