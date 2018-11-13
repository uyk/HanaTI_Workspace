<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" />
<script type="text/javascript">
$(document).ready(function(){
	 $("#info_detail").click(function() {
			var $w = $(this).attr('href');
			layer_popup($w);
		});
});
	function layer_popup(e){
		var $e = $(e);
		
		$(".info_car").fadeIn();
		  var $elWidth = ~~($e.outerWidth()),
	      $elHeight = ~~($e.outerHeight()),
	      docWidth = $(document).width(),
	      docHeight = $(document).height();

		  // 화면의 중앙에 레이어를 띄운다.
		  if ($elHeight < docHeight || $elWidth < docWidth) {
		      $e.css({
		          marginTop: -$elHeight /2,
		          marginLeft: -$elWidth/2
		      })
		  } else {
		      $e.css({top: 0, left: 0});
		  }
		
		  $e.find('a.btn-layerClose').click(function(){
		      isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
		      return false;
		  });
		
		  $('.layer .dimBg').click(function(){
		      $('.dim-layer').fadeOut();
		      return false;
		  });
	}
</script>
</head>
<body>

	<!--************************************
			Mobile Menu Start
	*************************************-->
	<jsp:include page="../include/nav.jsp" />
	<!--************************************
			Mobile Menu End
	*************************************-->
	<!--************************************
			Wrapper Start
	*************************************-->
	<div id="tg-wrapper" class="tg-wrapper tg-haslayout">
		<!--************************************
					Header Start
			*************************************-->
		<jsp:include page="../include/header.jsp"></jsp:include>
		<!--************************************
					Header End
		*************************************-->
		<!--************************************
				Main Start
		*************************************-->
		<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout tg-bglight">
			<div class="container">
				<div class="row">
					<div id="tg-twocolumns" class="tg-twocolumns">
						<div class="info_car" style="display: none">
							<jsp:include page="rent_detail.jsp"/>
						</div>
						<form class="tg-formtheme tg-formtourpayment">
							<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 pull-left">
								<div id="tg-content" class="tg-content">
									<!-- 여태 렌트했던 목록들 띄우기 -->
									<div class="tg-tourpaymentdetail" id="rentList">
										<div class="tg-tourname">
											<a class="tg-btnedit" href="#">결제취소</a>
											<figure>
												<a href="javascript:void(0);"><img src="../images/G70.jpg" style="width: 100px" height="auto" alt="image destinations"></a>
											</figure>
											<div class="tg-populartourcontent">
												<div class="tg-populartourtitle">
													<h3><a href="javascript:void(0);">G70</a></h3>
												</div>
												<div class="tg-populartourfoot form-control" style="background: inherit;" >
													<div class="tg-durationrating"></div>
													<span class="tg-tourduration">2018.11.05 ~ 2018.11.07</span>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 pull-right">
								<aside id="tg-sidebar" class="tg-sidebar">
									<div class="tg-widget tg-widgettourinfo">
										<div class="tg-widgetcontent">
											<ul>
												<li><span>Travel Date</span><em>May 12, 2017</em></li>
												<li><span>Period</span><em>12 Days</em></li>
												<li><span>Persons</span><em>5</em></li>
												<li><span>Rooms</span><em>1</em></li>
												<li class="tg-couponapply">
													<div class="form-group">
														<div class="row" style="height:40px;"></div>
															<button id = "info_detail" class="tg-btn">상세보기</button>
													</div>
												</li>
											</ul>
										</div>
									</div>
								</aside>
							</div>
						</form>
					</div>
				</div>
			</div>
		</main>
		<!--************************************
				Main End
		*************************************-->
	</div>
	
</body>
</html>