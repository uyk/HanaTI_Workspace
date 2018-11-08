<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<jsp:include page="../common/commoncss.jsp" />



<script type="text/javascript">


	// 선택한 메일 유지 메소드 아직 완성xxxx
	function checkemailaddy() {
		if (form.email_select.value == '1') {
			form.email2.readonly = false;
			form.email2.value = '';
			form.email2.focus();
		} else {
			form.email2.readonly = true;
			form.email2.value = form.email_select.value;
		}
	}

	
	function checkId(){
		
		// /user/checkId.rent로 보내야함
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
<main id="tg-main" class="tg-main tg-haslayout tg-bglight">

   <div class="container">
   
      <div class="row">
            <div class="tg-homebannerslider" class="tg-homebannerslider tg-haslayout">
                <div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
                  <div class="container"> 
               <div class="tg-tabcontent tab-content" style="padding: 0px 350px 0;">
                  <div role="tabpanel" class="tab-pane active fade in" id="home">
                     <div style="text-align: center; margin: 70px 0px"><h2>회원가입</h2></div>
  
                        <form class="tg-formtheme tg-formlogin" action="/sjrent/user/signup.rent" method="post" >
                           <fieldset>
                              <div class="form-group">
                                 <h4>아이디<sup>*</sup></h4>
                                 <input type="text" name="id" onkeydown="checkId()"class="form-control" placeholder="" maxlength="10" style="text-transform: none;">
                                 <span id=checkMsg></span>
                              </div>
                              
                              <div class="form-group">
                                 <h4>비밀번호<sup>*</sup></h4>
                                 <input type="password" name="password" class="form-control" placeholder="" maxlength="10" style="text-transform: none;">
                              </div>
                              
                              <div class="form-group">
                                 <h4>이름<sup>*</sup></h4>
                                 <input type="text" name="name" class="form-control" placeholder="" maxlength="10" style="text-transform: none;">
                              </div>
                                 
                              <div class="form-group">
                                 <h4>생년월일<sup>*</sup></h4>
                                 <div>
                                    <input style="display: inline-block; text-transform: lowercase;" name="birthday" type="text" size="15" maxlength="6" placeholder="e.g. 910101" > -   
                                    <input style="display: inline-block;" type="text" name="gender" size="1" maxlength="1">
                                    xxxxxx
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <h4>이메일<sup>*</sup></h4>
                                 <input type="text" name="email1" maxlength="10" size="12" style="text-transform: none;"> @ 
                                 <input type="text" name="email2" maxlength="10" size="12" style="text-transform: none;">  

                                 <select name="email_select" style="text-transform: lowercase;" class="box" id="email_select" onChange="checkemailaddy();">
                                  <option value="" selected>선택하세요</option>
                                  <option value="naver.com">naver.com</option>
                                  <option value="hotmail.com">hotmail.com</option>  
                                  <option value="hanmail.com">hanmail.com</option>
                                  <option value="yahoo.co.kr">yahoo.co.kr</option>
                                  <option value="1">직접입력</option>
                                 </select>
                              </div>
                                 
                              <div class="form-group">
                                 <h4>핸드폰번호<sup>*</sup></h4>
                                 <div style="display: inline-block;">
                                    <select style="width: 110px" name="cellphone1">
                                       <option> 0 1 0 
                                       <option> 0 1 1
                                       <option> 0 1 7
                                       <option> 0 1 8
                                       <option> 0 1 9
                                    </select>  -  
                                    <input type="text" size="11" maxlength="4"  name="cellphone2">  -  
                                    <input type="text" size="11" maxlength="4"  name="cellphone3">
                                 </div>
                              </div>
                           </fieldset>
                           
                           <div style=" text-align: center;">
                              <div style="display:inline-block; vertical-align: middle;  padding: 0px 10px; margin: 30px 0px 50px 0px;">
                                 <button type="submit" class="tg-btn tg-btn-lg"><span style="font-size: 14pt; width:50%">가입</span></button>
                              </div>
                              <div style="display:inline-block; vertical-align: middle;  padding: 0px 10px;  margin: 30px 0px 50px 0px;">
                                 <button type="reset" class="tg-btn tg-btn-lg"><span style="font-size: 14pt; width:50%">취소</span></button> 
                                  
                              </div>
                           </div>
                        </form>
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