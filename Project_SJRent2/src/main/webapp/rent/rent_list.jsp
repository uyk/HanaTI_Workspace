<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" />
<style type="text/css">
.in {
   background: rgba(0, 0, 0, 0.8);
}
.modal-backdrop{
   position: static;
}
/* Set the size of the div element that contains the map */
#map {
  height: 400px;  /* The height is 400 pixels */
  width: 100%;  /* The width is the width of the web page */
}
#floating-panel {
   position: absolute;
   top: 10px;
   left: 60%;
   z-index: 5;
   background-color: #fff;
   padding: 5px;
   text-align: center;
   font-family: 'Roboto','sans-serif';
   line-height: 30px;
   padding-left: 10px;
 }
</style>
<script type="text/javascript">
$(document).ready(function(){
	
	/* Modal 작동 */
	$('#ModelDisplayRow').show();
		
		/** 모델 클릭 시 모델 이름을 모달에 전달, 리뷰 세팅 */
		$('#detail_show').on('show.bs.modal', function(e) {
			var modelName = $(e.relatedTarget).data('model-name');
			window.e = $(e.currentTarget);
			console.log(car_model);
			window.e = $(e.currentTarget);
			$.ajax({	
				url:"<%=application.getContextPath()%>/model/detail.rent",
				dataType:"json",
				type:'POST', 
				data : {
		             'modelName' : modelName,
		             'weekday' : weekday,
		             'weekend' : weekend,
		             'startDate' : rent_start_date,
		             'endDate' : rent_end_date
		        },
				success:function(result){
					//$(e.currentTarget).html(result);
					setDetailModal(result);
				},
		        error : function(result) {
		        	console.log('error in openning detail show' + result);
		        }
			});
		});
});
function setReviewTab(name, reviewCount, page) {
	$('#new_review_tab').remove();
	var params = {
		page : page,
		reviewCount : reviewCount
	};
	var reviewTab = $('<div id="new_review_tab"></div>').load("<%=application.getContextPath()%>/rent/search_include/review_list.jsp", params);
	$("#review_tab_div").append(reviewTab);
	// 리뷰탭 리뷰 개수, 별 css 설정
	$('#review-list-count').html('(' + reviewCount + ' Review)');
	// 리뷰 목록 가져와서 설정
	getReviewList(name, 1, 10);
}

/**
 * 모델 디테일 정보를 표시하는 모달 setDetailModal의 정보를 model객체에서 가져와 설정하는 함수.
 * 위시리스트로 넘길 정보 :  model(name,picture,type,fueltype), startDate, endDate, amountMoney
 * 예약화면으로 넘길 정보 :  model, startDate, endDate, amountMoney, location
 */
