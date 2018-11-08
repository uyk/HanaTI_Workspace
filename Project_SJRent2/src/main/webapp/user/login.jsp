<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
 	<script src="<%=application.getContextPath()%>/js/vendor/jquery-library.js"></script>
   <script src="<%=application.getContextPath()%>/js/vendor/bootstrap.min.js"></script>
   <script src="https://maps.google.com/maps/api/js?key=AIzaSyCR-KEWAVCn52mSdeVeTqZjtqbmVJyfSus&language=en"></script>
   <script src="<%=application.getContextPath()%>/js/bootstrap-select.min.js"></script>
   <script src="<%=application.getContextPath()%>/js/jquery-scrolltofixed.js"></script>
   <script src="<%=application.getContextPath()%>/js/owl.carousel.min.js"></script>
   <script src="<%=application.getContextPath()%>/js/jquery.mmenu.all.js"></script>
   <script src="<%=application.getContextPath()%>/js/packery.pkgd.min.js"></script>
   <script src="<%=application.getContextPath()%>/js/jquery.vide.min.js"></script>
   <script src="<%=application.getContextPath()%>/js/scrollbar.min.js"></script>
   <script src="<%=application.getContextPath()%>/js/prettyPhoto.js"></script>
   <script src="<%=application.getContextPath()%>/js/countdown.js"></script>
   <script src="<%=application.getContextPath()%>/js/parallax.js"></script>
   <script src="<%=application.getContextPath()%>/js/gmap3.js"></script>
   <script src="<%=application.getContextPath()%>/js/main.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	$('#login').submit(function(e){
		alert('aa');
	});

}) */
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
										<!--************************************
													Content 시작 (login 성공하면)
											*************************************-->		
											<form action="#" id = "login" class="tg-formlogin">
												<fieldset>
													<h4>아이디<sup>*</sup></h4>
													<input type="text" name="id" class="form-control" placeholder="" maxlength="10" required>
													<h4>비밀번호<sup>*</sup></h4>
													<input type="password" name="password" class="form-control" placeholder="" maxlength="10" required>
													 <div>
														<input type="checkbox" style="display: inline;">
														<h6 style="display: inline;">아이디저장</h6>
													</div>
													<input type="submit" id="bbbbb" class="tg-btn tg-btn-lg"  style="font-size: 14pt" value="로그인">
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