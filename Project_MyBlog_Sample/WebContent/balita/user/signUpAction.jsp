<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="kr.or.kosta.jsp.dao.UserDao"%>
<%@page import="kr.or.kosta.jsp.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.jsp.dao.DaoFactory"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="kr.or.kosta.jsp.dao.User" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="user"></jsp:setProperty>
<%
// 아이디 중복검사 요청
if(request.getMethod().equals("GET")) {
  if(request.getParameter("id") == null) return;
  System.out.println("signUP get");
  String id = request.getParameter("id");

  // 회원 가입 여부 체크
  DaoFactory factory = new JdbcDaoFactory();
  UserDao dao = factory.getUserDao();
  // 존재하지 않는 아이디
  if(dao.read(id) == null){
    System.out.println("가능 :" + id);
    %>
    사용가능한 아이디입니다.
    <%
  }
  // 존재하는 아이디
  else {
    System.out.println("불가능 :" + id);
    %>
    사용할 수 없는 아이디입니다.
    <%
  } 
}
// 회원 가입 요청
else {
  DaoFactory factory = new JdbcDaoFactory();
  UserDao dao = factory.getUserDao();
  // dao.create(user);
  // 가입결과 jsp로 디스패치
  System.out.println("가입완료");
  %>
  <jsp:forward page="../index.jsp"></jsp:forward>
  <%
}
%>