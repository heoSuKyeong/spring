package com.test.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.domain.Message;

@ServerEndpoint("/chatserver.do")
public class ChatServer {
	
	//서버에서는 유저1의 소켓과 유저2의 소켓을 각각 관리를 해야한다.
	//현재 채팅서버에 접속 중인 클라이언트 목록
	//websocket의 session은 채팅에 접속한 클라이언트의 상태를 관리한다.
	//1명 이상이 접속하기에 arraylist로 관리한다. 
	//클라이언트가 접속했을 때 list에 session을 추가한다.
	private static List<Session> sessionList = new ArrayList<Session>();
	
	
	//클라이언트 접속
	@OnOpen
	public void handleOpen(Session session) {
		System.out.println("클라이언트가 접속했습니다.");
		
		sessionList.add(session);
		checkSessionList();			//접속자 확인
		clearSessionList();			//대화방에 연결이 끊긴 유저가 있으면 리스트에서 제거한다.
	}
	
	//클라이언트로부터 메시지 전달
	@OnMessage
	public void handleMessage(String msg, Session session) {
		System.out.println(msg);
		
		//Gson : JSON 형식의 문자열을 자바클래스 객체로 변환한다.
		Gson gson = new Gson();
		
		//json의 프로퍼티 이름과 message.class의 세터를 이용하여 오보젝트를 만든다?
	 	Message message =  gson.fromJson(msg, Message.class);
		
		//System.out.println(message);
	 	
	 	//
	 	if (message.getCode().equals("1")) { //상대방 대화방 입장
	 		for (Session s : sessionList) {
	 			//모든 접속자 중에서 방금 메시지를 보낸 세션을 제외하고 나머지 세션을 검색한다.
	 			if (s != session) {
	 				//본인이외의 세션(소켓)에게 현재 접속자를 알리는 메시지를 전달한다.
	 				try {
						//getBasicRemote: 세션과 관련된 소켓을 반환한다.
	 					s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
	 			}
	 		}
	 	} else if (message.getCode().equals("2")) { //상대방 대화방 나감
	 		//나간 유저의 세션제거
	 		sessionList.remove(session);
	 		
	 		for (Session s : sessionList) {
	 			try {
					//상대방이 나간 메시지를 남아있는 모든 유저에게 전달한다.
	 				s.getBasicRemote().sendText(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
	 		}
	 	} else if (message.getCode().equals("3")) {		//상대방 메시지 전송
	 		
	 		//보낸 사람빼고 나머지 사람에게 전달한다.
	 		for (Session s : sessionList) {
	 			if (s != session) {
	 				try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
	 			}
	 		}
	 		
	 	} else if (message.getCode().equals("4")) {		//상대방 메시지 전송
	 		//보낸 사람빼고 나머지 사람에게 전달한다.
	 		for (Session s : sessionList) {
	 			if (s != session) {
	 				try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
	 			}
	 		}
	 	}
	 	
		
	}
	
	//접속자를 확인하는 메서드
	private void checkSessionList() {
		System.out.println();
		System.out.println("[Session List]");
		for (Session session : sessionList) {
			System.out.println(session.getId());
		}
		System.out.println();
	}
	
	//안정성을 위한 메서드 : 연결이 끊어진 세션이 있으면 세션리스트에서 제거한다.
	private void clearSessionList() {
		
		//List 계열의 컬렉션은 향상된 for문 내에서 요소 추가/삭제하는 행동을 할 수 없다.
		//가능한 방법은 1. 일반 forans, 2. Interator 방법이 있다.
		Iterator<Session> iter = sessionList.iterator();
		
		while(iter.hasNext()) {
			if(!(iter.next()).isOpen()) {
				//혹시 연결이 끊어진 세션이 있으면 리스트에서 제거한다.
				iter.remove();
			}
		}
		
	}
	
}
