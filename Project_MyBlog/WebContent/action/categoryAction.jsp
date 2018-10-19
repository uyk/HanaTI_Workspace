<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.kosta.blog.board.domain.Article"%>
<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao dao = factory.getArticleDao();
Enumeration e = request.getParameterNames();
while(e.hasMoreElements()) {
  System.out.println(e.nextElement()); 
}
String board = request.getParameter("board");
String index = request.getParameter("page");
System.out.println(board + " : " +index);

if(index == null || index.equals("")){
	index = "1";
}

// 게시판 분류
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

//검색 요청일 경우 파라메터 수신. 없을경우 null
String searchType = request.getParameter("searchType");
String searchValue = request.getParameter("searchValue");
if(searchType == null || searchType.equals("")){
  searchType = null;
  searchValue = null;
}

// 페이징 연산
// 페이지당 보여지는 목록수 설정
int listSize = 3;
//페이징 처리에 필요한 검색 개수 DB조회
int rowCount = dao.countBySearch(searchType, searchValue, boardId);
//페이지 개수
int pageCount = (int)Math.ceil((double)rowCount / listSize);
System.out.println(rowCount + ", " + pageCount);
//페이지 목록의 시작페이지번호와 마지막페이지번호 계산
//목록별 번호
int pageSize = 5;
int listNo = (Integer.parseInt(index) - 1) / pageSize; // 목록 식별번호
//(1~5): 0, (6~10): 1, (11~15): 2, .....

int startPage = (listNo * pageSize) + 1;
int endPage = (listNo * pageSize) + pageSize;

if (endPage > pageCount){
endPage = pageCount;
}
List<Article> list = dao.listByPage(boardId,Integer.parseInt(index),listSize);

%>

<%-- 포스트 리스트 시작 --%>
<div class="row mb-5 mt-5">
  <div class="col-md-12">
    <%
    for(int i=0; i<list.size(); i++){
      Article article = list.get(i);
    %>
      <div class="post-entry-horzontal">
        <a style="width: -webkit-fill-available;">
        
          <%-- <div class="image element-animate" data-animate-effect="fadeIn" style="background-image: url(/images/img_10.jpg);"></div> --%>
          <span class="text">
            <div class="post-meta">
              <span class="category"><%=article.getWriter()%></span>
              <span class="mr-2"><%=article.getRegdate() %></span> &bullet;
              <%-- <span class="ml-2"><span class="fa fa-comments"></span> 3</span> --%>
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
<%-- 포스트 리스트 끝 --%>
<%-- 페이징 시작 --%>
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
<div class="pagination">
  <!-- <a href="#">&laquo;</a> -->
  <%
  for(int i=startPage; i<=endPage; i++){
    if(i == Integer.parseInt(index)){
  %>
      <a class="active"><%=i %></a>
  <%          
    }else{
  %>
       <a href="/category.jsp?page=<%=i%>&board=<%=board%>"><%=i %></a>
  <%          
    }
  }
  %>
  <!-- <a href="#">&raquo;</a> -->
</div>
<!-- 페이징 끝 -->