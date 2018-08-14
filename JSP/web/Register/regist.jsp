<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입</title>
</head>
<body>
	<form method="post" action="/backend/registAction.jsp">
		<h3 style="text-align: center:">회원가입 화면</h3>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디"
				name="ID" maxlength="20">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="비밀번호"
				name="password" maxlength="20">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="흥미"
				name="interest" maxlength="20">
		</div>c
		<input type="submit" class="btn btn-primory form-control" value="회원가입">
	</form>
</body>
</html>