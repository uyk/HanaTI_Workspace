<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" />
<!-- fontawesome -->
<link rel="stylesheet"
  href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
  integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
  crossorigin="anonymous">
<style type="text/css">
.in {
   background: rgba(0, 0, 0, 0.8);
}
.modal-backdrop{
   position: static;
}
</style>
<script type="text/javascript">

var modelNamesList=[];
var modelTypesList=[];
<%
String modelNames = request.getAttribute("modelNames").toString();
String modelTypes = request.getAttribute("modelTypes").toString();
String[] modelNameList = modelNames.substring(1,modelNames.length()-1).split(",");
String[] modelTypeList = modelTypes.substring(1,modelTypes.length()-1).split(",");
for(int i = 0; i < modelNameList.length; i++){
  modelNameList[i].trim();
}
for(int i = 0; i < modelNameList.length; i++){
	%>
	modelNamesList.push('<%=modelNameList[i].trim()%>')
	modelTypesList.push('<%=modelTypeList[i].trim()%>')
<%	
}
%>
/* console.log(modelNamesList); */
$(document).ready(function(){
	<%-- console.log(<%=modelNames.length()%>); --%>
	if(<%=modelNames.length()%> == 2){
		$('#notList').append("<h3>예약 내역이 존재하지 않습니다.</h3>");
	}else{
	  for (var i = 1; i <= modelNamesList.length; i++) {
	    document.getElementById('modelName'+i).innerHTML = '<h3>'+modelNamesList[i-1]+'</h3>';
	    document.getElementById('rentList'+i).setAttribute('data-model-name', modelNamesList[i-1]);
	    document.getElementById('carImg'+i).setAttribute('src', '../images/cars/'+modelTypesList[i-1]+"/"+modelNamesList[i-1]+".jpg");
	    /* console.log(modelNamesList[i-1]); */
	 }
}
	
  /* Modal 작동 */
  $('#ModelDisplayRow').show();
    
  /** 모델 클릭 시 모델 이름을 모달에 전달, 리뷰 세팅 */
  $('#detail_show').on('show.bs.modal', function(e) {
    var modelName = $(e.relatedTarget).data('model-name');
    window.e = $(e.currentTarget);
    var id = $(e.relatedTarget).data('model-num');
    console.log(id);
    $.ajax({  
      url:"<%=application.getContextPath()%>/model/detail.rent",
      dataType:"json",
      type:'POST', 
      data : {
               'modelName' : modelName
          },
      success:function(model){
        console.log(model);
        setDetailModal(model, id);
        setReviewTab(model.name, model.reviewCount);
        $('#location-tab-nav').remove();
        $('#location').remove();
      },
          error : function(result) {
            console.log('error in openning detail show' + result);
          }
    });
  });
  
  /** 디테일 모달이 닫힐 때 */
  $('#detail_show').on('hidden.bs.modal', function (e) {
    pickupPlace = "방문수령"; 
    detailModel = null;
  })
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
 */
function setDetailModal(model, id) {
  var imagePath = "../images/cars/"+model.type+"/"+model.picture;
  $('#detail-img').attr('src',imagePath);
  $('#detail-name').html(model.name);
  $('#detail-star').css('width', model.evalScore * 10 + '%');
  $('#detail-review-count').html('(' + model.reviewCount + ' Review)');
  $('#detail-weekday-price').html(' ' + model.weekdayPrice + ' on Weekday');
  $('#detail-weekend-price').html(' ' + model.weekendPrice + ' on Weekend');
  $('#getModelName').val(document.getElementById('rentList'+id).getAttribute('data-model-name'));
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
 /* 리뷰 작성  */
/*function addReview(){
  $('#addReviewForm').submit();
} */


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
				<!--************************************
		             Detail Model Modal Start
		        *************************************-->
		         <jsp:include page="search_detail_list.jsp" />
		        <!--************************************
		             Detail Model Modal End
		        *************************************-->
				<div class="row">
					<div id="tg-twocolumns" class="tg-twocolumns">
						
						<!-- 예약된 차 목록 보여주기 -->
						<form class="tg-formtheme tg-formtourpayment">
							<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 pull-left">
								<div id="tg-content" class="tg-content">
									<span id= "notList"></span>
									<!-- 여태 렌트했던 목록들 띄우기 -->
									<c:forEach var="item" items="${list}" varStatus="status">
										<div class="tg-tourpaymentdetail" id="rentList${status.count}" class="listRent" data-toggle='modal' data-target='#detail_show' data-model-name="" data-model-num="${status.count}">
											<div class="tg-tourname" style="padding:20px;">
												<!--  결제 완료된 것만 -->
												<a class="tg-btnedit" href="<%=application.getContextPath() %>/rent/cancel.rent?rentSeq=${item.seq}" style="padding:20px;">예약취소</a>
												<figure>
													<a><img id="carImg${status.count}" style="width: 100px" height="auto" alt="image destinations"></a>
												</figure>
												<div class="tg-populartourcontent">
													<div class="tg-populartourtitle" id="modelName${status.count}">
													</div>
													<div class="tg-populartourfoot form-control" style="background: inherit;" >
														<div class="tg-durationrating">
														<span class="tg-tourduration tg-availabilty" style="position: absolute;"><span>${fn:split(item.startDate,' ')[0]}</span> ~ <span>${fn:split(item.endDate,' ')[0]}</span></span></div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
							<% if(modelNames.length() != 2){ %>
							<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 pull-right">
								<aside id="tg-sidebar" class="tg-sidebar">
									<div class="tg-widget tg-widgettourinfo">
										<div class="tg-widgetcontent">
											<ul>
												<li><span>예약자</span><em><%=request.getAttribute("loginId") %></em></li>
												<li><span>예약 횟수</span><em><%= modelNameList.length%>회</em></li>
												<li><span></span><em></em></li>
												<!-- <li class="tg-couponapply">
													<div class="form-group">
														<div class="row" style="height:40px;"></div>
															<button id = "info_detail" class="tg-btn">상세보기</button>
													</div>
												</li> -->
											</ul>
										</div>
									</div>
								</aside>
							</div>
							<%} %>
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