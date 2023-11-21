package com.test.spring.di02;

public class Lee {


	// 의존 관계 형성 방법
	// 1. 기존 방법
		// 의존 객체를 직접 생성한다. (Main에서의 Hong 객체 생성)
	// 2. DI 패턴 방법
		// Lee에서의 Brush 객체 생성
		// 의존 주입 도구가 필요하다.
			//생성자 또는 setter 를 사용한다.
			//1. 생성자 : 딱 1번만 호출 가능하여 setter 보다 안정성이 높다.
			//2. setter : 언제든 호출 가능하다.
	
	//멤버변수로 승격
	private Brush brush;
	
	//의존 주입 발생
	//의존 주입 도구 : 의존 객체를 스스로 생성하지 않고, 외부로부터 건내받는 도구
	public Lee(Brush brush) {
		this.brush = brush;
	
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
	}


	public void run() {
		//Brush brush = new Brush();
		brush.draw();
	}

}
