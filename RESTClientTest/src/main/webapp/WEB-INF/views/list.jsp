<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESTClientTest</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<!-- list.jsp  -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<div class="list full">
		<!-- 
		<div class="item">
			<div class="name">수수깡 <span class="material-symbols-outlined female">female</span></div>
			<div class="address">서울시 강남구 역삼동</div>
		</div>
		 -->
		 
	</div>

	<div>
		<button class="add" type="button" onclick="location.href='/client/add.do';">등록하기</button>
	</div>
	
	<script>
		
		//상당수 REST API Server를 이용하는 클라이언트는 Ajax를 사용한다.
		//CSR 방식으로 페이지를 만들게된다.
		$.ajax({
			type: 'GET',
			url: 'http://localhost:8090/rest/address',
			dataType: 'json',
			success: list => {
				$(list).each((index, item) => {
					
					let gender = item.gender == 'm' ? 'male' : 'female';
					
					$('.list').append(`
							<div class="item" onclick = "view(\${item.seq});">
								<div class="name">\${item.name} <span class="material-symbols-outlined \${gender}">\${gender}</span></div>
								<div class="address">\${item.address}</div>
							</div>
							`);
				});
			},
			error: (a,b,c) => {
				console.log(a,b,c);
			}
		});
		
		function view(seq){
			//alert(seq);
			location.href='/client/view.do?seq=' + seq;
		}
	</script>
</body>
</html>