<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="DAO.UserDAO" %>
<%@page import="java.io.PrintWriter" %>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="User.RegisterUser" scope="page" />
<jsp:setProperty name="user" property="ID" />
<jsp:setProperty name="user" property="interest"/>
<jsp:setProperty name="user" property="password" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
		if(user.getID()==null || user.getInterest()==-1 || user.getPassword()==null)  {
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안된 사항이 있습니다.')");
			script.println("history.back()"); 
			script.println("</script>");
		}
		UserDAO userDAO=new UserDAO();
		int result=userDAO.join(user);
		if(result==-1) {
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다.')"); 
			script.println("history.back()");
			script.println("</script>");
		}
		else {
			PrintWriter script=response.getWriter();
			script.println("<script>");
			System.out.println("회원가입 완료");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}

	%>
</body>
</html>