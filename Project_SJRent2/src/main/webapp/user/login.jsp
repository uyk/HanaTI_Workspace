<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/commoncss.jsp" />

<%
	String id = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("saveId")) {
				id = cookie.getValue();
			}
		}
	}
	// 초기화면 아이디 null시
	if (id == null) {
		id = "";
	}
%>

<script type="text/javascript">


// 로그인시 아이디 존재하지 않으면 글씨띄우기 다른 3곳도 동일




</script>


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
                     
    <!-- 가수정 -->                       
    <div style="float:left; border: none; display: inline-block; margin-top: 10px; margin-bottom: 0" id="checkMsg"></div>                       
								<!--************************************
										회원 로그인 시작 
								*************************************-->
								<div role="tabpanel" class="tab-pane active fade in" id="user" >
                
									<form class="tg-formtheme tg-formlogin" action="/sjrent/user/login.rent" method="post">
										<fieldset>
											<div class="form-group">
												<label>아이디 <sup>*</sup></label>
												<input type="text" name="id" class="form-control" placeholder="" maxlength="16" style="text-transform:  none;" required value="${id }" >
											</div>
											<div class="form-group">
												<label>비밀번호 <sup>*</sup></label>
 								                <input type="password" name="pw" class="form-control" placeholder="" maxlength="20"  style="text-transform:  none;" required>
											</div>
											<div class="form-group">
													<input type="checkbox" name="remember" id="rememberpass" style="display: inline-block; "><label for="rememberpass" style="display: inline-block; ">아이디 저장</label>
											</div>
											<button type="submit" class="tg-btn tg-btn-lg" ><span>로그인</span></button>
										</fieldset>
                                        <input type="hidden" name="login" value="login"/>
									</form>
								</div>
								<!--************************************
										회원 로그인 종료 
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
    <jsp:include page="../common/commonjs.jsp" />
</body>
</html>