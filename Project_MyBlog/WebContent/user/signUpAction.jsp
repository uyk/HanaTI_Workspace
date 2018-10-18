<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="kr.or.kosta.jsp.dao.UserDao"%>
<%@page import="kr.or.kosta.jsp.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.jsp.dao.DaoFactory"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="kr.or.kosta.jsp.dao.User" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="user"></jsp:setProperty>
<%
DaoFactory factory = new JdbcDaoFactory();
UserDao dao = factory.getUserDao();
// 중복검사 요청
if(request.getMethod().equals("GET")) {
  // 아이디 중복검사
  if(request.getParameter("id") != null) {
	  String id = request.getParameter("id");
	  // 존재하지 않는 아이디
	  if(dao.read(id) == null){
	    System.out.println("가능 아이디 :" + id);
	    %>
	    사용가능한 아이디입니다.
	    <%
	  }
	  // 존재하는 아이디
	  else {
	    System.out.println("불가능 아이디 :" + id);
	    %>
	    사용할 수 없는 아이디입니다.
	    <%
	  } 
  }
  // 이메일 중복검사
  else if(request.getParameter("email") != null) {
      String email = request.getParameter("email");
	  // 존재하지 않는 이메일
	  if(dao.readEmail(email) == null){
	    System.out.println("가능 이메일 :" + email);
	    %>
	    사용가능한 아이디입니다.
	    <%
	  }
	  // 존재하는 아이디
	  else {
	    System.out.println("불가능 이메일 :" + email);
	    %>
	    사용할 수 없는 아이디입니다.
	    <%
	  }
  }
  // 잘못된 접근
  else {
    
  }
  System.out.println("signUP get");

}
// 회원 가입 요청
else {
  dao.create(user);
  // 가입결과 jsp로 디스패치
  System.out.println("가입완료");
  %>
  <jsp:forward page="/result.jsp"></jsp:forward>
  <%
}
%>  