function setDetailModal(model) {
	var amountMoney = model.weekdayPrice * weekday + 
					  model.weekendPrice * weekend;
	var imagePath = "../images/cars/"+model.type+"/"+model.picture;
	$('#detail-img').attr('src',imagePath);
	$('#detail-name').html(model.name);
	$('#detail-star').css('width', model.evalScore * 10 + '%');
	$('#detail-review-count').html('(' + model.reviewCount + ' Review)');
	$('#detail-amount-money').html('&#8361 '+ amountMoney);
	$('#detail-weekday-price').html(' ' + model.weekdayPrice + ' on Weekday');
	$('#detail-weekend-price').html(' ' + model.weekendPrice + ' on Weekend');
	$('#detail-wish-count').html(' ' + model.rentalCount + ' Times Added on Wish List');
	$('#detail-reserve-count').html(' ' + model.rentalCount + ' Times Reserved');
	$('#about-this-model').html('<p>'+ model.name +' 모델 차량은 '+ model.fuelType +' 타입 연료를 사용하는 차량으로 최대 '+model.seater+' 명의 승객이 탑승할 수 있습니다.</p>'+
			'<p>'+ model.name +' 모델의 주중 가격은 '+model.weekdayPrice+' 원입니다. 주말 가격은 '+model.weekendPrice+'원 입니다.</p>');
	
	var optionsHTML = '<p>주요 옵션은 아래와 같습니다.</p> <ul class="tg-liststyle">';
	optionsHTML += '<li><span>연비 : ' + model.fuelEfficiency + '</span></li>';
	optionsHTML += '<li><span>기어 : ' + model.transmission + '</span></li>';
	optionsHTML += '<li><span>연식 : ' + model.year + '</span></li>';
	if(model.navigation == 1) {
		optionsHTML += '<li><span>네비게이션</span></li>';
	}
	if(model.cameraRear == 1) {
		optionsHTML += '<li><span>후방카메라</span></li>';
	}
	if(model.highpass == 1) {
		optionsHTML += '<li><span>하이패스</span></li>';
	}
	if(model.blackBox == 1) {
		optionsHTML += '<li><span>블랙박스</span></li>';
	}
	optionsHTML += '</ul>';
	$('#important-options').html(optionsHTML);
	
	var otherOptionsHTML = "";
	if(model.options == null || model.options == "" || model.options.length == 0){
		otherOptionsHTML += '<li><span>기타 옵션이 없습니다.</span></li>';
	}
	else {
		var jbSplit = model.options.split(',');
		for ( var i in jbSplit ) {
			otherOptionsHTML += '<li><span>'+jbSplit[i]+'</span></li>'
		}
	}
	$('#car-detail-others').html(otherOptionsHTML);
	
	
	if('<%=request.getAttribute("loginId")%>' == 'null') {
		console.log('id null');
	}
	else {
		console.log('<%=request.getAttribute("loginId")%>');
		$('#wish-list-anchor').on('click', function(e) {
			e.stopPropagation();
			e.currentTarget.onclick = addToWishList(model.name, rent_start_date, rent_end_date, amountMoney, model.picture, model.type, model.fuelType);
		})
	}
	$('#go-reserve-anchor').on('click', function(e) {
		e.stopPropagation();
		e.currentTarget.onclick = goToReserve(rent_start_date, rent_end_date, amountMoney, pickupPlace, model.type, model.picture);
	})
}
/** 
 * 리뷰 리스트를 컨트롤러에 요청하여 가져오는 함수.
 * 
 */
function getReviewList(modelName, page, listSize) {
	$.ajax({	
		url:"<%=application.getContextPath()%>/review/list.rent",
		dataType:"json",
		type:'POST', 
		data : {
	  		modelName : modelName,
	  		page : page,
	  		listSzie : listSize
        },
		success:function(result){
			console.log("ok review list \n" + result);
			setReviewList(result);
		},
		error : function(result) {
			console.log("error.... result : " + result);
		}
	});
}

/**
 * 리뷰 리스트를 화면에 출력하는 함수 
 */
function setReviewList(list) {
	$("#each_review_ul").html("");
	for ( var i in list) {
		var params = {
			imgPath : '/sjrent/images/review/image1.jpg',
			userId : list[i].userId,
			evalScore : list[i].evalScore,
			date : list[i].date,
			content : list[i].content
		};
		var review = $('<li></li>').load("<%=application.getContextPath()%>/rent/search_include/review_each.jsp",
							params);
			$("#each_review_ul").append(review);
		}
}
</script>
</head>
<body onload="initMap();">

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
				<!--************************************
		             Detail Model Modal Start
		        *************************************-->
		         <jsp:include page="search_detail_list.jsp" />
		        <!--************************************
		             Detail Model Modal End
		        *************************************-->
				<div class="row">
					<div id="tg-twocolumns" class="tg-twocolumns">
						<div class="info_car" style="display: none">
							<jsp:include page="rent_detail.jsp"/>
						</div>
						
						<!-- 예약된 차 목록 보여주기 -->
						<form class="tg-formtheme tg-formtourpayment">
							<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 pull-left">
								<div id="tg-content" class="tg-content">
									<!-- 여태 렌트했던 목록들 띄우기 -->
									<c:forEach var="item" items="${list}" varStatus="status">
										<div class="tg-tourpaymentdetail" id="rentList" data-toggle='modal'data-target='#detail_show' data-model-name='<%=request.getParameter("modelName") %>'>
											<div class="tg-tourname">
												<a class="tg-btnedit" href="#">결제취소</a>
												<figure>
													<a><img src="../images/G70.jpg" style="width: 100px" height="auto" alt="image destinations"></a>
												</figure>
												<div class="tg-populartourcontent">
													<div class="tg-populartourtitle">
														<h3><a>${fn:split(item.picture,'.')[0]}</a></h3>
													</div>
													<div class="tg-populartourfoot form-control" style="background: inherit;" >
														<div class="tg-durationrating"></div>
														<span class="tg-tourduration">${item.startDate} ~ ${item.endDate}</span>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
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