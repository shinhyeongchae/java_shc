<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 회원가입 -->
	<div class="contanier">
		<form method="post">
		  <!--회원가입--> 
			<h1 class="text-center">회원가입</h1>
			<!--아이디-->
			<div class="form-group">
			  <label for="me_id">아이디</label>
			  <input type="text" class="form-control" id="me_id" name="me_id">
			</div>
			<!--비밀번호-->
			<div class="form-group">
			  <label for="me_pw">비밀번호:</label>
			  <input type="password" class="form-control" id="me_pw" name="me_pw">
			</div>
			<!--비밀번호 확인-->
			<div class="form-group">
			  <label for="me_pw2">비밀번호 확인:</label>
			  <input type="password" class="form-control" id="me_pw2" name="me_pw2">
			</div>
			<!-- 아이디, 비밀번호, 비밀번호 확인 end -->
			<!--성별-->
			<div class="form-group">
			  <label>성별:</label>
			</div>
			<!--남성-->
			<div class="form-group">
				<div class="form-check-inline">
				  <label class="form-check-label">
				    <input type="radio" class="form-check-input" name="me_gender" value="M">남성
				  </label>
				</div>
				<!--여성-->
				<div class="form-check-inline">
				  <label class="form-check-label">
				    <input type="radio" class="form-check-input" name="me_gender" value="F">여성
				  </label>
				</div>
				<div>
					<label class="error" id="me_gender-error" for="me_gender"></label>
				</div>
			</div>
			<!-- 남성, 여성 선택 end -->
			<!--이메일-->
			<div class="form-group">
			  <label for="me_email">이메일</label>
			  <input type="text" class="form-control" id="me_email" name="me_email">
			</div>
			<!-- 이메일 end -->
			<!--생년월일-->
			<div class="form-group">
			  <label for="me_birth">생년월일</label>
			  <input type="text" class="form-control" id="me_birth" name="me_birth">
			</div>
			<!-- 생년월일 end -->
			<!--회원가입버튼-->
			<button class="btn btn-outline-success col-12 mb-5">회원가입</button>
		</form>
	</div>
	<!-- 스크립트 시작 -->
	<script type="text/javascript">
		$(function(){
			$( "#me_birth" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      dateFormat: 'yy-mm-dd',
	      yearRange: "1900:2022"
			});
		})
	</script>
</body>
</html>