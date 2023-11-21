package com.test.spring.di01;

public class Hong {

	public void run() {
		
		//Main > Hong > Pen 관계 삺피기
		//Hong은 Pen없이 업무를 수행할 수 없으므로 의존관계라고 한다.
		//p : Hong의 의존 객체이다.
		
		//펜을 사용하는 업무를 펜 객체를 생성하여 위임하였다.
		Pen p = new Pen();
		p.write();
	}

}
