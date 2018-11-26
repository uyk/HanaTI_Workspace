<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    width: 600px;
    border-radius: 5px;
    background-color: #f2f2f2;
    margin: 50px auto;
    padding: 20px;
}
</style>
</head>
<body>
<div>
<h3>Custom Login Page</h3>
<p style="color: red">${error}</p>
<p style="color: red">${logout}</p>
<p style="color: red"></p>
  <form action="login" method="post">
    <label for="username">User name</label>
    <input type="text" name="username" id="username" placeholder="username.." value="admin90">

    <label for="password">Password</label>
    <input type="password" name="password" id="password" placeholder="password.." value="pw90">
    
    <input type="checkbox" name="remember-me" id="remember-me">
    <label for="remember-me">로그인 상태 유지</label>
    
    <input type="submit" value="Login">
    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
  </form>
</div>

</body>
</html>
