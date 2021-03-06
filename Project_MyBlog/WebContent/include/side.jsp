<%-- 일부 페이지에 추가되어 사용자 정보, 인기 포스트 등의 정보를 제공하는 side 영역 jsp파일 --%>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@page import="kr.or.kosta.blog.board.domain.Article"%>
<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.board.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.board.dao.BoardDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
//쿠키를 검사하여 로그인상태면 id를 페이지 컨텍스트에 저장
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
ArticleDao articleDao = factory.getArticleDao();
UserDao userDao = factory.getUserDao();
// 가장 인기있는 게시글 상위 3가지
int populars = 3;
List<Board> boardList = boardDao.listAll();
List<Article> popularAs = articleDao.listPopular(populars);
%>
<div class="col-md-12 col-lg-4 sidebar">
  <div class="sidebar-box search-form-wrap">
  </div>
  <!-- END sidebar-box -->
  <%
  // 로그인중
  if ( pageContext.getAttribute("id") != null) {
  %>
  <div class="sidebar-box">
    <div class="bio text-center">
      <img src="/images/person_1.jpg" alt="Image Placeholder" class="img-fluid">
      <div class="bio-body">
        <h2><%= pageContext.getAttribute("id") %></h2>
        <p><%= userDao.read((String)pageContext.getAttribute("id")).getName() %> 님 환영합니다 <i class="far fa-smile-wink"></i></p>
        <p><a href="/action/signInAction.jsp" class="btn btn-primary btn-sm">Logout</a></p>
      </div>
    </div>
  </div>
  <%
  }
  %>
  <!-- END sidebar-box -->  
  <div class="sidebar-box">
    <h3 class="heading">Popular Posts</h3>
    <div class="post-entry-sidebar">
      <ul>
        <%-- 각 포스트 시작 --%>
        <%
        for(int i=0; i< popularAs.size(); i++){
        %>
        <li>
          <a href="/blog-single.jsp?article=<%=popularAs.get(i).getArticleId()%>&page=1">
            <img src="/images/img_<%=2*(i+2) %>.jpg" alt="Image placeholder" class="mr-4">
            <div class="text">
              <h4><%=popularAs.get(i).getSubject()%></h4>
              <div class="post-meta">
                <span class="mr-2"><%=popularAs.get(i).getRegdate()%></span> &bullet;
                <span class="ml-2"><span class="fas fa-eye"></span>&nbsp;<%=popularAs.get(i).getHitcount() %></span>
              </div>
            </div>
          </a>
        </li>
        <% 
        }
        %>
      </ul>
    </div>
  </div>
  <!-- END sidebar-box -->

  <div class="sidebar-box">
    <h3 class="heading">Categories</h3>
    <ul class="categories">
      <%
      for(int i=0; i< boardList.size(); i++){
      %>
          <li><a href="/category.jsp?board=<%=boardList.get(i).getBoardId()%>&page=<%=request.getParameter("page")%>"><%=boardList.get(i).getTitle()%><span>(<%=boardDao.countArticles(i+1) %>)</span></a></li>
      <% 
      }
      %>
    </ul>
  </div>
  <!-- END sidebar-box -->
</div>
<!-- END sidebar -->