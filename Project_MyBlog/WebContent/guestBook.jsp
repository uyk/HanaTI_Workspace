<%@ page contentType="text/html; charset=utf-8" %>
<%
// 쿠키를 검사하여 로그인상태면 id를 페이지 컨텍스트에 저장
pageContext.setAttribute("id", null);
Cookie[] cookies = request.getCookies();
if(cookies != null) {
  for (Cookie cookie : cookies) {
    if(cookie.getName().equals("id")) {
      pageContext.setAttribute("id", cookie.getValue()); // 현재 페이지에 정보 저장
    }
  }
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
        <!-- 카테고리 제목 -->
        <div class="row mb-4">
          <div class="col-md-6">
            <h2 class="mb-4">GUEST BOOK</h2>
          </div>
        </div>
        <!-- 메인 and 사이드 div 시작 -->
        <div class="row blog-entries">
          <!-- 메인 컨텐츠 시작 -->
          <div class="col-md-12 col-lg-8 main-content">
            <div class="bio text-center">
              <img src="/images/person_2.jpg" alt="Image Placeholder" class="img-fluid">
              <div class="bio-body">
                <form action="/action/guestBookCreateAction.jsp">
                <%
                if(pageContext.getAttribute("id") == null) {
                %>
              	  <textarea class="form-control mb-3" name="contents" readonly placeholder="로그인 후에 방명록을 작성할 수 있습니다."></textarea>
                  <input class="btn btn-primary btn-sm" disabled type="submit" value="등록">
                <%
                }
                else {
                %> 
                  <textarea class="form-control mb-3" name="contents" placeholder="<%=pageContext.getAttribute("id") %>님 방명록을 입력하세요"></textarea>
                  <input class="btn btn-primary btn-sm" type="submit" value="등록">
                  <input type="text" name="userId" value="<%=pageContext.getAttribute("id") %>" hidden="true">
                <%
                  String message = request.getParameter("message");
                  if(message != null && message.equals("sucess")) {
                  %>
                    <div class="alert alert-success" role="alert">
                      방명록을 등록했습니다!
                    </div>
                  <%
                  }
                  else if(message != null && request.getParameter("message").equals("fail")){
            	  %>
                    <div class="alert alert-danger" role="alert">
                      내용을 입력해주세요.
                    </div>
                  <%
                  }
                }
                %>
                </form>
               <!-- <p><a href="#" class="btn btn-primary btn-sm">등록</a></p> --> 
              </div>
            </div>
            <%-- 방명록 목록 시작 --%>
            <jsp:include page="/action/guestBookAction.jsp"></jsp:include>
            <%-- 방명록 목록 종료 --%>
            <!-- 페이징 row 시작 -->
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