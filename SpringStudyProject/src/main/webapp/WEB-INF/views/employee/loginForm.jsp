<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <h2>로그인 화면</h2>
  <form method="post">
    <table border="10" width="500">
      <tr>
        <td>아이디</td>
        <td><input type="text" name="userId" value="${loginCommand.userId}"> <input type="checkbox" name="rememberId" ${loginCommand.rememberId ? "checked" : "" }>아이디 기억하기</td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td><input type="password" name="passwd"></td>
      </tr>
       <tr>
        <td colspan="2"><input type="submit" value="로그인"></td>
      </tr>
    </table>
  </form>

</body>
</html>