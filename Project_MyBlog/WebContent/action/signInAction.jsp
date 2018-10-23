<%-- 로그인 액션을 처리하는 jsp파일 --%>
<%@ page import="kr.or.kosta.blog.user.domain.User"%>
<%@ page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@ page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
DaoFactory factory = (DaoFactory)application.getAttribute("factory");

//로그인할 때 쿠키 추가
if(request.getMethod().equals("POST")) {
  String id = request.getParameter("id");
  String pw = request.getParameter("pw");

  // 회원 가입 여부 체크
  UserDao dao = factory.getUserDao();
  User user = dao.certify(id, pw);
  System.out.println(user);
  
  // 회원인 경우
  if(user != null) {
    Cookie cookie = new Cookie("id", id);
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
  Cookie[] cookies = request.getCookies();
  if(cookies != null) {
    for (Cookie cookie : cookies) {
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