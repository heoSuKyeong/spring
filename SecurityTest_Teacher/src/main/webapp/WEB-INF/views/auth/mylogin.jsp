<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	
</style>
</head>
<body>
	<!-- mylogin.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Login Page</h2>
	
	<!-- 
		주의사항
		1. 전송방식은 반드시, POST이어야한다.
		2. action="/컨텍스트명/login" > 이미 만들어져있는 예약어를 사용하는 것이다.
		3. 아이디의 name은 'username'
		4. 암호의 name은 'password'
	 -->
	
	<form method="post" action="/spring/login">
		<div>
			<input type="text" name="username" placeholder="ID" required>
		</div>
		<div>
			<input type="password" name="password" placeholder="Password" required>
		</div>
		
		<div>
			<button class="in">로그인</button>
		</div>
		
		<%-- <input type="hidden" name="${_csrf.parameterNmae}" value="${_csrf.token}"> --%>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
	</form>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>








