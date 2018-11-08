<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/commoncss.jsp" />
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
                        <form class="tg-formtheme tg-formlogin">
                           <fieldset>
                              <div class="form-group">
                                 <h4>아이디<sup>*</sup></h4>
                                 <input type="text" name="id" class="form-control" placeholder="" maxlength="10">
                              </div>
                              
                              <div class="form-group">
                                 <h4>비밀번호<sup>*</sup></h4>
                                 <input type="password" name="password" class="form-control" placeholder="" maxlength="10">
                              </div>
                              
                              <div class="form-group">
                                 <h4>이름<sup>*</sup></h4>
                                 <input type="text" name="id" class="form-control" placeholder="" maxlength="10">
                              </div>
                                 
                              <div class="form-group">
                                 <h4>생년월일<sup>*</sup></h4>
                                 <div>
                                    <input style="display: inline-block; text-transform: lowercase;" type="text" size="15" maxlength="6" placeholder="e.g. 910101" > -   
                                    <input style="display: inline-block;" type="text" name="birthLast" size="1" maxlength="1">
                                    xxxxxx
                                 </div>
                              </div>
                              
                              <div class="form-group">
                                 <h4>이메일<sup>*</sup></h4>
                                 <input type="text" name="email" maxlength="15" size="12"> @ 
                                 <input type="text" name="email" maxlength="10" size="12">  
                                 <select style="text-transform: lowercase;">
                                    <option>직접입력
                                    <option>naver.com
                                    <option>gmail.com
                                    <option>daum.net
                                    <option>hotmail.com
                                 </select>   
                              </div>
                                 
                              <div class="form-group">
                                 <h4>핸드폰번호<sup>*</sup></h4>
                                 <div style="display: inline-block;">
                                    <select style="width: 110px">
                                       <option> 0 1 0 
                                       <option> 0 1 1
                                       <option> 0 1 7
                                       <option> 0 1 8
                                       <option> 0 1 9
                                    </select>  -  
                                    <input type="text" size="11" maxlength="4">  -  
                                    <input type="text" size="11" maxlength="4">
                                 </div>
                              </div>
                           </fieldset>
                           
                           <div style=" text-align: center;">
                              <div style="display:inline-block; vertical-align: middle;  margin: 30px 0px 0px;">
                                 <button class="tg-btn tg-btn-lg"><span style="font-size: 14pt; width:50%">가입</span></button>
                              </div>
                              <div style="display:inline-block; vertical-align: middle;  padding: 0px 20px;  margin: 30px 0px 0px;">
                                 <button class="tg-btn tg-btn-lg"><span style="font-size: 14pt; width:50%">취소</span></button>
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