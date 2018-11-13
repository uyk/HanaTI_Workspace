<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String loginId = (String) request.getAttribute("loginId");
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
  <jsp:include page="../include/nav.jsp" />
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
    <jsp:include page="../include/header.jsp" />
    <!--************************************
      Header 종료
*************************************-->

    <!--************************************
      Main 시작
*************************************-->
    <main id="tg-main"
      class="tg-main tg-sectionspace tg-haslayout tg-bglight">
    <div class="container">
      <div class="row">
        <div class="tg-homebannerslider"
          class="tg-homebannerslider tg-haslayout">
          <div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
            <div class="container">
              <div class="tg-tabcontent tab-content"
                style="padding: 0px 350px 0;">
                <div role="tabpanel" class="tab-pane active fade in"
                  id="home">

                  <div style="text-align: center;">
                    <h2>회원탈퇴</h2>
                  </div>

                </div>
              </div>


              <div>
                <p style="text-align: center;">
                  <%=loginId%>님
                </p>
              </div>


              <!--************************************
                                    MenuBar 시작 
                              *************************************-->
              <jsp:include page="menuBar.jsp" />
              <!--************************************
                                    MenuBar 종료 
                              *************************************-->

              <div style="text-align: center;">
                <h1>정말 탈퇴 하시겠습니까?</h1>



                <div style="text-align: center;">
                  <div
                    style="display: inline-block; vertical-align: middle; padding: 0px 10px; margin: 30px 0px 50px 0px;">
                    <button type="button" class="tg-btn tg-btn-lg" onclick="location.href='/sjrent/mypage/delete.rent'">
                      <span style="font-size: 14pt; width: 50%">예</span>
                    </button>
                  </div>
                  <div
                    style="display: inline-block; vertical-align: middle; padding: 0px 10px; margin: 30px 0px 50px 0px;">
                    <button type="button" class="tg-btn tg-btn-lg" onclick="location.href='/sjrent/mypage/myPageLoginOK.jsp'">
                      <span style="font-size: 14pt; width: 50%">아니오</span>
                    </button>

                  </div>
                </div>
                
                




                <!-- <button type="button" class="btn btn-secondary"
                  onclick="location.href='/sjrent/mypage/delete.rent'">예</button>
                <button type="button" class="btn btn-primary"
                  onclick="location.href='/sjrent/mypage/myPageLoginOK.jsp'">아니오</button> -->

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