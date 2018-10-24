<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>URL Example</title>
</head>
<body>
<%
String url = "http://www.naver.com";
%>
<a href="<%=url%>">이동</a>

<c:url var="url" value="http://www.naver.com">
  <c:param name="id" value="bangry"></c:param>
  <c:param name="name" value="김기정"></c:param>
</c:url>
<a href="${url }">이동</a>
</body>
</html>