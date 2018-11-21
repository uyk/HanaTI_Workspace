<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<div>
<h1>Logout Page</h1>
  <form action="customLogout" method="post">
    <button>로그아웃</button>
    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
  </form>
</div>

</body>
</html>
