<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div class="container">
		<form action="/spring/login" class="mt-3" method="post">
			<h4 class="text-center">로그인</h4>
		<div class="form-group">아이디 :
	 		<input type="text" class="form-control" name="me_id" placeholder="아이디를 입력하세요.">
		</div>
			<div class="form-group">비밀번호 :
	  		<input type="password" class="form-control" name="me_pw" placeholder="비밀번호를 입력하세요.">
			</div>
			<button class="btn btn-outline-success col-12 mb-3">전송</button>
		</form>
			
		<script type="text/javascript">
		
		</script>
	</div>
</body>
</html>