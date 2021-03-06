<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="kr.or.kosta.jsp.dao.UserDao"%>
<%@page import="kr.or.kosta.jsp.dao.DaoFactory"%>
<%@page import="kr.or.kosta.jsp.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.jsp.common.web.PageBuilder"%>
<%@page import="kr.or.kosta.jsp.common.web.Params"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="user" class="kr.or.kosta.jsp.dao.User" scope="request"/>
<jsp:setProperty property="*" name="user"/>
<%
//DaoFactory factory = new JdbcDaoFactory();
DaoFactory factory = (DaoFactory)application.getAttribute("daoFactory");
UserDao dao = factory.getUserDao();
dao.create(user);

// 가입결과 jsp로 디스패치
%>

<jsp:forward page="regist_result.jsp"/>