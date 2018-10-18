<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@page import="kr.or.kosta.blog.user.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.dao.DaoFactory"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="kr.ork.kosta.blog.user.domain.User" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="user"></jsp:setProperty>
<%
DaoFactory factory = new JdbcDaoFactory();
UserDao dao = factory.getUserDao();
dao.create(user);

// 가입결과 jsp로 디스패치
System.out.println("가입완료");
%>
<jsp:forward page="regis_result.jsp"></jsp:forward>