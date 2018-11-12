<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
\
<jsp:include page="../common/commoncss.jsp" />


<style type="text/css">

.buttonId{
     position: relative;
     top: 75px;
     left: 450px; 
     /* transform: translate(-50%, -50%);
     -ms-transform: translate(-50%, -50%);  */
}

.buttonEmail{
     position: relative;
     top: 513px;
     left: 360px; 
     /* transform: translate(-50%, -50%);
     -ms-transform: translate(-50%, -50%);  */
}



/* .idCheckResult{
	 position: relative;
     top: 45px;
     left: 550px; 
} */ 
</style>




<script type="text/javascript">



	function checkId() {

		var id = $('#id').val();
		//console.log("넣은아이디" + id);
		alert(id); 

		$.ajax({
			url : '/sjrent/user/checkId.rent',
			type : 'post',
			data : {
				id : id
			},
			success : function(data) {
				if($.trim(data) != null){
					if ($.trim(data) == "success") {
						$('#checkMsg').html(
								"<span style='COLOR: blue'>사용가능한 아이디입니다.</span>");
					} else if($.trim(data) == "fail"){
						$('#checkMsg').html(
								"<p style='COLOR: red'>이미 사용중인 아이디입니다.</p>");
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
	
	
	/* function checkEmail() {

		var email1 = $('#email1').val();
		console.log("넣은email1" + email1);

		var email2 = $('#email2').val();
		console.log("넣은email2" + email2);

		var email = email1 + email2;
		
		console.log("넣은이메일" + email);

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
				alert("에러입니다");
			}
		});

	} */
	
	//재민 시작-----------------------------------------------------------------
	
	function idCheck() {
		//alert('e');
		var id = $('#id').val();
		//console.log("넣은아이디" + id);
		//alert(id);

		$.ajax({
			url : '/sjrent/user/checkId.rent',
			type : 'post',
			data : {
				id : id
			},
			success : function(data) {
				if($.trim(data) != null){
					if ($.trim(data) == "success") {
						$('#checkMsg').html(
								"<p style='COLOR: blue'>사용가능한 아이디입니다.</p>");
					} else if($.trim(data) == "fail"){
						$('#checkMsg').html(
								"<p style='COLOR: red'>이미 사용중인 아이디입니다.</p>");
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

	function emailSelect() {
		//alert('dddd');
		var emailSelectBox = document.getElementById("emailSelectBox");
		var email2 = document.getElementById("email2");

		email2.value = emailSelectBox.options[emailSelectBox.selectedIndex].value;

	}
	
	function emailCheck() {
		//alert('g');
		var email1 = $('#email1').val();
		var email2 = $('#email2').val();
		var email = email1 + "@" + email2; 
		//alert(email);
		

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
				alert("에러입니다");
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
<main id="tg-main" class="tg-main tg-haslayout tg-bglight">

   <div class="container">
   
      <div class="row">
            <div class="tg-homebannerslider" class="tg-homebannerslider tg-haslayout">
                <div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
                  <div class="container"> 
               <div class="tg-tabcontent tab-content" style="padding: 0px 350px 0;">
                  <div role="tabpanel" class="tab-pane active fade in" id="home">
                     <div style="text-align: center; margin: 70px 0px 0px"><h2>회원가입</h2></div>
                     <div>
                     
                     <button type="button" class="btn buttonId " style="height: 40px; " onclick="idCheck()" >중복확인 </button>
                     <button type="button" class="btn buttonEmail " style="height: 40px; margin-left: 10px; " onclick="emailCheck()" >중복확인 </button>
                     
                    <!--  <div id="checkMsg" class="idCheckResult"></div> -->
 
                    
                     </div>
                        <form class="tg-formtheme tg-formlogin" action="/sjrent/user/signup.rent" method="post" >
                           <fieldset>
                             <!--  <div class="form-group">
                                 <div style="vertical-align: middle;">
                                 <h4 style="display: inline-block;">아이디<sup>*</sup></h4>
                                 
                                 <div style="display: inline-block;">
                                 <button type="button" class="btn btn-outline-success" style="height: 40px; margin-left: 10px; " onclick="emailCheck()" >중복확인 </button>
                                 </div> 
                                 </div>
                                 <div style="vertical-align: middle;">
                                 <input type="text" name="id" id="id" class="form-control" oninput="checkId()" maxlength="10" style="text-transform: none; display:  inline-block;" required placeholder="최대 10자 입력 가능">
                                 </div>
                              </div> -->
                              
                              
                              <!-- <span style="border: none; " id="checkMsg" class="idCheckResult"></span> -->
                              
                              
                              
                              <div class="form-group">
	                             <h4>아이디<sup>*</sup></h4>
                                 <input type="text" name="id" class="form-control" id="id" maxlength="10" style="text-transform: none; " required placeholder="최대 10자 입력 가능">
								 <div style="float:left; border: none; margin-top: 10px;" id="checkMsg"></div>                    
                              </div>
                             
                              <div class="form-group">
                                 <h4>비밀번호<sup>*</sup></h4>
                                 <input type="password" name="password" class="form-control" maxlength="10" style="text-transform: none;" required placeholder="최대 10자 입력 가능">
                              </div>
                              
                              
                               <div class="form-group">
                                 <h4>비밀번호확인<sup>*</sup></h4>
                                 <input type="password" name="password2" class="form-control" maxlength="10" style="text-transform: none;" required placeholder="최대 10자 입력 가능">
                              </div>
                              
                              <div class="form-group">
                                 <h4>이름<sup>*</sup></h4>
                                 <input type="text" name="name" class="form-control" placeholder="" maxlength="10" style="text-transform: none;" required>
                              </div>
                                 
                              <div class="form-group">
                                 <h4>생년월일<sup>*</sup></h4>
                                 <div>
                                    <input style="display: inline-block; text-transform: lowercase;" name="birthday" type="text" size="15" maxlength="6" placeholder="e.g. 910101" required> -   
                                    <input style="display: inline-block;" type="text" name="gender" size="1" maxlength="1" required>
                                    xxxxxx
                                 </div>
                              </div>
                              
                               <div class="form-group">
                               <div style="vertical-align: middle;">
                                 <h4 style="display: inline-block;" >이메일<sup>*</sup></h4>
                                 
                                </div>
                                
                               
                               <div style="vertical-align: middle;">
                                  <input type="text" name="email1" id="email1" maxlength="10" size="12" style="text-transform: none;" required> @ 
                                  <input type="text" name="email2" id="email2" maxlength="10" size="12" style="text-transform: none;" required  oninput="checkEmail()">  
                                 
                                 <select name="emailSelectBox" style="text-transform: lowercase;" class="box" id="emailSelectBox" onchange="emailSelect()" >
                                    <option value="" selected >선택하세요</option>
                                    <option value="naver.com" >naver.com</option>
                                    <option value="hotmail.com" id="hotmail">hotmail.com</option>   
                                    <option value="hanmail.com" id="hanmail">hanmail.com</option>
                                    <option value="yahoo.co.kr" id="yahoo">yahoo.co.kr</option>
                                    <option value="">직접입력</option>
                                 </select>
                                  
                                 <!-- <div style="display: inline-block;">
                                 <button type="button" class="btn btn-outline-success" style="height: 40px; margin-left: 10px; " onclick="emailCheck()" >중복확인 </button>
                                 </div> -->
                              </div>
                              <div style="float:left; border: none; display: inline-block; margin-top: 10px; margin-bottom: 0" id="checkMsg2"></div>
                              </div>
                                 
                              <div class="form-group">
                                 <h4>핸드폰번호<sup>*</sup></h4>
                                 <div style="display: inline-block;">
                                    <select style="width: 140px" name="cellphone1">
                                       <option> 010 
                                       <option> 011
                                       <option> 017
                                       <option> 018
                                       <option> 019
                                    </select>  -  
                                    <input type="text" size="12" maxlength="4"  name="cellphone2">  -  
                                    <input type="text" size="12" maxlength="4"  name="cellphone3">
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