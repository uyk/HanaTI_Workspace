<%@page import="kr.or.kosta.blog.board.domain.Board"%>
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
Board board = boardDao.read(request.getParameter("board"));
%>
<!DOCTYPE html>
<html>
  <head>
    <%--헤드 시작--%>
    <jsp:include page="/include/head.jsp"></jsp:include>
    <%--헤드 종료--%>
    
		<script>
		function changeType(e) {
			var event = e || window.event;
			var source = event.srcElement;
			window.s = source;
			
			document.getElementById("searchType").innerText = source.innerText;
		}
		function search() {
			var searchType = document.getElementById("searchType").innerText;
			var searchValue = document.getElementById("searchText").value;
			if(searchValue == "") {
				document.getElementById("alert").innerText = "텍스트를 입력해주세요";
				document.getElementById("alert").style.visibility = "visible";
				return;
			}
			if(searchType == "작성자") {
				searchType = "writer";
			}
			else if(searchType == "글제목") {
				searchType = "subject";
			}
			else if(searchType == "글내용") {
				searchType = "content";
			}
			else {
				document.getElementById("alert").innerText = "타입을 선택해주세요";
				document.getElementById("alert").style.visibility = "visible";
				return;
			}
			document.location.href='/category.jsp?board='+ <%= request.getParameter("board") %> +'&searchType='+ searchType +'&searchValue=' + searchValue; 
		}
		</script>
  </head>
  <body>
    <%--탑 메뉴 시작--%>
    <jsp:include page="/include/header.jsp"></jsp:include>
    <%--탑 메뉴 종료--%>
      
    <section class="site-section">
      <div class="container">
      
      	<%--카테고리 제목--%>
        <div class="row mb-1">
          <div class="col-md-9">
            <h2 class="mb-4">Category: <%=board.getTitle() %></h2>
            <h5 class="mb-4"><%=board.getDescription() %></h5>
            
          </div>
        </div>
      	<%-- 메인, 사이드 div 시작 --%>
        <div class="row blog-entries">
      	  <%-- 메인 컨텐츠 시작 --%>
          <div class="col-md-12 col-lg-8 main-content">
            <%-- 검색 행 시작 --%>
            <div class="row mb-2">
	            <div class="input-group mb-3 col-md-10">
							  <div class="input-group-prepend">
							    <button class="btn btn-outline-secondary dropdown-toggle" id="searchType" name="searchType" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" value="button">Search Type</button>
							    <div class="dropdown-menu">
							      <button class="dropdown-item" onclick="changeType()">작성자</button>
							      <button class="dropdown-item" onclick="changeType()">글제목</button>
							      <button class="dropdown-item" onclick="changeType()">글내용</button>
						   		</div>
						  	</div>
						  	<input type="text" class="form-control" name="searchText" id="searchText" aria-label="Text input with dropdown button">
						  	<button class="btn btn-outline-primary" type="submit" name="searchButton" id="searchButton" onclick="search()">Search</button>
					    </div>
					    <div class="col-md-2">
		            <%
		            if(pageContext.getAttribute("id") == null) {
		           	%>
		            <button class="btn btn--primary new-button" disabled><i class="fas fa-edit mr-2"></i></i>New</button>
		           	<%
		            } else {
		           	%>
		           	<a class="btn btn-outline-primary new-button" href="/editArticle.jsp?type=1&boardId=<%=board.getBoardId()%>"><i class="fas fa-edit mr-2"></i>New</a>
		           	<%
		            }
            		%>
					    </div>
				    </div>
				    <%-- 검색 행 종료 --%>
				    <%-- 알림 표시 --%>
				    <div class="row">
	            <div class="alert alert-danger col-md-12 category-alert" id="alert" role="alert" style="visibility: hidden;">

              </div>
             </div>
            <%-- 글 목록 시작 --%>
            <jsp:include page="/action/categoryAction.jsp">
              <jsp:param name="board" value='<%=request.getParameter("board") %>'></jsp:param>
              <jsp:param name="page" value='<%=request.getParameter("page") %>'></jsp:param>
              <jsp:param name="searchType" value='<%=request.getParameter("searchType") %>'></jsp:param>
              <jsp:param name="searchValue" value='<%=request.getParameter("searchValue") %>'></jsp:param>
            </jsp:include>
            <%-- 글 목록 종료 --%>
          </div>
          <%-- 메인 컨텐츠 종료 --%>
          
          <%--사이드 시작--%>
          <jsp:include page="/include/side.jsp"></jsp:include>
          <%--사이드 종료--%>

        </div>
      	<%-- 메인 and 사이드 div 종료 --%>
      </div>
    </section>
    
    <%--FOOTER 시작--%>
    <jsp:include page="/include/footer.jsp"></jsp:include>
    <%--FOOTER 종료--%>
    
    <%-- LOADER 시작--%>
    <jsp:include page="/include/loader.jsp"></jsp:include>
    <%-- LOADER 종료--%>
  </body>
</html>