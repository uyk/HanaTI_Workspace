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
   
   <style type="text/css">
   .button{
   	position: absolute;
   	top: 65%;
	left: 50%;
	transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	background-color: #d64161;
	color: white;
	font: bold; 
	font-size: 32px;
	padding: 50px 24px;
	border: none;
	cursor: pointer;
	box-shadow: 0 9px #999;
	border-radius: 50%;
	text-align: center;
}
   .button:active {
	  background-color: #c94c4c;
	  box-shadow: 0 5px #666;
	  /* transform: translateY(4px); */
	}
	
	.button:hover {
	/* background-color: #c94c4c */
	background-color: #ff8080;
	}
   </style>
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
	<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding: 0px 300px">
					<div class="tg-pkgplan" style="padding: 0px">
							
							
							<!--************************************
									Content 시작
							*************************************-->
							
							<img alt="게임시작화면" src="../images/rec/rec_index화면1.jpg">
							
							
							<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#my80sizeCenterModal">
  80%size Center
</button>
							
							
							
							
							
							
							
 							<!-- Modal -->
<div class="modal fade" id="rec_gender" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">



	<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding: 0px 300px">
					<div class="tg-pkgplan" style="padding: 0px">
						
						<!--************************************
									Content 시작
							*************************************-->
							
							<img alt="성별" src="../images/rec/rec_gender1.JPG">
							<button class="btn left" onclick="location='<%=application.getContextPath()%>/rec/rec_celeb1.jsp'">선택</button>
							<button class="btn right" onclick="location='<%=application.getContextPath()%>/rec/rec_celeb2.jsp'">선택</button>
							
							
						<!--************************************
									Content 종료
							*************************************-->					
					</div>
				</div>
			</div>
		</div>
	</main>

      </div>
    </div>
				
							
										
							
							
							
							
							
							
							
							<!--************************************
									Content 종료
							*************************************-->							
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