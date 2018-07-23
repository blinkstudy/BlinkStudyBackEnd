<%--
  Created by IntelliJ IDEA.
  User: felix6280
  Date: 2018. 7. 23.
  Time: AM 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page import="ConnectDB" %>

<%
  request.setCharacterEncoding("UTF-8");
  String id = request.getParameter("id");
  String pw = request.getParameter("pw");

%>