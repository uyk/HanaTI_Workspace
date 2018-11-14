<%@page import="kr.or.kosta.sjrent.review.domain.Review"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
/**
 * 리뷰리스트를 받아오기위한 페이지
 */
 
String loginId = (String)request.getAttribute("loginId");
List<Review> reviewList = (List)request.getAttribute("reviewList");
%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" /><!-- fontawesome -->
<link rel="stylesheet"
  href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
  integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
  crossorigin="anonymous">

<style type="text/css">

.modal-backdrop {
  position: static;
}

</style>
<script type="text/javascript">

/**
 *  체크박스 다중 선택 방지를 위한 메소드
 */
function oneCheckbox(a){

    var obj = document.getElementsByName("reviewSeq");

    for(var i=0; i<obj.length; i++){

        if(obj[i] != a){

            obj[i].checked = false;
        }
    }
}

$(document).ready(function(){
	/* Modal 작동 */
	$('#ModelDisplayRow').show();
		
	/** 모델 클릭 시 모델 이름을 모달에 전달, 리뷰 세팅 */
	$('#detail_show').on('show.bs.modal', function(e) {
		var modelName = $(e.relatedTarget).data('model-name');
		window.e = $(e.currentTarget);
		$.ajax({	
			url:"<%=application.getContextPath()%>/model/detail.rent",
			dataType:"json",
			type:'POST', 
			data : {
	             'modelName' : modelName
	        },
			success:function(model){
				//$(e.currentTarget).html(result);
				setDetailModal(model);
				setReviewTab(model.name, model.reviewCount);
		        $('#location-tab-nav').remove();
		        $('#location').remove();
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
 */
function setDetailModal(model, id) {
	var imagePath = "../images/cars/"+model.type+"/"+model.picture;
	$('#detail-img').attr('src',imagePath);
	$('#detail-name').html(model.name);
	$('#detail-star').css('width', model.evalScore * 10 + '%');
	$('#detail-review-count').html('(' + model.reviewCount + ' Review)');
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
			imgPath : list[i].picture,
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
      <!--************************************
           Detail Model Modal Start
      *************************************-->
       <jsp:include page="../rent/search_detail_list3.jsp" />
      <!--************************************
           Detail Model Modal End
      *************************************-->
      <div class="row">
           <div class="tg-homebannerslider" class="tg-homebannerslider tg-haslayout">
              <div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
                 <div class="container"> 
                  <div class="tg-tabcontent tab-content" style="padding: 0px 350px;">
                     <div role="tabpanel" class="tab-pane active fade in" id="home">
                        <!--************************************
                                    Title 시작
                           *************************************-->
                         <div style="text-align: center; "><h2>MyReview</h2></div>
                        <!--************************************
                                    Title 종료
                           *************************************-->   
                           
                     </div>
                  </div>

							<!--************************************
                                    Content 시작 
                              *************************************-->
						<div>
                               <p style="text-align: center; ">
                              <%=loginId%>님 환영합니다. 
                              </p> 
                      	</div>
						<!--************************************
                                    MenuBar 시작 
                              *************************************-->
						<jsp:include page="menuBar.jsp" />
						<!--************************************
                                    MenuBar 종료 
                              *************************************-->
						
						


<!--***********     리뷰 리스트 시작      ****************-->

              <form action="/sjrent/review/delete.rent" method="get">
                <table role="tabpanel" class="tab-pane active fade in"
                  id="reviewList" style="width: 70%; margin-left: 250px">


                  <tr>
                    <th></th>
                    <th>모델명</th>
                    <th>제목</th>
                  </tr>

                  <%
                  	for (int i = 0; i < reviewList.size(); i++) {
                  %>
                  <tr>
                    <!-- checkbox에 해당된 리뷰 삭제  -->
                    <td><input type="checkbox" name="reviewSeq" onclick="oneCheckbox(this)" value="<%=reviewList.get(i).getNumber()%>"></td>
                    <td><%=reviewList.get(i).getModelName()%></td>
                    <td data-toggle='modal' data-target='#detail_show' data-model-name='<%=reviewList.get(i).getModelName() %>'><%=reviewList.get(i).getTitle()%></td>
                  </tr>
                  <%
                  	}
                  %>


                </table>

                <div style="text-align: center;">
                  <div
                    style="display: inline-block; vertical-align: middle; padding: 0px 10px; margin: 30px 0px 50px 0px;">
                    <button type="submit" class="tg-btn tg-btn-lg">
                      <span style="font-size: 14pt; width: 50%">삭제</span>
                    </button>
                  </div>
                </div>
              </form>


<!--***********     리뷰 리스트 종료      ****************-->
						

							<!--************************************
                                 Content 종료
                           *************************************-->

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