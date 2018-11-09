<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <title>SJ 렌트카</title>
   <meta name="description" content="">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="apple-touch-icon" href="apple-touch-icon.png">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/bootstrap.min.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/normalize.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/font-awesome.min.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/icomoon.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/owl.carousel.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/bootstrap-select.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/scrollbar.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/jquery.mmenu.all.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/prettyPhoto.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/transitions.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/main.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/color.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/css/responsive.css">
   <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
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
<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout tg-bglight">
	<div class="container">
		<div class="row">
			<div class="tg-homebannerslider tg-homebannerslider tg-haslayout">
				<div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
					<div class="container">
						<div class="tg-tabcontent tab-content" style="padding: 0px 350px 0;">
							<div role="tabpanel" class="tab-pane active fade in" id="home">
								<div style="text-align: center; margin: 50px 0px;">
									<h2>결제 완료</h2>
								</div>

									<div class="form-group">
										<div style="display: inline-block;">
									<h4 style="width: 100px">예약자 :</h4>
									</div>
									<div style="display: inline-block">
									<input type="text" name="id" style="border: none;"
									maxlength="10">
										</div>
									</div>

									<div class="form-group">
										<div style="display: inline-block;">
									<h4 style="width: 100px">차이름 :</h4>
									</div>
									<div style="display: inline-block">
									<input type="text" name="email" style="border: none;"
									maxlength="10">
										</div>
									</div>
									
									<div class="form-group">
										<div style="display: inline-block;">
									<h4 style="width: 100px">날 짜 :</h4>
									</div>
									<div style="display: inline-block">
									<input type="text" name="phone" style="border: none;"
									maxlength="10">
										</div>
									</div>

								<form class="tg-formtheme tg-formlogin">
									<div style="margin: 50px 0px; text-align: center;">
										<div style="display: inline-block; vertical-align: middle; padding: 0px 20px">
											<button class="tg-btn tg-btn-lg" style="padding: 0px 30px;">
												<span style="font-size: 14pt; width: 30%">홈으로</span>
											</button>
										</div>
										
										<div style="display: inline-block; vertical-align: middle; padding: 0px 20px">
											<button class="tg-btn tg-btn-lg" style="padding: 0px 30px;">
												<span style="font-size: 14pt; width: 10%">결제내역</span>
											</button>
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
</body>
</html>