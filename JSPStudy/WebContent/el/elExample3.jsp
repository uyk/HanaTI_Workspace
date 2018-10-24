<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%--<%@ page isELIgnored="true" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL default object 11</title>
</head>
<body>
<%
// 테스트를 위한 Scope객체에 데이터 저장
String today = String.format("%1$tF %1$tT", Calendar.getInstance());
request.setAttribute("today", today);

session.setAttribute("id", "bangry");

String[] names = {"김기정", "박기정", "최기정"};
%>

<%=request.getAttribute("today") %>
${requestScope.today}<br>
${today}<br>

<%= pageContext.findAttribute("id") %>
${id}<br>

${names[0]}, ${names[1]}, ${names[2]}<br>
<jsp:useBean id="dog" class="kr.or.kosta.jsp.el.Dog" scope="page"></jsp:useBean>
<jsp:setProperty property="name" name="dog" value="루니"/>
<jsp:useBean id="student" class="kr.or.kosta.jsp.el.Student" scope="page"></jsp:useBean>
<jsp:setProperty property="name" name="student" value="건이"/>
<jsp:setProperty property="dog" name="student" value="${dog}"/>
<%--<jsp:setProperty property="dog" name="student" value="<%=dog %>"/> --%>
<%--
<jsp:getProperty property="id" name="student"/>
<jsp:getProperty property="name" name="student"/>
<jsp:getProperty property="dog" name="student"/>
--%>
student name : ${student.name}, 
student dog : ${student.dog}, 
student dog name: ${student.dog.name}<br>
student name: ${student.getName()}<br>

</body>
</html>