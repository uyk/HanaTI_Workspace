<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@page import="kr.or.kosta.blog.board.domain.Article"%>
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
ArticleDao articleDao = factory.getArticleDao();
String articleId = request.getParameter("articleId");
int type = Integer.parseInt(request.getParameter("type"));
String description = null;
Article article = null;
System.out.println(articleId);
if(articleId != null) {
	article = articleDao.read(articleId);
}
else {
	article = new Article();
	article.setSubject("");
	article.setWriter((String)pageContext.getAttribute("id"));
}
switch(type) {
// 신규글
case 1:
	description = "신규 글 작성";
	break;
// 덧글
case 2:
	description = "덧글 작성";
	break;
// 글 수정
case 3:
	description = "게시글 수정";
	break;
// 글 삭제
case 4:
	articleDao.delete(articleId);
	response.sendRedirect("/category.jsp?board=" + article.getBoardId());
	break;
}
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
        <div class="row mb-4">
          <div class="col-md-6">
            <h1><%=description %></h1>
          </div>
        </div>
        <div class="row blog-entries">
          <div class="col-md-12 col-lg-8 main-content">
            
            <form name="editForm" action="/action/editArticleAction.jsp" method="post">
              <!-- 글 제목 입력 -->
              <div class="row">
                <div class="col-md-4 form-group">
                  <label for="subject">글 제목</label>
                  <input type="text" id="subject" class="form-control" name="subject" value="<%=article.getSubject() %>" required>
                </div>
              </div>
              <!-- 작성자, 비밀번호 -->
              <div class="row">
                <div class="col-md-4 form-group">
                  <label for="writer">작성자</label>
                  <input type="text" id="writer" class="form-control " name="writer" value="<%=article.getWriter() %>" disabled>
                </div>
                <div class="col-md-4 form-group">
                  <label for="passwd">비밀번호</label>
                  <input type="password" id="passwd" class="form-control " name="passwd">
                </div>
              </div>
              <!-- 내용 입력 -->
              <div class="row">
                <div class="col-md-12 form-group article-content">
                  <textarea class="form-control mb-3" id="name" name="content" ></textarea>
                </div>
              </div>
              <!-- 버튼 -->
              <div class="row" >
                <div class="col-md-2 mb-4 form-group" style="margin: 0 auto;">
                  <input type="submit" value="등록" class="btn btn-primary">
                </div>
              </div>
            </form>
          </div>
          <%-- END main-content --%>
          
          <%--사이드 시작--%>
          <jsp:include page="/include/side.jsp"></jsp:include>
          <%--사이드 종료--%>

        </div>
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