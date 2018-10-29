<%@ page contentType="text/html; charset=utf-8" %>
  
  <div class="rightcolumn">
    <div class="card">
      <%  
      //로그인중이 아님
      if(pageContext.getAttribute("pageId") == null) { 
      %>
      <div id="loginDiv">
        <form action="<%= application.getContextPath()%>/user/regist_form.jsp" method="post">
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
        <form action="<%= application.getContextPath()%>/user/regist_form.jsp" method="get">
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