<%@ page contentType="text/html; charset=utf-8" %>
<%
pageContext.setAttribute("pageId", null); // 현재 페이지에 정보 저장
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

<div class="topnav">
  <a href="#">Link</a>
  <a href="#">Link</a>
  <a href="#">Link</a>
  <a href="#" style="float:right">Link</a>
</div>

<div class="row">
  <div class="leftcolumn">
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
  </div>
  
  <div class="rightcolumn">
    <div class="card">
      <%  
      //로그인중이 아님
      if(pageContext.getAttribute("pageId") == null) { 
      %>
      <div id="loginDiv">
        <form action="loginAction.jsp" method="post">
          <input type="text" id="userid" name="userid" placeholder="Identifier...">
          <input type="password" id="userpw" name="userpw" placeholder="Password...">
          <input type="submit" value="Login">
          <input type="text" id="type" name="type" style="visibility: hidden;" value="login">
        </form>
      </div>      
      <%  
      }
      // 로그인중
      else{ 
      %>
      <div id="logoutDiv">
        <form action="loginAction.jsp" method="get">
          <label id="userInfo"> <%=pageContext.getAttribute("pageId") %>님이 로그인중..</label>
          <input type="submit" value="Logout">
          <input type="text" id="type" name="type" style="visibility: hidden;" value="logout">
        </form>
      </div>   
      <%  
      } 
      %>
    </div>
    
    <div class="card">
      <h3>Popular Post</h3>
      <div class="fakeimg"><p>Image</p></div>
      <div class="fakeimg"><p>Image</p></div>
      <div class="fakeimg"><p>Image</p></div>
    </div>
    <div class="card">
      <h3>Follow Me</h3>
      <p>Some text..</p>
    </div>
  </div>
</div>

<div class="footer">
  <h2>Footer</h2>
</div>

</body>
</html>