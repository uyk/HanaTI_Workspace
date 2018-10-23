<%-- 모든 페이지에서 상단에 표시되어 블로그 이름과 네비게이션바를 출력하는 header영역 jsp파일 --%>
<%@page import="kr.or.kosta.blog.board.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.board.dao.BoardDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
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
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
BoardDao boardDao = factory.getBoardDao();
List<Board> boardList = boardDao.listAll();
%>
<header role="banner">
  <div class="container logo-wrap">
    <div class="row pt-5">
      <div class="col-12 text-center">
        <a class="absolute-toggle d-block d-md-none" data-toggle="collapse" href="#navbarMenu" role="button" aria-expanded="false" aria-controls="navbarMenu"><span class="burger-lines"></span></a>
        <h1 class="site-logo"><a href="/index.jsp">Sea Fly</a></h1>
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
              <%
              for(int i=0; i< boardList.size(); i++){
           	  %>
           	  	  <a class="dropdown-item" href="/category.jsp?board=<%=boardList.get(i).getBoardId()%>&page=<%=request.getParameter("page")%>"><%=boardList.get(i).getTitle()%></a>
       	  	  <% 
          	  }
          	  %>
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