<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="kr.or.kosta.jsp.dao.UserDao"%>
<%@page import="kr.or.kosta.jsp.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.jsp.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder"%> 
<!DOCTYPE html>
<html>
<head>
<%
pageContext.setAttribute("pageId", null); // 현재 페이지에 정보 저장
request.setCharacterEncoding("utf-8");
// URL을 통한 접속
if(request.getParameter("type") == null) {
	System.out.println("1");
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			if(cookie.getName().equals("loginId")) {
				pageContext.setAttribute("pageId", cookie.getValue()); // 현재 페이지에 정보 저장
			}
		}
	} 
}
//로그인할 때 쿠키 추가
else if(request.getParameter("type").equals("login")) {
  System.out.println("2");
  request.setCharacterEncoding("utf-8");
  String id = request.getParameter("userid");
  String pw = request.getParameter("userpw");
  id = URLEncoder.encode(id, "UTF-8");
  
  // 회원 가입 여부 체크
  DaoFactory factory = new JdbcDaoFactory();
  UserDao dao = factory.getUserDao();
  User user = dao.certify(id, pw);
  
  // 회원인 경우
  if(user != null) {
    pageContext.setAttribute("pageId", id );
    Cookie cookie = new Cookie("loginId", id);
    System.out.println(cookie.getName() + " : " + cookie.getValue());
    cookie.setPath("/");
    response.addCookie(cookie);
  }
  
  // 회원이 아닌 경우
  else {
    %>
    <script>
    alert("아이디와 비밀번호를 확인해주세요");
    history.back();
    </script>
    <%
  }
  //response.sendRedirect(application.getContextPath()+"index.jsp");
}
// 로그아웃할 때 쿠키 제거
else if(request.getParameter("type").equals("logout")) {
  System.out.println("3");
  Cookie[] cookies = request.getCookies();
  if(cookies != null) {
    for (Cookie cookie : cookies) {
      System.out.println("[logout]" + cookie.getName() + " : " + cookie.getValue());
      if(cookie.getName().equals("loginId")) {
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
      }
    }
  }
}
else {
	System.out.println("d");
}
%>


<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="<%= application.getContextPath()%>/css/basic.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="header">
  <h1>My Website</h1>
  <p>Resize the browser window to see the effect.</p>
</div>
<%--탑 메뉴 시작--%>
<jsp:include page="/include/navigator.jsp"></jsp:include>
<%--탑 메뉴 종료--%>
<div class="row">
  <div class="leftcolumn">
    <!-- Page content -->
    <div class="w3-content">
      <div class="w3-container" id="contact">
        <h2>회원가입</h2>
        <p>※ 좋은 것 서비스 받을려면 회원가입혀~~^^</p>
        <form action="regist_action.jsp" method="post">
          <p>
            <input class="w3-input w3-padding-16 w3-border" type="text"
              placeholder="아이디" required name="id">
          </p>
          <p>
            <input class="w3-input w3-padding-16 w3-border" type="text"
              placeholder="이름" required name="name">
          </p>
          <p>
            <input class="w3-input w3-padding-16 w3-border"
              type="password" placeholder="비밀번호" required name="passwd">
          </p>
          <p>
            <input class="w3-input w3-padding-16 w3-border" type="text"
              placeholder="이메일" required name="email">
          </p>
          <p>
            <button class="w3-button w3-red w3-padding-large"
              type="submit">가입하기</button>
            <button class="w3-button w3-blue w3-padding-large"
              type="reset">취소하기</button>
          </p>
        </form>
      </div>
    </div>
     현재페이지에 맞는 내용
  </div>
  <%--우측 메뉴 시작--%>
  <jsp:include page="/include/asside.jsp"></jsp:include>
  <%--우측 메뉴 종료--%>
</div>
<%--하단 메뉴 시작--%>
<jsp:include page="/include/footer.jsp"></jsp:include>
<%--하단 메뉴 종료--%>

</body>
</html>