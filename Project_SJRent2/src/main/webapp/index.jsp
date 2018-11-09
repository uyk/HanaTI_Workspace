<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
   <title>SJ 렌트카</title>
   <jsp:include page="common/commoncss.jsp"/> 
   <jsp:include page="common/commonjs.jsp"/> 
   <style>
   .tg-btn{
      margin-left: 30px;
   }
/*    .tg-homeslidervtwo .item figcaption{
      padding: 312px;
      width : 100%;
   } */
   </style>
</head>
<body class="tg-home tg-homevone">




	
	<!--************************************
			Wrapper Start
	*************************************-->
	<div id="tg-wrapper" class="tg-wrapper tg-haslayout">
	
		<!--************************************
					Home Start
			*************************************-->	
		<div class="tg-homebannerslider" class="tg-homebannerslider tg-haslayout">
				<div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
				<figure class="item" data-vide-bg="poster: images/slider/img-02.jpg" data-vide-options="position: 50% 50%">
					<figcaption>
						<div class="container">
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="tg-slidercontent">
										<h1>SJ 렌터카</h1>
										<h2>방문을 환영합니다.</h2>
										<div class="row justify-content-around" >
											<a class="tg-btn" href="<%=application.getContextPath()%>/rent/search.jsp"><span>실시간 예약</span></a>
											<a class="tg-btn" href="<%=application.getContextPath()%>/community/community.jsp"><span>커뮤니티</span></a>
											<a class="tg-btn" href="<%=application.getContextPath()%>/community/community.jsp"><span>위시리스트</span></a>
											<a class="tg-btn" href="<%=application.getContextPath()%>/wish/wish_list.jsp"><span>예약확인</span></a>
											<a class="tg-btn" href="<%=application.getContextPath()%>/user/login2.jsp"><span>로그인</span></a>

                  
                                                                

										</div>
									</div>
								</div>
							</div>
						</div>
					</figcaption>
				</figure>
			</div>
		</div>					
			<!--************************************
					Home End
			*************************************-->	
			<!--************************************
				Main Start
			*************************************-->
	</div>


</body>
</html>