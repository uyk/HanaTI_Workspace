<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder"%> 
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
      
  pageContext.setAttribute("pageId", id );
  Cookie cookie = new Cookie("loginId", id);
  System.out.println(cookie.getName() + " : " + cookie.getValue());
  cookie.setPath("/");
  response.addCookie(cookie);
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

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/basic.css">
</head>
<body>
<div class="header">
  <h1>My Website</h1>
  <p>Resize the browser window to see the effect.</p>
</div>
<%--탑 메뉴 시작--%>
<jsp:include page="include/navigator.jsp"></jsp:include>
<%--탑 메뉴 종료--%>
<div class="row">
  <div class="leftcolumn">
    <!-- 
    <div class="card">
      <h2>TITLE HEADING</h2>
      <h5>Title description, Dec 7, 2017</h5>
      <div class="fakeimg" style="height:200px;">Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
    <div class="card">
      <h2>TITLE HEADING</h2>
      <h5>Title description, Sep 2, 2017</h5>
      <div class="fakeimg" style="height:200px;">Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
     -->
     현재페이지에 맞는 내용
  </div>
  <%--우측 메뉴 시작--%>
  <jsp:include page="include/asside.jsp"></jsp:include>
  <%--우측 메뉴 종료--%>
</div>
<%--하단 메뉴 시작--%>
<jsp:include page="include/footer.jsp"></jsp:include>
<%--하단 메뉴 종료--%>

</body>
</html>