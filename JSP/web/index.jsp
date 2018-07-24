<%--
  Created by IntelliJ IDEA.
  User: felix6280
  Date: 2018. 7. 23.
  Time: AM 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
  Connection conn = null;

  try{
      String URL = "jdbc:mysql://localhost:3306/BlinkStudy";
      String ID = "root";
      String PASSWORD = "sda1628sda";

      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(URL, ID, PASSWORD);
      System.out.print("success");
  } catch (Exception e) {
      e.printStackTrace();
  }
%>