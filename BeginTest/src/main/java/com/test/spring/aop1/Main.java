package com.test.spring.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//주업무 객체 > 직접생성하면 스프링 환경을 제공받지 못한다.
		//Memo memo = new MemoImpl();
		
		//반드시 객체를 스프링을 통해 생성해야 스프링의 혜택을 적용할 수 있다.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/aop1/memo.xml");
		
		Memo memo = (Memo)context.getBean("memo");	//new MemoImpl();
		
		
		memo.add("스프링 AOP");
		
		try {
			String txt = memo.read(15);
			System.out.println(txt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		memo.edit(5, "수정합니다.");
		
		memo.del(5);
		
		
	}
}
