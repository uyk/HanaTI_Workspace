<%@page import="kr.or.kosta.blog.board.domain.Article"%>
<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao dao = factory.getArticleDao();
String board = request.getParameter("board");
int index = Integer.parseInt(request.getParameter("page"));
int boardId = 0;
if(board.equals("Notice")) {
	boardId = 1;
}
else if(board.equals("Korea")) {
  boardId = 2;
}
else if(board.equals("Japan")) {
  boardId = 3;
}
else if(board.equals("Croatia")) {
  boardId = 4;
}
System.out.println(board);
List<Article> list = dao.listByPage(boardId,index,5);
%>

<!-- 포스트 리스트 시작 -->
<div class="row mb-5 mt-5">
  <div class="col-md-12">
    <%
    for(int i=0; i<list.size(); i++){
      Article article = list.get(i);
    %>
      <div class="post-entry-horzontal">
        <a style="width: -webkit-fill-available;">
        
          <!-- <div class="image element-animate" data-animate-effect="fadeIn" style="background-image: url(/images/img_10.jpg);"></div> -->
          <span class="text">
            <div class="post-meta">
              <span class="category"><%=article.getWriter()%></span>
              <span class="mr-2"><%=article.getRegdate() %></span> &bullet;
              <!-- <span class="ml-2"><span class="fa fa-comments"></span> 3</span> -->
            </div>
            <h2><%=article.getSubject() %></h2>
          </span>
        </a>
      </div>
    <%
    }
    %>
  </div>
</div>
<!-- 포스트 리스트 끝 -->
<!-- 페이징 시작 -->
<div class="row">
  <div class="col-md-12 text-center">
    <nav aria-label="Page navigation" class="text-center">
      <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">Prev</a></li>
        <li class="page-item active"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
      </ul>
    </nav>
  </div>
</div>
<!-- 페이징 끝 -->