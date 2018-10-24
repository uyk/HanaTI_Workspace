<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL default object 11</title>
</head>
<body>
<%--<c:import url="https://www.naver.com"></c:import> --%>
<c:import url="https://www.naver.com" var="output"></c:import> 
!!!!!!!!!!!!1<br/>
<%--${output } --%>
<c:out value="${output }"></c:out>
</body>
</html>