<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/commoncss.jsp" />
   <jsp:include page="../common/commonjs.jsp" />
</head>
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
                  <div class="tg-tabcontent tab-content" style="padding: 0px 350px 0;">
                     <div role="tabpanel" class="tab-pane active fade in" id="home">
                        <!--************************************
                                    Title 시작
                           *************************************-->
                        <div style="text-align: center; margin: 50px 0px"><h2>로그인</h2></div>
                        <!--************************************
                                    Title 종료
                           *************************************-->   
                           <!--************************************
                                    Content 시작 (login 성공하면)
                              *************************************-->      
                              <form class="tg-formtheme tg-formlogin" action="#" method="post">
                                 <fieldset>
                                    <div class="form-group">
                                       <h4>아이디<sup>*</sup></h4>
                                       <input type="text" name="id" class="form-control" placeholder="" maxlength="10" required style="text-transform: none">
                                    </div>
                                    <div class="form-group">
                                       <h4>비밀번호<sup>*</sup></h4>
                                       <input type="password" name="pw" class="form-control" placeholder="" maxlength="10" required style="text-transform: none">
                                    </div>
                                    <div class="form-group">
                                       <div>
                                          <input type="checkbox" style="display: inline;">
                                          <h6 style="display: inline;">아이디저장</h6>
                                       </div>
                                    </div>
                                    <input id= "loginB" type="submit" class="tg-btn tg-btn-lg" style="font-size: 14pt"  value="로그인">
                                 </fieldset>
                              </form>
                           <!--************************************
                                 Content 종료
                           *************************************-->   
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
</body>
</html>