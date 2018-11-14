<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/commoncss.jsp" />
   <jsp:include page="../common/commonjs.jsp" />
   
<%-- <%
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
%> --%>

<script type="text/javascript">

/**  
 * 페이지 이동처리 방지를 위하여 시작시 실행
 */
$(document).ready( function() {
  $('#myform').submit(function (e) {
    e.preventDefault();
    loginCheck();
  })
});

/** 
 * 로그인 처리를 위한 Ajax 통신
 */
function loginCheck() {

  var id = $('#id').val();
  var pw = $('#pw').val();

  $.ajax({
    url : '/sjrent/user/login.rent',
    type : 'post',
    data : {
      id : id,
      pw : pw,
      login : 'myPage'
    },
    success : function(data) {
      if ($.trim(data) == "loginfail") {
        $('#checkMsg').html(
            "<p style='COLOR: red'>기존 회원정보와 불일치합니다.</p>");
      } else{
        location.href="/sjrent/user/read2.rent";        
      }
    },
    error : function() {
      alert("관리자에게 문의해주세요.");
    }
  });
  
} 

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
                        <div style="text-align: center; margin: 50px 0px"><h2>MyPage</h2></div>
                        <!--************************************
                                    Title 종료
                           *************************************-->   
                     
      <p style="text-align: center;">
      고객님의 안전한 회원정보를 위해<br>다시 한 번 로그인 해주시기 바랍니다.
      </p>    
 
 <!-- 로그인 실패시 Ajax 통신 후 text영역 -->
 <div style="text-align: center; margin-top: 10px; margin-bottom: 10px" id="checkMsg"></div>
 
 
                           
								<!--************************************
										회원 로그인 시작 
								*************************************-->
								<div role="tabpanel" class="tab-pane active fade in" id="user" >
                
									<form class="tg-formtheme tg-formlogin" method="post" id="myform">
										<fieldset>
											<div class="form-group">
												<label>아이디 <sup>*</sup></label>
												<input type="text" name="id" id="id" class="form-control" placeholder="" maxlength="16" style="text-transform:  none;" required value="${id }" >
											</div>
											<div class="form-group">
												<label>비밀번호 <sup>*</sup></label>
 								                <input type="password" name="pw" id="pw" class="form-control" placeholder="" maxlength="20"  style="text-transform:  none;" required>
											</div>
											<div class="form-group">
													<input type="checkbox" name="remember" id="rememberpass" style="display: inline-block; "><label for="rememberpass" style="display: inline-block; ">아이디 저장</label>
											</div>
  <!-- ajax 이용 -->
  <button type='submit' class="tg-btn tg-btn-lg" style="display: inline-block;  vertical-align: middle; margin-top: 10px" onclick="loginCheck()" >로그인 </button>
									</fieldset>
									
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