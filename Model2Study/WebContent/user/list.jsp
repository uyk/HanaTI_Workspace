<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>회원목록</h2>
<table border="1">
  <tr>
    <th>번호</th>
    <th>아이디</th>
    <th>이름</th>
    <th>비밀번호</th>
    <th>이메일</th>
    <th>가입일자</th>
  </tr>
  <c:choose>
    <c:when test="${not empty users }">
      <c:forEach var="user" items="${users}" varStatus="status">
        <tr>
          <td>${staus.count}</td>
          <td>${user.id }</td>
          <td>${user.name }</td>
          <td>${user.passwd }</td>
          <td>${user.email}</td>
          <td>${user.regdate}</td>
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <td colspan="5">회원이 존재하지 않습니다.</td>
    </c:otherwise>
  </c:choose>
</table>
</body>
</html>