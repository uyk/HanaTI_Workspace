<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<form action="/sjrent/user/login.rent">
<input type="text" id="id" name="id" placeholder="id">
<input type="text" id="pw" name="pw" placeholder="pw">
<input type="submit" value="login">
</form>
<span><%=application.getAttribute("loginId") %></span>
<button onclick="location.href='/sjrent/user/logout.rent'">logout</button>
</body>
</html>