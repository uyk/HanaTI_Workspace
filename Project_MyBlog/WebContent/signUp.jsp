<%--
회원가입 화면 페이지.
페이지 유효성 검사를 위한 /js/formValidation.js 파일을 추가한다.
키 입력시마다 유효성을 검사하여 라벨 색을 변경, 패스워드 일치 아이콘 색을 변경.
버튼 입력시 유효성을 검사 후 signUpAction.jsp로 이동한다.
 --%>
<%@page import="kr.or.kosta.blog.user.dao.UserDao"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
UserDao dao = factory.getUserDao();
boolean idCheck = false;
boolean emailCheck = false;
%>
<!DOCTYPE html>
<html>
  <head>
    <%--헤드 시작--%>
    <jsp:include page="/include/head.jsp"></jsp:include>
    <%--헤드 종료--%>
    <script type="text/javascript" src="/js/formValidation.js"></script>

  </head>
  <body>
    <%--탑 메뉴 시작--%>
    <jsp:include page="/include/header.jsp"></jsp:include>
    <%--탑 메뉴 종료--%>

    <section class="site-section">
      <div class="container">
        <div class="row mb-4">
          <div class="col-md-6">
            <h1>Welcome to Blog!</h1>
          </div>
        </div>
        <div class="row blog-entries">
          <div class="col-md-12 col-lg-8 main-content">
          <div class="row">
            <div class="alert alert-danger col-md-12 category-alert" id="alert" role="alert" style="visibility: hidden;">

            </div>
          </div>
            <form name="signUpForm" action="/action/signUpAction.jsp" method="post">
              <!-- 아이디 입력 -->
              <div class="row">
                <div class="col-md-4 form-group">
                  <label for="id">Id</label>
                  <input type="text" id="id" class="form-control" name="id" pattern="[a-zA-Z0-9]{1,10}" required>
                </div>
                <div class="col-md-4 form-group">
                  <!-- 공간을 위한 더미 라벨 -->
                  <label style="visibility:hidden">------------------</label>
                  <input type="button" value="중복확인" class="btn btn-primary" onclick="validateId()">
                </div>
                <div class="col-md-4 form-group">
                  <!-- 공간을 위한 더미 라벨 -->
                  <label style="visibility:hidden">-------------------</label>
                  <label for="id" id="idL" class="validL">10자 이하 영어 또는 숫자만 입력하세요.</label>
                </div>
              </div>
              <!-- 비밀번호 입력 -->
              <div class="row">
                <div class="col-md-4 form-group">
                  <label for="passwd">Password</label>
                  <input type="password" id="passwd" class="form-control " name="passwd" pattern="[a-zA-Z0-9!@#$%^&*]{1,10}" required>
                </div>
                <div class="col-md-4 form-group">
                  <label for="cpw">Confirm Password</label>
                  <span id="cpwIcon">
                    <i class="far fa-check-circle"></i>
                  </span>
                  <input type="password" id="cpw" class="form-control " name="cpw">
                </div>
                <div class="col-md-4 form-group">
                  <!-- 공간을 위한 더미 라벨 -->
                  <label style="visibility:hidden">-------------------</label>
                  <label for="passwd" id="passwdL" class="validL">10자 이하 영어, 숫자, 특수문자만 입력하세요.</label>
                </div>
              </div>
              <!-- 이름 입력 -->
              <div class="row"> 
                <div class="col-md-4 form-group">
                  <label for="name">Name</label>
                  <input type="text" id="name" class="form-control " name="name" pattern="[가-힣a-zA-Z]{1,20}" required>
                </div>
                <!-- 공간을 위한 더미 라벨 -->
                <div class="col-md-4 form-group">
                  <label style="visibility:hidden">-------------------</label>
                  <label style="visibility:hidden">-------------------</label>
                </div>
                <div class="col-md-4 form-group">
                  <label style="visibility:hidden">-------------------</label>
                  <label for="name" id="nameL" class="validL">20자 이하 영어 및 한글만 입력하세요.</label>
                </div>
              </div>
              <!-- 이메일 입력 -->
              <div class="row">
                <div class="col-md-6 form-group">
                  <label for="email">Email</label>
                  <input type="email" id="email" class="form-control " name="email" required>
                </div>
                <div class="col-md-4 form-group">
                  <!-- 공간을 위한 더미 라벨 -->
                  <label style="visibility:hidden">-------------------</label>
                  <input type="button" value="중복확인" class="btn btn-primary" onclick="validateEmail()">
                </div>
              </div>
              <!-- 버튼 -->
              <div class="row" >
                <div class="col-md-2 form-group">
                  <input type="button" value="Sign Up" class="btn btn-primary" onclick="mySubmit()">
                </div>
                <div class="col-md-2 form-group">
                  <input type="reset" value="Cancel" class="btn btn-primary">
                </div>
              </div>
            </form>
          </div>
          <%-- 알림 표시 --%>
 
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