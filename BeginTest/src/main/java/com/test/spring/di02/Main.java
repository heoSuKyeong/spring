package com.test.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//Spring DI 구현
		
		//스프링 설정
		//1. XML 설정
		//2. 어노테이션 설정
		//3. Java 설정
		
		
		//스프링 프레임워크 특징
		//필요한 객체를 생성하고 소멸할 때까지의 과정을 스프링이 대신 관리해준다.
		
		//Pen 객체 생성하기
		Pen p1 = new Pen();
		p1.write();
		
		//Pen 객체를 스프링을 통해 생성하기 (xml 방식)
		//1. xml 생성 (di02.xml)
		//2. xml 읽기
		//ApplicationContext context = new ClassPathXmlApplicationContext("xml 파일의 경로");
		//ApplicationContext context = new ClassPathXmlApplicationContext("file:/src/main/java/com/test/spring/di02/di02.xml");	//절대 경로
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/di02/di02.xml");		//상대 경로
		
		//3. 빈을 1개 받아온다. == 객체를 1개 생성 요청하는 것과 같다. == new Pen();
		Pen p2 = (Pen)context.getBean("pen");
		p2.write();
		
		
		
		//Brush 객체 생성하기
		//직접 생성 
		Brush b1 = new Brush();
		b1.draw();
		
		//스프링을 통해 생성하기
		Brush b2 = (Brush)context.getBean("brush");	//id로 호출
		b2.draw();
		
		Brush b3 = (Brush)context.getBean("b1");	//name으로 호출
		b3.draw();
		
		System.out.println();
		
		//--------------------------
		
		//Main> (의존) > Hong > (의존) > Pen
		
		//Main > (의존) > Park > Choi > Brush
		
		
		Hong hong = (Hong)context.getBean("hong");
		hong.run();
		System.out.println();
		
		
		//의존 주입의 특징
		//- 중앙 집중 관리형 : 객체들의 모든 관계가 한곳에서 관리한다. 
		
		//Park 호출
		//스프링 사용하지 않았을 때
		Brush brush1 = new Brush();
		Choi choi1 = new Choi();
		choi1.setBrush(brush1);		//setter로 외존 주입
		Park park1 = new Park(choi1); 	//생성자로 의존 주입
		
		park1.run();
		System.out.println();
		
		//스프링 사용하여 객체간의 의존 관계 정의
		//관계는 xml에서 처리하기 때문에 메인은 park 호출하는 것만 신경쓰면된다.
		Park park2 = (Park)context.getBean("park");
		park2.run();
		
		
		
	}
}
