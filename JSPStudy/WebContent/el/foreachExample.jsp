<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<String> teams = new ArrayList<String>();
teams.add("한화 이글즈");
teams.add("두산 베어즈");
teams.add("SK 타이거즈");
request.setAttribute("teams", teams);
List<User> users = new ArrayList<User>();
users.add(new User("bangry1", "김기정", "1111", "aa@aa.aa", "2002"));
users.add(new User("bangry2", "김기정", "1111", "aa@aa.aa", "2002"));
users.add(new User("bangry3", "김기정", "1111", "aa@aa.aa", "2002"));
users.add(new User("bangry4", "김기정", "1111", "aa@aa.aa", "2002"));
request.setAttribute("users", users);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL default object 11</title>
</head>
<body>
<table border="1">
  <c:forEach var="i" begin="2" end="9">
    <tr>
      <c:forEach var="j" begin="1" end="9">
        <td>
          ${ i } * ${j } = ${i * j }
        </td>
      </c:forEach>
    </tr>
  </c:forEach>
</table>

<select>
  <c:forEach var="team" items="${teams}" >
    <option>${team}</option>
  </c:forEach>
</select>

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
          <td> ${user.id }</td>
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

<% 
String ssn = "940907-5555555";
request.setAttribute("ssn", ssn);
%>
<c:forTokens items="${ssn }" delims="-" var="token">
${token}<hr/>
</c:forTokens>
</body>
</html>