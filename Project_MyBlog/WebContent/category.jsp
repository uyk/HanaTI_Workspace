<%@page import="kr.or.kosta.blog.board.domain.Board"%>
<%@page import="kr.or.kosta.blog.board.dao.BoardDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<% 
request.setCharacterEncoding("utf-8"); 
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
  </head>
  <body>
    <%--탑 메뉴 시작--%>
    <jsp:include page="/include/header.jsp"></jsp:include>
    <%--탑 메뉴 종료--%>
      
    <section class="site-section">
      <div class="container">
      	<%--카테고리 제목--%>
        <div class="row mb-4">
          <div class="col-md-6">
            <h2 class="mb-4">Category: <%=board.getTitle() %></h2>
            <h5 class="mb-4"><%=board.getDescription() %></h5>
          </div>
        </div>
      	<%-- 메인, 사이드 div 시작 --%>
        <div class="row blog-entries">
      	  <%-- 메인 컨텐츠 시작 --%>
          <div class="col-md-12 col-lg-8 main-content">
            <%-- 글 목록 시작 --%>
            <jsp:include page="/action/categoryAction.jsp">
              <jsp:param name="board" value='<%=request.getParameter("board") %>'></jsp:param>
              <jsp:param name="page" value='<%=request.getParameter("page") %>'></jsp:param>
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