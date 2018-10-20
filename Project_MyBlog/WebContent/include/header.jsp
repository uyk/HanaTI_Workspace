<%@ page contentType="text/html; charset=utf-8" %>
<%
// 쿠키를 검사하여 로그인상태면 id를 페이지 컨텍스트에 저장
pageContext.setAttribute("id", null);
Cookie[] cookies = request.getCookies();
if(cookies != null) {
  for (Cookie cookie : cookies) {
    if(cookie.getName().equals("id")) {
      pageContext.setAttribute("id", cookie.getValue()); // 현재 페이지에 정보 저장
    }
  }
}
%>
<header role="banner">
  <div class="container logo-wrap">
    <div class="row pt-5">
      <div class="col-12 text-center">
        <a class="absolute-toggle d-block d-md-none" data-toggle="collapse" href="#navbarMenu" role="button" aria-expanded="false" aria-controls="navbarMenu"><span class="burger-lines"></span></a>
        <h1 class="site-logo"><a href="/index.jsp">Blog</a></h1>
      </div>
    </div>
  </div>
  
  <nav class="navbar navbar-expand-md  navbar-light bg-light">
    <div class="container">
    
      <div class="collapse navbar-collapse" id="navbarMenu">
        <ul class="navbar-nav mx-auto">
          <li class="nav-item">
            <a class="nav-link active" href="/index.jsp">Home</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories</a>
            <div class="dropdown-menu" aria-labelledby="dropdown04">
              <a class="dropdown-item" href="/category.jsp?board=Notice&page=<%=request.getParameter("page")%>">Notice</a>
              <a class="dropdown-item" href="/category.jsp?board=Korea&page=<%=request.getParameter("page")%>">Korea</a>
              <a class="dropdown-item" href="/category.jsp?board=Japan&page=<%=request.getParameter("page")%>">Japan</a>
              <a class="dropdown-item" href="/category.jsp?board=Croatia&page=<%=request.getParameter("page")%>">Croatia</a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/about.jsp">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/guestBook.jsp">Guest Book</a>
          </li>
          <%  
          //로그인중이 아님
          if(pageContext.getAttribute("id") == null) { 
          %>
          <li class="nav-item">
            <a class="nav-link" href="/signIn.jsp">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/signUp.jsp">Sign up</a>
          </li>
          <%  
          }
          // 로그인중
          else{ 
          %>
          <li class="nav-item">
            <a class="nav-link" href="/action/signInAction.jsp">Logout</a>
          </li> 
          <%  
          } 
          %>

        </ul>
      </div>
      
    </div>
  </nav>
</header>