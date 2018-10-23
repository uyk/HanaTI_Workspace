<%--
로그인 화면 페이지
 --%>
<%@ page contentType="text/html; charset=utf-8" %>
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
        <!-- 제목 -->
        <div class="row mb-4">
          <div class="col-md-6">
            <h1>Sign in to Blog</h1>
          </div>
        </div>
        <div class="row blog-entries">
          <!-- 정보 입력 div 시작 -->
          <div class="col-md-12 col-lg-8 main-content">
            <form class="centerForm" action="/action/signInAction.jsp" method="post">
              <!-- 아이디 입력 -->
              <div class="row">
                <div class="col-md-4 form-group">
                  <label for="name">Id</label>
                  <input type="text" id="id" name="id" class="form-control ">
                </div>
              </div>
              
              <!-- 패스워드 입력 -->
              <div class="row">
                <div class="col-md-4 form-group">
                  <label for="name">Password</label>
                  <input type="password" id="pw" name="pw" class="form-control ">
                </div>
              </div>
              <!-- 버튼 -->
              <div class="row">
                <div class="col-md-2 form-group">
                  <input type="submit" value="Sign In" class="btn btn-primary">
                </div>
                <div class="col-md-2 form-group">
                  <input type="button" value="Sign Up" class="btn btn-primary"  onclick="location.href='signUp.jsp'">
                </div>
              </div>
            </form>
          </div>
          <!-- 정보 입력 div 끝 -->
          <!-- END main-content -->
          
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