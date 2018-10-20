<%@page import="kr.or.kosta.blog.board.domain.Article"%>
<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<% 
request.setCharacterEncoding("utf-8");
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao articleDao = factory.getArticleDao();
String articleId = request.getParameter("article");
Article article = articleDao.read(articleId);
request.setAttribute("article", article);
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

    <section class="site-section py-lg">
      <div class="container">
        <%-- 메인, 사이드 시작 --%>
        <div class="row blog-entries">
          <%-- 메인 시작 --%>
          <div class="col-md-12 col-lg-8 main-content">
            <h1 class="mb-4"><%= article.getSubject() %></h1>
            <div class="post-meta">
                        <span class="category"><%= article.getWriter() %></span>
                        <span class="mr-2">&bullet; <%= article.getIp() %></span> &bullet;
                        <span class="mr-2"><%= article.getRegdate() %></span> 
                        <span class="ml-2"><i class="fas fa-eye"></i> &nbsp;<%= article.getHitcount()%></span>
            </div>
            <div class="post-content-body">
	            <div class="row mb-5">
	              <div class="col-md-12 mb-4 element-animate">
	                <img src="/images/img_7.jpg" alt="Image placeholder" class="img-fluid">
	              </div>
	              <div class="col-md-6 mb-4 element-animate">
	                <img src="/images/img_9.jpg" alt="Image placeholder" class="img-fluid">
	              </div>
	              <div class="col-md-6 mb-4 element-animate">
	                <img src="/images/img_11.jpg" alt="Image placeholder" class="img-fluid">
	              </div>
	            </div>
            <p><%= article.getContent()%></p>
            </div>

            
            <div class="pt-5">
              <button class="btn btn-primary btn-sm" onclick="location.href='/category.jsp?board=<%=article.getBoardId()%>&page=1'">글목록</button>
              <button class="btn btn-primary btn-sm" onclick="location.href='/category.jsp?board=<%=article.getBoardId()%>&page=1'">덧글</button>
              <button class="btn btn-primary btn-sm" onclick="location.href='/editAticle.jsp?type=2&articleId=<%=article.getArticleId()%>'">수정</button>
              <button class="btn btn-danger btn-sm" onclick="location.href='/editAticle.jsp?type=2&articleId=<%=article.getArticleId()%>'">삭제</button>
            </div>

			<%-- 코멘트 시작 --%>
            <%-- 코멘트 끝 --%>
            
          </div>
          <%-- 메인 끝 --%>
          <%--사이드 시작--%>
          <jsp:include page="/include/side.jsp"></jsp:include>
          <%--사이드 종료--%>

        </div>
        <%-- 메인, 사이드 종료 --%>
      </div>
    </section>
    
    <!-- END section -->
  
    <%--FOOTER 시작--%>
    <jsp:include page="/include/footer.jsp"></jsp:include>
    <%--FOOTER 종료--%>
    
    <%-- LOADER 시작--%>
    <jsp:include page="/include/loader.jsp"></jsp:include>
    <%-- LOADER 종료--%>
  </body>
</html>