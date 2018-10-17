<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <%--헤드 시작--%>
    <jsp:include page="include/head.jsp"></jsp:include>
    <%--헤드 종료--%>
    <script>
      function validateId() {
        location.href="user/signUpAction.jsp?id="+ document.getElementById("id").value;
      }
    </script>
  </head>
  <body>
    <%--탑 메뉴 시작--%>
    <jsp:include page="include/header.jsp"></jsp:include>
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
            
            <form action="user/signUpAction.jsp" method="post">
              <!-- 아이디 입력 -->
              <div class="row">
                <div class="col-md-4 form-group">
                  <label for="id">Id</label>
                  <input type="text" id="id" class="form-control " name="id">
                </div>
                <div class="col-md-4 form-group">
                  <label style="visibility:hidden">5~10자 영어 및 특수문자</label>
                  <input type="button" value="중복확인" class="btn btn-primary" onclick="validateId()">
                </div>
                <div class="col-md-4 form-group">
                  <label style="visibility:hidden">5~10자 영어 및 특수문자</label><label for="id">5~20자 영어</label>
                </div>
              </div>
              <!-- 비밀번호 입력 -->
              <div class="row">
                <div class="col-md-4 form-group">
                  <label for="passwd">Password</label>
                  <input type="text" id="passwd" class="form-control " name="passwd">
                </div>
                <div class="col-md-4 form-group">
                  <label for="cpw">Confirm Password</label>
                  <input type="text" id="cpw" class="form-control " name="cpw">
                </div>
                <div class="col-md-4 form-group">
                  <label style="visibility:hidden">5~10자 영어 및 특수문자</label>
                  <label for="id">5~10자 영어 및 특수문자</label>
                </div>
              </div>
              <!-- 이름 입력 -->
              <div class="row"> 
                <div class="col-md-4 form-group">
                  <label for="name">Name</label>
                  <input type="text" id="name" class="form-control " name="name">
                </div>
                <div class="col-md-4 form-group">
                  <label style="visibility:hidden">5~10자 영어 및 특수문자</label><label for="id">5~10자 영어 및 한글</label>
                </div>
              </div>
              <!-- 이메일 입력 -->
              <div class="row">
                <div class="col-md-6 form-group">
                  <label for="email">Email</label>
                  <input type="text" id="email" class="form-control " name="email">
                </div>
              </div>
              <!-- 버튼 -->
              <div class="row" >
                <div class="col-md-2 form-group">
                  <input type="submit" value="Sign Up" class="btn btn-primary">
                </div>
                <div class="col-md-2 form-group">
                  <input type="reset" value="Cancel" class="btn btn-primary">
                </div>
              </div>
            </form>
          </div>
          
          <!-- END main-content -->
          
          <%--사이드 시작--%>
          <jsp:include page="include/side.jsp"></jsp:include>
          <%--사이드 종료--%>

        </div>
      </div>
    </section>
  
    <%--FOOTER 시작--%>
    <jsp:include page="include/footer.jsp"></jsp:include>
    <%--FOOTER 종료--%>
    
    <!-- loader -->
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