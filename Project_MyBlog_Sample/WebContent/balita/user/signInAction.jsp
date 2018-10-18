<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="kr.or.kosta.jsp.dao.UserDao"%>
<%@page import="kr.or.kosta.jsp.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.jsp.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
System.out.println(request);
System.out.println(request.getMethod());
%>
<%
//로그인할 때 쿠키 추가
if(request.getMethod().equals("POST")) {
  System.out.println("2");
  String id = request.getParameter("id");
  String pw = request.getParameter("pw");
  System.out.println(id + ":" + pw);

  // 회원 가입 여부 체크
  DaoFactory factory = new JdbcDaoFactory();
  UserDao dao = factory.getUserDao();
  User user = dao.certify(id, pw);
  System.out.println(user);
  
  // 회원인 경우
  if(user != null) {
    Cookie cookie = new Cookie("id", id);
    System.out.println(cookie.getName() + " : " + cookie.getValue());
    cookie.setPath("/");
    response.addCookie(cookie);
    response.sendRedirect("../index.jsp");
  }
  
  // 회원이 아닌 경우
  else {
    System.out.println("Login Fail");
    %>
    <script>
    alert("아이디와 비밀번호를 확인해주세요.");
    </script>
    <%
    response.sendRedirect("../signIn.jsp");
    
  }
}

// 로그아웃할 때 쿠키 제거
else {
  System.out.println("3");
  Cookie[] cookies = request.getCookies();
  if(cookies != null) {
    for (Cookie cookie : cookies) {
      System.out.println("[logout]" + cookie.getName() + " : " + cookie.getValue());
      if(cookie.getName().equals("id")) {
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
      }
    }
  }
  response.sendRedirect("../index.jsp");
}
%>