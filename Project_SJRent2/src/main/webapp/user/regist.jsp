<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<style>
.title{
	display: inline-block; 
	border:none; 
	font-size:14pt; 
	width:16%; 
	background-color:#fafafa; 
	margin-left:20%;
}
.button {
    border: none;
    color: white;
  	padding: 4px 8px; 
    text-align: center;
    display: inline-block;
    font-size: 13px;
    transition-duration: 0.4s; */
    cursor: pointer;
    height:38px; 
    border-radius:8px;
    background-color: #555555;
}
.button4 {
    background-color: white;
    color: black;
    border: 2px solid #e7e7e7;
}
.button4:hover {
	background-color: #e7e7e7;
    color: white;
    }
</style>

<script type="text/javascript">
	/** 아이디 중복확인 */
	function idCheck() {
		var id = $('#id').val();
		
		/** 첫글자 영어 */
		var idReg = /^[a-z]+[a-z0-9]{0,9}$/g;
        if( !idReg.test(id) ) {//첫글자영어아님
            alert("아이디는 영문자로 시작하는 10자이하 영문자 또는 숫자이어야 합니다.");
            return false;
        }else {
        	$.ajax({
    			url : '/sjrent/user/checkId.rent',
    			type : 'post',
    			data : {
    				id : id
    			},
    			success : function(data) {
    				if($.trim(data) != null){
    					if ($.trim(data) == "success") {
    						$('#idCheckMsg').html(
    								"<span style='COLOR: blue'>사용가능</span>");
    								document.getElementById("regist").disabled = false;
    						return true; 
    					} else if($.trim(data) == "fail"){
    						$('#idCheckMsg').html(
    								"<span style='COLOR: red'>사용불가</span>");
    								document.getElementById("regist").disabled = true;
    						
    						return false; 
    				}else{
    					
    					$('#checkMsg').html(
    					"<p style='COLOR: green'>입력값없음.....</p>");
    				}
    				}
    				
    			},
    			error : function() {
    				alert("에러입니다");
    			}
    		});
		}
	}
	/** 이메일 선택하기 */
	function emailSelect() {
		var emailSelectBox = document.getElementById("emailSelectBox");
		var email2 = document.getElementById("email2");
		email2.value = emailSelectBox.options[emailSelectBox.selectedIndex].value;
	}
	
	/** 이메일 중복확인하기 */
	function emailCheck() {
		var email1 = $('#email1').val();
		email2 = $('#email2').val();
		var email = email1 + "@" + email2; 
		$.ajax({
			url : '/sjrent/user/checkEmail.rent',
			type : 'post',
			data : {
				email : email
			},
			success : function(data) {
				if ($.trim(data) == "success") {
					$('#checkMsg2').html(
							"<span style='COLOR: blue'>사용가능</span>");
					document.getElementById("regist").disabled = false;
				} else{
					$('#checkMsg2').html(
					"<span style='COLOR: red'>사용불가</span>");
					document.getElementById("regist").disabled = true;
				}
			},
			error : function() {
				alert("에러입니다");
			}
		});
		
	}
	
	/** 비밀번호 일치 여부 체크 */
	function pwCheck(){
		var password1 = document.getElementById("password1").value;
		var password2 = document.getElementById("password2").value;
		if(password1 == password2){
			document.getElementById("pwCheckMsg").innerHTML = '일치';
			$('#pwCheckMsg').css('color','blue');
			document.getElementById("regist").disabled = false;
		}else{
			document.getElementById("pwCheckMsg").innerHTML = '불일치';
			$('#pwCheckMsg').css('color','red');
			document.getElementById("password2").focus(); 
			document.getElementById("regist").disabled = true; 
			return false; 
		}
	}
	
	
	/** 숫자만 입력 가능(생년월일앞) */
	function onlyNumber(event){
	    event = event || window.event;
	    var keyID = (event.which) ? event.which : event.keyCode;
	    if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
	        return;
	    else
	        return false;
	}
	
	/** 숫자만 입력 가능(생년월일앞) */ 
	function removeChar(event) {
	    event = event || window.event;
	    var keyID = (event.which) ? event.which : event.keyCode;
	    if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
	        return;
	    else
	        event.target.value = event.target.value.replace(/[^0-9]/g, "");
	}
	/** 숫자만 입력 가능(생년월일뒤:1234) */ 
	function removeChar2(event) {
	    event = event || window.event;
	    var keyID = (event.which) ? event.which : event.keyCode;
	    if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
	        return;
	    else
	        event.target.value = event.target.value.replace(/[^1-4]/g, "");
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
               <div class="tg-tabcontent tab-content" style="padding: 0px 100px 0;">
                  <div role="tabpanel" class="tab-pane active fade in" id="home">
                     <div style="text-align: center; margin: 70px 0px 0px"><h2>회원가입</h2></div>
                     <div>
                     
                    
                     </div>
                        <form class="tg-formtheme tg-formlogin" action="/sjrent/user/signup.rent" method="post" >
                           <fieldset>
							<!-- 아이디 -->
                              <div>
                              	<div style="vertical-align: middle; margin:10px 0px">
		                             <span class="title" value="아이디" readonly>아이디<sup>*</sup></span>
	                                 <input type="text" name="id"  id="id" maxlength="16" style="text-transform: none; display: inline-block; " required placeholder="첫 글자는 영어">
									 <button onclick="idCheck()"  class="button button4">중복확인</button>
									 <div style="border: none; display: inline-block;" id="idCheckMsg"></div>                    
								</div> 
                              </div>
                             
                             <!-- 비밀번호 -->
                              <div style="vertical-align: middle; margin:10px 0px">
                                  <span class="title" value="비밀번호" readonly>비밀번호<sup>*</sup></span>
                                 <input type="password" name="password1" id="password1" maxlength="10" style="text-transform: none; display: inline-block;" required placeholder="최대 10자">
                              </div>
                              
                             <!-- 비밀번호확인 -->
                               <div style="vertical-align: middle; margin:10px 0px">
                                 <span class="title" value="비밀번호확인" readonly>비밀번호확인<sup>*</sup></span>
                                 <input type="password" name="password2" id="password2" maxlength="10" style="text-transform: none; display: inline-block;" required placeholder="비밀번호 한 번 더 입력" onchange=pwCheck()>
                              	 <div style="border: none; display: inline-block;" id="pwCheckMsg"></div>
                              </div>
                              
                              <!-- 이름 -->
                              <div style="vertical-align: middle; margin:10px 0px">
                                  <span class="title" value="이름" readonly>이름<sup>*</sup></span>
                                 <input type="text" name="name" id="name" placeholder="" maxlength="10" style="text-transform: none; display: inline-block;" required>
                              </div>
                                 
                              <!-- 생년월일 -->   
                              <div style="vertical-align: middle; margin:10px 0px">
                                 <span class="title" value="생년월일" readonly>생년월일<sup>*</sup></span>
                                 
                                 <div style="display:inline-block">
                                    <input style="display: inline-block; text-transform: lowercase;" name="birthday" id="birthday" type="text" size="7" maxlength="6" placeholder="ex)910101" required onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' > -   
                                    <input style="display: inline-block;" type="text" name="gender" id="gender" size="1" maxlength="1" required required onkeydown='return onlyNumber(event)' onkeyup='removeChar2(event)'>
                                    xxxxxx
                                 </div>
                              </div>
                              
                               <div style="vertical-align: middle; margin:10px 0px">
                              
                              <!-- 이메일 -->
                                 <span class="title" value="이메일" readonly>이메일<sup>*</sup></span>
                                  <input type="text" name="email1" id="email1" maxlength="10" size="11" style="text-transform: none; display:inline-block" required> @ 
                                  <input type="text" name="email2" id="email2" maxlength="15" size="11" style="text-transform: none; display:inline-block" required  oninput="checkEmail()">  
                                 
                                 <select name="emailSelectBox" style="text-transform: lowercase; display:inline-block" class="box" id="emailSelectBox" onchange="emailSelect()" >
                                    <option value="" selected >선택하세요</option>
                                    <option value="kosta.co.kr" id="kosta.co.kr">kosta.co.kr</option>
                                    <option value="naver.com" id="naver.com">naver.com</option>
                                    <option value="hotmail.com" id="hotmail">hotmail.com</option>   
                                    <option value="hanmail.com" id="hanmail">hanmail.com</option>
                                    <option value="yahoo.co.kr" id="yahoo">yahoo.co.kr</option>
                                    <option value="">직접입력</option>
                                 </select>
                                 <button onclick="emailCheck()" class="button button4">중복확인</button>
                                  
                              <div style=" border: none; display: inline-block; margin-top: 10px; margin-bottom: 0" id="checkMsg2"></div>
                              </div>
                                
                                <!-- 핸드폰번호 --> 
                              <div style="vertical-align:middle; margin:10px 0px">
                                 <span class="title" value="핸드폰번호" readonly>핸드폰번호<sup>*</sup></span>
                                 <div style="display: inline-block;">
                                    <select style="width: 100px" name="cellphone1" id="cellphone1">
                                       <option> 010 
                                       <option> 011
                                       <option> 017
                                       <option> 018
                                       <option> 019
                                    </select>  -  
                                    <input type="text" size="4" maxlength="4"  name="cellphone2" id="cellphone2" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'>  -  
                                    <input type="text" size="4" maxlength="4"  name="cellphone3" id="cellphone3" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'>
                                 </div>
                              </div>
                           </fieldset>
                           
                           <!-- 하단 -->
                           <div style=" text-align: center;">
                              <div style="display:inline-block; vertical-align: middle;  padding: 0px 10px; margin: 30px 0px 50px 0px;">
                                 <button type="submit" class="tg-btn tg-btn-lg" id="regist"><span style="font-size: 14pt; width:50%">가입</span></button>
                              </div>
                              <div style="display:inline-block; vertical-align: middle;  padding: 0px 10px;  margin: 30px 0px 50px 0px;">
                                 <button type="reset" class="tg-btn tg-btn-lg" ><span style="font-size: 14pt; width:50%">취소</span></button> 
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