<%@page import="kr.or.kosta.blog.board.domain.Article"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao articleDao = factory.getArticleDao();
int populars = 3;
List<Article> popularAs = articleDao.listPopular(populars);
int recents = 3;
List<Article> relentAs = articleDao.listRecent(recents);
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

    <section class="site-section pt-5">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
						<%-- 조회수 높은 게시글 --%>
            <div class="owl-carousel owl-theme home-slider">
              <%
			        for(int i=0; i< popularAs.size(); i++){
			        %>
			        <div>
			          <a href="/blog-single.jsp?article=<%=popularAs.get(i).getArticleId()%>&page=1" class="a-block d-flex align-items-center height-lg" style="background-image: url('images/img_<%=3-i %>.jpg');" >
			            <div class="text half-to-full">
				            <div class="post-meta">				            
                      <span class="category"><%=popularAs.get(i).getWriter()%></span>
                      <span class="mr-2"><%=popularAs.get(i).getRegdate()%></span> &bullet;
                      <span class="ml-2"><span class="fas fa-eye"></span>&nbsp;<%=popularAs.get(i).getHitcount() %></span>
                    </div>
                    <h3><%=popularAs.get(i).getSubject()%></h3>
                    <p><% 
                    	  String content = popularAs.get(i).getContent(); 
                    		if(content.length() > 200) {
                    			content = content.substring(0, 200);
                    		}
                    	  %> 
                    		<%=content %></p>
		            	</div>
			          </a>
			        </div>
			        <% 
			        }
			        %>              
            </div>
            <%-- 조회수 높은 게시글 종료 --%>
          </div>
        </div>
        
        <div class="row">
        	<%-- 최신 게시글 --%>
        	<%
          for(int i=0; i< relentAs.size(); i++){
          %>
          <div class="col-md-6 col-lg-4">
            <a href="/blog-single.jsp?article=<%=relentAs.get(i).getArticleId()%>&page=1" class="a-block d-flex align-items-center height-md" style="background-image: url('images/img_<%= 1+3*i %>.jpg'); ">
              <div class="text">
	              <div class="post-meta">
	                <span class="category"><%=relentAs.get(i).getWriter()%></span>
	                <span class="mr-2"><%=relentAs.get(i).getRegdate()%></span> &bullet;
	                <span class="ml-2"><span class="fas fa-eye"></span>&nbsp;<%=relentAs.get(i).getHitcount() %></span>
	              </div>
              	<h3><%=relentAs.get(i).getSubject()%></h3>
              </div>
            </a>
          </div>
          <% 
          }
          %>
        </div>
      </div>
    </section>
    <!-- END section -->
    <%-- FOOTER 시작--%>
    <jsp:include page="/include/footer.jsp"></jsp:include>
    <%-- FOOTER 종료--%>

    <%-- LOADER 시작--%>
    <jsp:include page="/include/loader.jsp"></jsp:include>
    <%-- LOADER 종료--%>
  </body>
</html>