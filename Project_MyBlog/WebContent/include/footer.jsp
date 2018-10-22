<%@page import="kr.or.kosta.blog.board.domain.Article"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.board.dao.ArticleDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao articleDao = factory.getArticleDao();
int recents = 3;
List<Article> relentAs = articleDao.listRecent(recents);

%>
<footer class="site-footer">
  <div class="container">
    <div class="row mb-5">
      <div class="col-md-4">
        <h3>Paragraph</h3>
        <p>
          <img src="/images/uyk.jpg" alt="Image placeholder" class="img-fluid">
        </p>
        <p> Hello freinds. This is UYK's Blog for making monument about travles <i class="fas fa-plane"></i>. Welcome to my Blog!</p>
      </div>
      <div class="col-md-6 ml-auto">
        <div class="row">
          <div class="col-md-7">
            <h3>Latest Post</h3>
            <div class="post-entry-sidebar">
              <ul>
              <%-- 각 포스트 목록 시작 --%>
                <%
                for(int i=0; i< relentAs.size(); i++){
                %>
                <li>
                  <a href="/blog-single.jsp?article=<%=relentAs.get(i).getArticleId()%>&page=1">
                    <img src="/images/img_<%= 3+i %>.jpg" alt="Image placeholder" class="mr-4">
                    <div class="text">
                      <h4><%=relentAs.get(i).getSubject()%></h4>
                      <div class="post-meta">
                        <span class="mr-2"><%=relentAs.get(i).getRegdate()%></span> <br/>&bullet;
                        <span class="ml-2"><span class="fas fa-eye"></span>&nbsp;<%=relentAs.get(i).getHitcount() %></span>
                      </div>
                    </div>
                  </a>
                </li>
                <% 
                }
                %>
              </ul>
            </div>
          </div>
          <div class="col-md-1"></div>
          
          <div class="col-md-4">

            <div class="mb-5">
              <h3>Quick Links</h3>
              <ul class="list-unstyled">
                <li><a href="/index.jsp">Home</a></li>
                <li><a href="/about.jsp">About</a></li>
                <li><a href="/guestBook.jsp">Guest Book</a></li>
                <li><a href="/category.jsp/board=1">Notice</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        This Blog is designed by UYK<br>
        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
      </div>
    </div>
  </div>
</footer>
<!-- END footer -->