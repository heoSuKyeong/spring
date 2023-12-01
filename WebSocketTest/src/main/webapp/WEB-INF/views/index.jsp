<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebSocketTest- chat</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	<!-- index.jsp -->
	<!-- 대화 시작 전 페이지 -->
	<h1>WebSocket <small>chat</small></h1>
	
	<div>
		<div class="group">
			<label>대화명</label>
			<input type="text" name="name" id="name" class="short">
		</div>
	</div>
	
	<div>
		<button type="button" class="in">들어가기</button>
		<button type="button" class="in" data-name="User1">들어가기(User1)</button>
		<button type="button" class="in" data-name="User2">들어가기(User2)</button>
		<button type="button" class="in" data-name="User3">들어가기(User3)</button>
		<button type="button" class="in" data-name="User4">들어가기(User4)</button>
	</div>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
	
	<script>
	
		$('.in').click(function() {
			let name = $('#name').val();
			
			if ($(event.target).data('name') != null && $(event.target).data('name') != '') {
				name = $(event.target).data('name');
			}
			
			let child = window.open('/socket/chat.do', 'chat', 'width=405', 'height=510');
			
			//child.connect(name);	//늦게 반응
			
			//DOM 방식으로만 가능
			child.addEventListener('load', function() {
				//자식창 다 뜨고 나면 발생
				child.connect(name);
			});
			
			//비활성화
			$('.in').css('opacity', .5).prop('disabled', true);
			$('#name').prop('readOnly', true);
		});
	
	</script>
</body>
</html>