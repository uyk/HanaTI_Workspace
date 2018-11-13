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
   
<script type="text/javascript">
   
function emailCheck() {

	var email = $('#email').val();

	console.log("email"+email);
	$.ajax({
		url : '/sjrent/user/checkEmail.rent',
		type : 'post',
		data : {
			email : email
		},
		success : function(data) {
			if ($.trim(data) == "success") {
				$('#checkMsg2').html(
						"<p style='COLOR: blue'>사용가능한 이메일입니다.</p>");
			} else{
				$('#checkMsg2').html(
				"<p style='COLOR: red'>이미 사용중인 이메일입니다.</p>");
			}
		},
		error : function() {
			alert("관리자에게 문의해주세요.");
		}
	});
	
}   
   
</script>
   
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
                  <div class="tg-tabcontent tab-content" style="padding: 0px 350px;">
                     <div role="tabpanel" class="tab-pane active fade in" id="home">
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
                               <p style="text-align: center; ">
                              <%=loginId%>님 환영합니다. 
                              </p> 
                      	</div>
						<!--************************************
                                    MenuBar 시작 
                              *************************************-->
						<jsp:include page="menuBar.jsp" />
						<!--************************************
                                    MenuBar 종료 
                              *************************************-->
						
						<!--************************************
                                    회원정보수정 시작 
                              *************************************-->
                       <div role="tabpanel" class="tab-pane active fade in" id="home" style="width: 50%; margin-left: 350px">
						<form class="tg-formtheme tg-formlogin" action="/sjrent/mypage/update.rent" method="post" >
                           <fieldset>
                              <div class="form-group">
                                 <h4>아이디<sup>*</sup></h4>
                                 <input type="text" name="id" class="form-control" placeholder="${user.id }" maxlength="10" style="text-transform: none;" required readonly>
                              </div>
                              <%-- <%=loginId%>  ${user.id }--%>
                              <div class="form-group">
                                 <h4>비밀번호<sup>*</sup></h4>
                                 <input type="password" name="password" class="form-control" placeholder="${user.password }" maxlength="10" style="text-transform: none;" required>
                              </div>
                              
                              <div class="form-group">
                                 <h4>이름<sup>*</sup></h4>
                                 <input type="text" name="name" class="form-control" placeholder="${user.name }" maxlength="10" style="text-transform: none;" required>
                              </div>
                                 
                              <div class="form-group">
                                 <h4>생년월일<sup>*</sup></h4>
                                 <div>
                                    <input type="text" class="form-control" style="display: inline-block; text-transform: lowercase; width: 20%" name="birthday" size="15" maxlength="6" placeholder="${user.birthday }" readonly> -   
                                    <input class="form-control" style="display: inline-block; width:10% " type="text" name="gender" size="1" maxlength="1" placeholder="${user.gender }" readonly>
                                    xxxxxx
                                 </div>
                              </div>
                              
                              <div class="form-group">
									<label>이메일 <sup>*</sup></label>
									<input type="text" name="email" id="email" class="form-control" placeholder="${user.email }" maxlength="30" style="text-transform: lowercase;" required>
                                    
							  </div>
                
         <!-- 버튼 위치 수정해야함 -->
         <button type="button" class="btn buttonEmail " style="height: 40px; margin-left: 10px; " onclick="emailCheck()" >중복확인 </button>
         <div style="float:left; border: none; display: inline-block; margin-top: 10px; margin-bottom: 0" id="checkMsg2"></div>
     
											
							<div class="form-group">
								<label>핸드폰번호 <sup>*</sup></label>
								<input type="text" name="cellphone" class="form-control" placeholder="${user.cellphone }" maxlength="13" style="text-transform: lowercase;" required>
							</div>
			                          
                               
                           </fieldset>
                           
                           <div style=" text-align: center;">
                              <div style="display:inline-block; vertical-align: middle;  padding: 0px 10px; margin: 30px 0px 50px 0px;">
                                 <button type="submit" class="tg-btn tg-btn-lg"><span style="font-size: 14pt; width:50%">수정</span></button>
                              </div>
                              <div style="display:inline-block; vertical-align: middle;  padding: 0px 10px;  margin: 30px 0px 50px 0px;">
                                 <button type="reset" class="tg-btn tg-btn-lg"><span style="font-size: 14pt; width:50%">취소</span></button> 
                                  
                              </div>
                           </div>
                        </form>
				</div>
						
						
						<!--************************************
                                    회원정보수정 종료 
                              *************************************-->
												
						
						

							<!--************************************
                                 Content 종료
                           *************************************-->

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