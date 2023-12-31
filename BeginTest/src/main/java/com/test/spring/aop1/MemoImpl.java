package com.test.spring.aop1;

public class MemoImpl implements Memo{
	//주업무와 보조업무가 함께 관리되어 효율적이지 않다.
	
	@Override
	public void add(String memo) {

		//DB에 insert 완료했다고 가정
		System.out.println("메모 쓰기: " + memo);
		
		/*
		//로그 기록
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n", now, now);
		*/
		
		
	}

	@Override
	public String read(int seq) throws Exception{
		
		if (seq < 10) {
			System.out.println("메모 읽기");
		} else {
			throw new Exception("존재하지 않는 메모");
		}
		
		return "메모 읽기 완료";
	}

	@Override
	public boolean edit(int seq, String memo) {
		
		System.out.println("메모 수정: " + memo);
		
		return false;
	}

	@Override
	public boolean del(int seq) {

		System.out.println(seq + "번 메모 삭제 완료");
		
		
		return false;
	}

	
	
	
	
}
