<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebSocketTest</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	<!-- test.jsp -->
	<h1>WebSocket <small>연결 테스트</small></h1>
	
	<div>
		<button type="button" class="in" id="btnConnect">연결하기</button>
		<button type="button" class="out" id="btnDisConnect">종료하기</button>
	</div>
	<hr>
	
	<div>
		<input type="text" class="long" id="msg">
		<button type="button" id="btnMsg">보내기</button>
	</div>
	
	<div class="message full"></div>
	<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
	
	<script>
	//클라이언트와 서버 연결
	//ws(WebSocket) 프로토콜을 사용한다.
		const url = 'ws://localhost:8090/socket/testserver.do';
		
		//웹 소켓 참조 변수
		let ws;
		/* 			
		1. 소켓 생성
		2. 서버 접속(연결)
		3. 통신
		4. 서버 접속 해제(종료)
		 */
		$('#btnConnect').click(function() {
			
			//소켓 생성 및 서버 접속 시도
			ws = new WebSocket(url);
			
			//소켓 이벤트로 연결 확인
			ws.onopen = function(evt) {
				
				//서버측에서 소켓 연결을 받아들이고 연결이 되는 순간 이벤트가 발생한다.
				//각종 행위들이 이벤트로 구현이 되어 있어 클라이언트는 비동식 방식으로 다른 업무를 하다가 연락이 오는 걸을 확인할 수 있다.
				log('서버와 연결하였습니다.');
				//console.log('서버와 연결하였습니다.');
			};
			//console.log('버튼 클릭.');
			
			ws.onclose = function(evt) {
				log('서버와 연결이 종료되었습니다.');
			};
			
			//서버가 클라이언트(나)에게 메시지를 보낼 때 생성
			ws.onmessage = function(evt) {
				log(evt.data);
			};
			
			ws.onerror = function(evt) {
				log('에러가 발생했습니다.' + evt);
			};
		});
		
		$('#btnDisConnect').click(function() {
			
			//클라이언트에서 전화기를 끊는다. 종료할 때 약간의 딜레이가 있어서 언제 끊겼는지 한번 더 확인한다.
			ws.close();
			log('서버와 연결 종료를 시도합니다.');
			
		});

		
		function log(msg) {
			$('.message').prepend(`
				<div>[\${new Date().toLocaleTimeString()}] \${msg}</div>		
			`);
		}
		
		
		$('#btnMsg').click(function() {
			//연결된 서버에게 메시지 전송하기
			//ws.send('전달할 ㅁ시지');
			ws.send($('#msg').val());
			//ws.send($('#msg').val());
			log('메시지를 전송했습니다.');
			
			//다음 전송할 때의 위해 초기화
			$('#msg').val('');
			
		});
		
		
		
	</script>
</body>
</html>