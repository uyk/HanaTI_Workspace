<%@page import="kr.or.kosta.blog.user.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@page import="kr.or.kosta.blog.common.JdbcDaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
DaoFactory factory = new JdbcDaoFactory();
UserDao dao = factory.getUserDao();
List<User> list = dao.listAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<table border="1" width="50%">
  <tr>
    <th>아이디</th>
    <th>이름</th>
    <th>이메일</th>
    <th>가입일자</th>
  </tr>
  <% 
  for(User user : list) {
  %>
  <tr>
    <td><%= user.getId() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getEmail() %></td>
    <td><%= user.getRegdate() %></td>
  </tr>
  <% }%>
</table>
</body>
</html>