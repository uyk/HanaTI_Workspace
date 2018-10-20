<%@ page contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
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
        <!-- 카테고리 제목 -->
        <div class="row mb-4">
          <div class="col-md-6">
            <h2 class="mb-4">Category: <%=request.getParameter("board") %></h2>
          </div>
        </div>
        <!-- 메인 and 사이드 div 시작 -->
        <div class="row blog-entries">
          <!-- 메인 컨텐츠 시작 -->
          <div class="col-md-12 col-lg-8 main-content">
            <%-- 글 목록 시작 --%>
            <jsp:include page="/action/categoryAction.jsp">
              <jsp:param name="board" value='<%=request.getParameter("board") %>'></jsp:param>
              <jsp:param name="page" value='<%=request.getParameter("page") %>'></jsp:param>
            </jsp:include>
            <%-- 글 목록 종료 --%>


            <!-- 페이징 row 시작 -->
            <!-- 
            <div class="row">
              <div class="col-md-12 text-center">
                <nav aria-label="Page navigation" class="text-center">
                  <ul class="pagination">
                    <li class="page-item  active"><a class="page-link" href="#">Prev</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                  </ul>
                </nav>
              </div>
            </div>
             -->
            <!-- 페이징 row 끝 -->
          </div>
          <!-- END main-content -->
          
          <%--사이드 시작--%>
          <jsp:include page="/include/side.jsp"></jsp:include>
          <%--사이드 종료--%>

        </div>
        <!-- 메인 and 사이드 div 종료 -->
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