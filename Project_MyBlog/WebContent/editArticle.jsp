<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@page import="kr.or.kosta.blog.board.domain.Article"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%-- request에서 articleID를 받아서 article객체를 읽어온 후 
수정되거나 생성된 정보와 객체 각 프로퍼티 정보를 hidden으로 editArticleAction으로 보냄 --%>
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
String recievedId = request.getParameter("articleId");
int type = Integer.parseInt(request.getParameter("type"));
String description = null; 
Article article = null;

if(type == 1 || type == 2) {
	article = new Article();
	article.setContent("");
	article.setWriter((String)pageContext.getAttribute("id"));
	article.setIp(request.getRemoteAddr());
}

switch(type) {
// 신규글
case 1:
	article.setSubject("");
	article.setBoardId(Integer.parseInt(request.getParameter("boardId")));
	description = "신규 글 작성";
	break;
// 덧글
case 2:
    Article parentArticle = articleDao.read(recievedId);
    article.setArticleId(parentArticle.getArticleId());         // increaseOrder를 위해 부모 게시글의 ID를 우선 ID로 가진다.
	article.setSubject("re: " + parentArticle.getSubject());
    article.setBoardId(parentArticle.getBoardId());
    article.setGroupNo(parentArticle.getGroupNo());
    article.setLevelNo(parentArticle.getLevelNo() + 1);
	description = "덧글 작성";
	break;
// 글 수정
case 3:
	article = articleDao.read(recievedId);
	description = "게시글 수정";
	break;
// 글 삭제
case 4:
	article = articleDao.read(recievedId);
  // 자식 게시글이 있는지 확인
  
	articleDao.delete(recievedId);
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
                <div class="col-md-12 form-group">
                  <label for="subject">글 제목</label>
                  <input type="text" id="subject" class="form-control" name="subject" value="<%=article.getSubject() %>" required>
                </div>
              </div>
              <!-- 작성자, 비밀번호 -->
              <div class="row">
                <div class="col-md-6 form-group">
                  <label for="writer">작성자</label>
                  <input type="text" class="form-control" value="<%=article.getWriter() %>" disabled>
                </div>
                <div class="col-md-6 form-group">
                  <label for="passwd">비밀번호</label>
                  <input type="password" id="passwd" class="form-control " name="passwd" required>
                </div>
              </div>
              <!-- 내용 입력 -->
              <div class="row">
                <div class="col-md-12 form-group article-content">
                  <textarea class="form-control mb-3" id="name" name="content" required><%=article.getContent() %></textarea>
                </div>
              </div>
              <!-- 버튼 -->
              <div class="row" >
                <div class="col-md-2 mb-4 form-group" style="margin: 0 auto;">
                  <input type="submit" value="등록" class="btn btn-primary">
                </div>
              </div>
              <input type="hidden" id="type" name="type" value="<%=type%>">
              <input type="hidden" id="articleId" name="articleId" value="<%=article.getArticleId()%>">
              <input type="hidden" id="writer" name="writer" value="<%=article.getWriter()%>">
              <input type="hidden" id="regDate" name="regDate" value="<%=article.getRegdate()%>">
              <input type="hidden" id="ip" name="ip" value="<%=article.getIp()%>">
              <input type="hidden" id="boardId" name="boardId" value="<%=article.getBoardId()%>">
              <input type="hidden" id="groupNo" name="groupNo" value="<%=article.getGroupNo()%>">
              <input type="hidden" id="levelNo" name="levelNo" value="<%=article.getLevelNo()%>">
              <input type="hidden" id="orderNo" name="orderNo" value="<%=article.getOrderNo()%>">
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