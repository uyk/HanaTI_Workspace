<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
String message = request.getParameter("message");
System.out.println("메시지 수신 : " + message);
out.println(message);
%>