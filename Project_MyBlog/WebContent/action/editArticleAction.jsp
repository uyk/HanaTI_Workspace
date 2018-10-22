<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.InetAddress" %>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="article" class="kr.or.kosta.blog.board.domain.Article" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="article"></jsp:setProperty>
<%
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao articleDao = factory.getArticleDao();
int type = Integer.parseInt(request.getParameter("type"));
System.out.println("editArticleAction" + article);
switch(type) {
//신규글
case 1:
//덧글
case 2:
	articleDao.create(article);
	break;
//글 수정
case 3:
	articleDao.update(article);
	break;
}
response.sendRedirect("/category.jsp?board="+article.getBoardId());
%>