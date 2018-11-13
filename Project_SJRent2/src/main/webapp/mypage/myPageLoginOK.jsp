<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String loginId = (String)request.getAttribute("loginId");
%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/commoncss.jsp" />
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body class="tg-home tg-homevone">

<!--************************************
      Nav 시작
*************************************-->
   <jsp:include page="../include/nav.jsp"/>
<!--************************************
      Nav 종료
*************************************-->

<!--************************************
      Wrapper 시작
*************************************-->
   <div id="tg-wrapper" class="tg-wrapper tg-haslayout">

<!--************************************
      Header 시작
*************************************-->
   <jsp:include page="../include/header.jsp"/>
<!--************************************
      Header 종료
*************************************-->
   
<!--************************************
      Main 시작
*************************************-->
<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout tg-bglight">
   <div class="container">
      <div class="row">
           <div class="tg-homebannerslider" class="tg-homebannerslider tg-haslayout">
              <div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
                    <div class="container"> 
		                  <div class="tg-tabcontent tab-content" style="padding: 0px 350px ; ">
		                     <div role="tabpanel" class="tab-pane active fade in" id="home" >
		                        <!--************************************
		                                    Title 시작
		                           *************************************-->
		                        <div style="text-align: center; "><h2>MyPage</h2></div>
		                        <!--************************************
		                                    Title 종료
		                           *************************************-->   
		                     </div>
		                  </div>

							<!--************************************
                                    Content 시작 
                              *************************************-->
              <div>
                <p style="text-align: center;">
                  <%=loginId%>님 환영합니다.<br>
                </p>
              </div>

              <div
                style="background-color: white; border: thick; width: 25%; font-size: 15pt; margin-left: 38%; margin-bottom: 20%; text-align: center; float: left;">
                첫화면입니다.<br>
                원하는 메뉴를 선택해주세요.</div>


              <!--************************************
                                 Content 종료
                           *************************************-->
						
						<!--************************************
                                   menuBar 시작 
                              *************************************-->
							<div><jsp:include page="menuBar.jsp"></jsp:include></div>
							<!--************************************
                                   menuBar 시작 
                              *************************************-->

<!-- 개인정보 첫화면에 뿌리는 데이터 -->
              <div role="tabpanel" class="tab-pane active fade in"
                id="home" style="width: 50%; margin-left: 350px">
                <div class="form-group">
                  <h4>
                    아이디<sup>*</sup>
                  </h4>
                  <input type="text" name="id" class="form-control"
                    placeholder="${user.id }" maxlength="10"
                    style="text-transform: none;" disabled>
                </div>

                <div class="form-group">
                  <h4>
                    이름<sup>*</sup>
                  </h4>
                  <input type="text" name="name" class="form-control"
                    placeholder="${user.name }" maxlength="10"
                    style="text-transform: none;" disabled>
                </div>

                <div class="form-group">
                  <label>이메일 <sup>*</sup></label> <input type="text"
                    name="email" id="email" class="form-control"
                    placeholder="${user.email }" maxlength="30"
                    style="text-transform: lowercase;" disabled>
                </div>

                <div class="form-group">
                  <label>포인트 <sup>*</sup></label> <input type="text"
                    name="point" id="point" class="form-control"
                    placeholder="${user.point }" maxlength="5"
                    style="text-transform: lowercase;" disabled>
                </div>

                <div class="form-group">
                  <label>핸드폰번호 <sup>*</sup></label> <input type="text"
                    name="cellphone" class="form-control"
                    placeholder="${user.cellphone }" maxlength="13"
                    style="text-transform: lowercase;" disabled>
                </div>
              </div>




            </div> 
                 </div>
            </div> 
      </div>
   </div>
</main>
<!--************************************
      Main 종료
*************************************-->

<!--************************************
         Wrapper 종료
*************************************-->
</div> 
    <jsp:include page="../common/commonjs.jsp" />
</body>
</html>