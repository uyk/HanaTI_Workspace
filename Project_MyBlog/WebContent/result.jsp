<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="user" class="kr.or.kosta.jsp.dao.User" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
  <head>
    <%--헤드 시작--%>
    <jsp:include page="include/head.jsp"></jsp:include>
    <%--헤드 종료--%>
  </head>
  <body>
    <%--탑 메뉴 시작--%>
    <jsp:include page="include/header.jsp"></jsp:include>
    <%--탑 메뉴 종료--%>
    
    <section class="site-section">
      <div class="container">
        
        <div class="row blog-entries">
        
          <div class="col-md-12 col-lg-8 main-content">
            <div class="row">
              <div class="col-md-12">
                <h2 class="mb-4">Thanks For Signing Up!</h2>
                <p>회원등록이 완료되었습니다.</p>
                <p>가입하신 회원 정보는 아래와 같습니다.</p>
                <%--
                <p>아이디 : <jsp:getProperty name="user" property="id"/></p>
                <p>이름 : <jsp:getProperty name="user" property="name"/></p>
                <p>이메일 : <jsp:getProperty name="user" property="email"/></p>
                 --%>
                <p>아이디 : <%= user.getId()%></p>
                <p>이름 : <%= user.getName()%></p>
                <p>이메일 : <%= user.getEmail()%></p>
                <p> HOME 버튼을 클릭하시면 홈페이지로 이동합니다.</p>
                <div class="col-md-2">
                  <input type="button" value="HOME" class="btn btn-primary" onclick="location.href='index.jsp'">
                </div>
              </div>
            </div>
          </div>
          <%-- END main-content --%>
          <%--사이드 시작--%>
          <jsp:include page="include/side.jsp"></jsp:include>
          <%--사이드 종료--%>
          
        </div>
      </div>
    </section>
  
    <%--FOOTER 시작--%>
    <jsp:include page="include/footer.jsp"></jsp:include>
    <%--FOOTER 종료--%>
    
    <%--Loader 시작--%>
    <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#f4b214"/></svg></div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-migrate-3.0.0.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.stellar.min.js"></script>

    
    <script src="js/main.js"></script>
  </body>
</html>