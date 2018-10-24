<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="score" value="85" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL default object 11</title>
</head>
<body>
<%
int score = 0;
if(request.getParameter(("score")) != null) {
	score = Integer.parseInt(request.getParameter(("score")));
}
if(score >= 50) {
 %>
 통과
 <% 
}
%>
<hr/>
<c:if test="${score >= 50 }">
통과
</c:if>
<c:if test="${empty param }">
  <c:set var="page" value="1"/>
</c:if>
</body>
</html>