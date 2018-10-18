<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="user" class="kr.or.kosta.blog.user.domain.User" scope="request"></jsp:useBean>
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
                  <input type="button" value="HOME" class="btn btn-primary" onclick="location.href='/index.jsp'">
                </div>
              </div>
            </div>
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