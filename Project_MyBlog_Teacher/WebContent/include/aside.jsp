<%@ page contentType="text/html; charset=utf-8" %>

<%
String loginId = null;

Cookie[] cookies = request.getCookies();
if(cookies != null) {
  for (Cookie cookie : cookies) {
    if(cookie.getName().equals("loginId")) {
      loginId = cookie.getValue();
    }
  }
}
%>

<div class="rightcolumn">
    <div class="card">
      <%
      if(loginId == null){
      %>
      <div>
        <form action="<%=application.getContextPath() %>/user/loginAction.jsp">
          <input type="text" id="userid" name="userid" placeholder="Identifier...">
          <input type="password" id="userpw" name="userpw" placeholder="Password...">
          <input type="submit" value="Login">
        </form>
      </div>
      <%
      }else{
      %>
      <div>
        <p><%=loginId %>님 로그인중...</p>
        <button onclick="location.href='<%=application.getContextPath()%>/user/logout.jsp';">Logout</button>
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