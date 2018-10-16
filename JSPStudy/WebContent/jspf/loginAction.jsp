<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
String firstName = request.getParameter("firstname");
String lastName = request.getParameter("lastname");
String country = request.getParameter("country");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%=firstName %>
<%=lastName %>
<%=country %>
</body>
</html>