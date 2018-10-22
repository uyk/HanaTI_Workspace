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
int boardId = Integer.parseInt(request.getParameter("board"));
String index = request.getParameter("page");
// 페이지 인덱스 처리
if(index == null || index.equals("") || index.equals("null")){
	index = "1";
}
int indexI = Integer.parseInt(index);
//검색 요청일 경우 파라메터 수신. 없을경우 null
String searchType = request.getParameter("searchType");
String searchValue = request.getParameter("searchValue");
if(searchType == null || searchType.equals("")){
  searchType = null;
  searchValue = null;
}
// 페이징 연산
// 페이지당 보여지는 목록수 설정
int listSize = 10;
//페이징 처리에 필요한 검색 개수 DB조회
int rowCount = dao.countBySearch(searchType, searchValue, boardId);
//페이지 개수
int pageCount = (int)Math.ceil((double)rowCount / listSize);
//페이지 목록의 시작페이지번호와 마지막페이지번호 계산
//목록별 번호
int pageSize = 5;
int listNo = (indexI - 1) / pageSize; // 목록 식별번호
//(1~5): 0, (6~10): 1, (11~15): 2, .....
int startPage = (listNo * pageSize) + 1;
int endPage = (listNo * pageSize) + pageSize;
if (endPage > pageCount){
endPage = pageCount;
}
List<Article> list = dao.listByPage(boardId,indexI,listSize);
%>

<%-- 포스트 리스트 시작 --%>
<div class="row mb-5 ">
  <div class="col-md-12">
    <%
    for(int i=0; i<list.size(); i++){
      Article article = list.get(i);
    %>
      <div class="post-entry-horzontal">
        <a style="width: -webkit-fill-available;" href="/blog-single.jsp?article=<%=article.getArticleId()%>&page=<%=index%>">
        
          <%-- <div class="image element-animate" data-animate-effect="fadeIn" style="background-image: url(/images/img_10.jpg);"></div> --%>
          <span class="article_at_category" style="padding: 15px 15px 15px <%=35 + article.getLevelNo()*40%>px;">
            <div class="row">
            <%
            if(article.getLevelNo() != 0) {
            %>
              <div>
                <label style="visibility: hidden; display: block;">.</label>
                <i class="fas fa-angle-double-right"></i>
              </div>
            <% 
            }
            %>
              <div>
                <div class="post-meta info_at_category">
                  <span class="category"><%=article.getArticleId() %></span>
                  <span class="mr-2"><%=article.getWriter() %></span> &bullet;
                  <span class="mr-2"><%= article.getIp() %></span> &bullet;
                  <span class="mr-2"><%= article.getRegdate() %></span> &bullet;
                  <span class="ml-2"><i class="fas fa-eye"></i> &nbsp;<%= article.getHitcount()%></span>
                </div>
                <h5><%=article.getSubject() %></h5>
              </div>
            </div>
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
      	<%
      	if(indexI == 1) {
      		%>
      		<li class="page-item"><a class="page-link" style="pointer-events: none;cursor: default;">Prev</a></li>
      		<%
      	}
      	else {
      		%>
      		<li class="page-item"><a class="page-link" href="/categoryAction.jsp?page=<%=indexI - 1%>&board=<%=boardId%>">Prev</a></li>
      		<%
      	}
	  	for(int i=startPage; i<=endPage; i++){
	    	if(i == indexI){
	  	%>
	      		<li class="page-item active"><a class="page-link" href="#"><%=i %></a></li>
	  	<%          
	    	}else{
	  	%>
	    	   <li class="page-item"><a class="page-link" href="/category.jsp?page=<%=i%>&board=<%=boardId%>"><%=i %></a></li>
	  	<%          
	   	 	}
	 	 }
      	if(indexI == pageCount) {
      		%>
      		<li class="page-item"><a class="page-link" style="pointer-events: none;cursor: default;">Next</a></li>
      		<%
      	}
      	else {
      		%>
      		<li class="page-item"><a class="page-link" href="/category.jsp?page=<%=indexI + 1%>&board=<%=boardId%>">Next</a></li>
      		<%
      	}
      	%>
      </ul>
    </nav>
  </div>
</div>
<%-- 페이징 끝 --%>