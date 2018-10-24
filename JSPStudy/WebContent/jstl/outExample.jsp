<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri=http://java.sun.com/jsp/jstl/core" %>
<%
String message= "jstl 연습";
request.setAttribute("message", message);
%>
<c:set var="message" value="jstl 연습" scope="page"/>
<jsp:useBean id="dog" class="kr.or.kosta.jsp.el.Dog" scope="page" />
<c:set target="${dog }" property="name" value="루니"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
${message }
<c:out value="${message}" default="기본메시지입니다"></c:out>
강아지이름: ${dog.name }
</body>
</html>