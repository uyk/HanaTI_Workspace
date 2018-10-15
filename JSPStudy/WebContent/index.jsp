<%@ page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body style="font-size: 20pt">
<%--JSP 테스트를 위한 페이지입니다. --%>
<%
String message = "jsp 실행 과정..";
Calendar today = Calendar.getInstance();
out.println(today.toString());
%>
===========================<br/>
<%
out.println("jsp 쉽다");
%>
===========================<br/>
===========================<br/>
<%
out.println("졸......려..");
%>
<%
int counter;
public void printMessage(String metmessage) {
  System.out.println(message);
}
%>
<%
String mas = '쉬자좀';

%>
메시지 : <%=msg %>;
</body>
</html>