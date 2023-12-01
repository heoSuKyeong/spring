package com.test.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/testserver.do")
public class SocketServer {

	//클라이언트가 연결 요청했을 때 발생한다.
	@OnOpen
	public void handelOpen() {
		System.out.println("클라이언트가 접속했습니다.");
	}
	
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트가 종료했습니다.");
	}
	
	//클라이언트가 서버에게 메시지를 전송했을 때 발생한다. > ws.send('')에 반응
	//전달한 메시지가 매개변수로 들어온다.
	/*
	@OnMessage
	public void handleMasseage(String msg) {
		System.out.println("클라이언트가 보낸 메시지: " + msg);
	}
	*/
	@OnMessage
	public String handleMasseage(String msg) {
		System.out.println("클라이언트가 보낸 메시지: " + msg);
		
		//클라이언트에게 돌려주는 메시지
		return "(응답)" + msg;
	}
	
	@OnError
	public void handleError(Throwable e) {
		System.out.println("에러 발생 " + e.getMessage());
	}
	
}
