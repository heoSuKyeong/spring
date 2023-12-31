package com.test.spring.di01;

public class Main {
	public static void main(String[] args) {
		
		//Main > Hong > Pen 관계 삺피기
		//Main은 Hong없이 업무를 실행할 수 없을 때 Hong을 의존한다고 한다.
		//또한 hong을 Main의 의존객체(Dependency Object)라고 한다.
		
		//의존 관계 형성 방법
		//1. 기존 방법
			// 의존 객체를 직접 생성한다. (Main에서의 Hong 객체 생성)
		//2. DI 패턴 방법
			// Lee에서의 Brush 객체 생성
		
		//main()을 실행하면 hong에게 업무를 위임하게된다.
		Hong hong = new Hong();
		hong.run();
		
		
		//Lee lee = new Lee();
		//lee.run();
		
		
		//Main 객체가 필요로하는 객체가 아니지만 Lee가 필요로 하는 객체를 생성한다.
		Brush brush = new Brush();
		
		//의존 주입(DI)이 발생했다.
		Lee lee = new Lee(brush);
		lee.run();
		
		
	}
}
