<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" />

<!-- datePicker -->
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/css/datepicker.min.css"
  type="text/css">
<script src="<%=application.getContextPath()%>/js/datepicker.min.js"></script>
<script src="<%=application.getContextPath()%>/js/datepicker.en.js"></script>
<!-- fontawesome -->
<link rel="stylesheet"
  href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
  integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
  crossorigin="anonymous">
<style type="text/css">
.in {
	background: rgba(0, 0, 0, 0.8);
}

.modal-backdrop {
	position: static;
}

.tg-widget {
	border: 1px solid black;
	padding: 10px;
	padding-top: 30px;
}

.tg-widgettitle {
	padding: 0px;
}

.tg-listing .tg-populartour, .tg-listing .tg-trendingtrip {
	padding: 10px 5px 5px;
}
</style>
<script type="text/javascript">
var rent_start_date = null;
var rent_end_date = null;
var date;
var weekday = 0;
var weekend = 0;

/**
 * search.jsp가 로드될 때 실행되는 함수
 */
$(document).ready(function(){
	console.log('id : ' + '<%=request.getAttribute("loginId")%>');
	// 검색된 모델과 랭킹을 시작할 때는 표시 안하게
	$('#ModelDisplayRow').hide();
	
	/** DatePickerEvent등록*/
	registDatePickerEvent();

	/** 검색버튼 이벤트 등록 */
	registSearchSubmit();
});

/** datepicker 이벤트 발생 처리*/
function registDatePickerEvent() {
	/* DatePicker */
    $("#datepicker").datepicker({
      minDate: new Date(),
       onSelect: function(selectedDate){
          if(selectedDate.includes('~')){
             rent_start_date = new Date(selectedDate.split('~')[0]);
             rent_end_date = new Date(selectedDate.split('~')[1]);
             date = ((rent_end_date - rent_start_date) / (1000*60*60*24))+1; 
          }else{
             rent_start_date = selectedDate;
             rent_end_date = selectedDate;
             date = 1;
          }
             $('#total-time').val(date+'일 ('+date*24+'시간)'); 
             rent_start_date = formatDate(rent_start_date);
             rent_end_date = formatDate(rent_end_date);
       }
   })
   
   $("#datepicker").keydown(function (event) {
       event.preventDefault();
   })
}

/** datepicker에서 선택된 날짜를 필요한 형식으로 변환하는 함수 */
function formatDate(date){
 	var d = new Date(date),
     month = '' + (d.getMonth() + 1),
     day = '' + d.getDate(),
     year = d.getFullYear();
 	
 	if (month.length < 2) month = '0' + month;
 	if (day.length < 2) day = '0' + day;
 	return [year, month, day].join('-');
 }
 
/** 검색버튼 이벤트 */
 function registSearchSubmit() {
	 $('#showCarList').submit(function(e) {
	    e.preventDefault();
	    if (rent_start_date == null) {
	        alert('날짜를 선택해주세요');
	        return;
	    }
	    var modelParams = {
            'rent_start_date': rent_start_date,
            'rent_end_date': rent_end_date
	    }
	    getModelTypeOption(modelParams);
	    getOtherOptions(modelParams);
	    /** 모델 목록을 불러오는 search controller로 요청 전달 */
	    $.ajax({
	        type: "POST",
	        url: "<%=application.getContextPath()%>/model/search.rent",
	        data: modelParams,
	        dataType: "json",
	        success: function(data) {
	            setModelList(data);
	        }
	    });

	    /** 랭킹 목록을 불러오는 poularController로 요청 전달. html로 받아서 표시*/
	    $.ajax({
	        url: "<%=application.getContextPath()%>/model/popular.rent",
	        type: 'GET',
	        success: function(result) {
	            $("#rank-list").html(result);
	        }
	    });
	    
	});
}

/**
 *  모델 타입 옵션을 검사해 modelParams에 설정하는 함수
 */
function getModelTypeOption(modelParams) {
	var model_type = $('.selectpicker[title=차종]').val();
	console.log(model_type);
    var type_name;
    switch (model_type) {
        case '소형':
            type_name = 'ASegment';
            break;
        case '중형':
            type_name = 'DSegment';
            break;
        case '대형':
            type_name = 'ESegment';
            break;
        case 'SUV':
            type_name = 'JSegment';
            break;
        case '승합':
            type_name = 'MSegment';
            break;
        case '외제차':
            type_name = 'SSegment';
            break;
        default:
            type_name = 'all';
            break;
    }
    modelParams.model_type = type_name;
}

/**
 *  기타 옵션의 값을 검사해 modelParams에 설정하는 함수
 */
function getOtherOptions(modelParams) {
	var navigation = $('input[name=navigation]').is(":checked");
	var cameraRear = $('input[name=cameraRear]').is(":checked");
	var highpass = $('input[name=highpass]').is(":checked");
	var blackBox = $('input[name=blackBox]').is(":checked");
	var fuelType = $('.selectpicker[title=연료]').val();
	var transmission = $('.selectpicker[title=기어]').val();
	var seater = $('.selectpicker[title=인승]').val();
	
	/** 체크되어있으면 1 검색, 체크 안되어있으면 전체검색 */
	if(navigation) {
		modelParams.navigation = 1;
	}
	if(cameraRear) {
		modelParams.cameraRear = 1;
	}
	if(highpass) {
		modelParams.highpass = 1;
	}
	if(blackBox) {
		modelParams.blackBox = 1;
	}
	if(fuelType && fuelType != '전체') {
		modelParams.fuelType = fuelType;
	}
	if(transmission && transmission != '전체') {
		modelParams.transmission = transmission;
	}
	if(seater && seater != '전체') {
		modelParams.seater = seater;
	}
}

/** list의 모델들을 html로 추가하는 함수 */
function setModelList(list) {
	var startDay = new Date(rent_start_date).getDay();
	var end = new Date(rent_end_date).getDay();
	$("#carListRow").html("");
	
	// 주말, 주중 계산
	for(var i = 0; i < date; i++) {
		if(startDay == 0 || startDay == 6) {
			weekend++;
		}
		else {
			weekday++;
		}
		startDay++;
		if(startDay == 7) startDay = 0;
	}
	
	for ( var i in list) {
		var desc = '<p>'+list[i].fuelType +' 타입 연료를 사용하는 차량으로 최대 '+list[i].seater+' 명의 승객이 탑승할 수 있습니다.</p>'+
		'<p>'+'주중 가격은 '+list[i].weekdayPrice+'원, 주말 가격은 '+list[i].weekendPrice+'원 입니다.</p>';
		
		var params = {
			imgPath : '/sjrent/images/cars/'+list[i].type+'/'+list[i].picture,
			modelName : list[i].name,
			desc : desc,
			weekday : weekday,
			weekend : weekend,
			weekdayPrice : list[i].weekdayPrice,
			weekendPrice : list[i].weekendPrice,
			starPercent : list[i].evalScore * 10,
			reviewCount : list[i].reviewCount
		};
		var model = $('<div></div>').load("<%=application.getContextPath()%>/rent/search_include/search_each.jsp", params);
		$("#carListRow").append(model);
	}	//for 끝
	
	$('#ModelDisplayRow').show();
	//location.href='#tg-main';

    var scrollPosition = $("#tg-main").offset().top;
    $("html, body").animate({
    	scrollTop: scrollPosition
    }, 300, function () {
		console.log('aa');
	});
	
	/** 모델 클릭 시 모델 이름을 모달에 전달, 리뷰 세팅 */
	$('#detail_show').on('show.bs.modal', function(e) {
		var modelName = $(e.relatedTarget).data('model-name');
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
			success:function(model){
				//$(e.currentTarget).html(result);
				setDetailModal(model);
				// detail패널의 car_detail의 review 탭 설정
				setReviewTab(model.name, model.reviewCount);
			},
	        error : function(result) {
	        	console.log('error in openning detail show' + result);
	        }
		});
	});
}

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
		e.currentTarget.onclick = goToReserve(rent_start_date, rent_end_date, amountMoney, '방문수령', model.type, model.picture);
	})
}
/** 
 * <위시리스트에 저장> 버튼이 눌렸을 때 Controller로 데이터를 보내는 함수.
 *	Controller로부터 받은 데이터를 검사한다.
 */
function addToWishList(modelName, startDate, endDate, amountMoney, picture, type, fuelType) {
	$.ajax({	
		url:"<%=application.getContextPath()%>/wishitem/add.rent",
		dataType:"text",
		type:'POST', 
		data : {
	  		modelName : modelName,
	  		startDate : startDate,
	  		endDate : endDate,
	  		amountMoney : amountMoney,
	  		picture : picture,
	  		type : type,
	  		fuelType : fuelType
        },
		success:function(result){
			// result 값에 따라 위시리스트에 저장했다고 알려주기
			if($.trim(result) == 'success') {
				$('#wish_result_modal_body').html('위시리스트에 담았습니다. 위시리스트로 이동하겠습니까?');
			}
			else {
				$('#wish_result_modal_body').html('위시리스트에 담지 못했습니다. 위시리스트로 이동하겠습니까?');
			}
			$("#wish_result_modal").modal('show');
		}
	});
}

/** 
 * 위시리스트 추가 결과 모달을 숨기는 함수.
 * 위시리스트 추가 결과 모달에서 'not now' 버튼을 누르면 실행
 */
function wishResultHide() {
	$("#wish_result_modal").modal('hide');
}

/**
 * 예약 버튼이 눌렸을 때 Controller로 데이터를 보내는 함수.
 */
 function goToReserve(startDate, endDate, amountMoney, pickupPlace, type, picture) {
	// 로그인 중
	if( '<%=request.getAttribute("loginId")%>' != 'null'){
		// post로 데이터 전달
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", '<%=application.getContextPath()%>/rent/page.rent');
	 
	    var params = {
		  		startDate : startDate,
		  		endDate : endDate,
		  		amountMoney : amountMoney,
		  		pickupPlace : pickupPlace,
		  		type : type,
		  		picture : picture
	    }
	    
	    //히든으로 값을 주입시킨다.
	    for(var key in params) {
	        var hiddenField = document.createElement("input");
	        hiddenField.setAttribute("type", "hidden");
	        hiddenField.setAttribute("name", key);
	        hiddenField.setAttribute("value", params[key]);
	        form.appendChild(hiddenField);
	    }
	    document.body.appendChild(form);
	    form.submit();
	}
	else {
		//alert('로그인필요');
		$("#login_modal").modal('show');
	}
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

<title>SJ 렌트카 - 실시간예약</title>
</head>
<body>
  <!--************************************
         Mobile Menu Start
   *************************************-->

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
    <jsp:include page="/rent/search_include/search_header.jsp" />
    <!--************************************
               Header End
         *************************************-->
    <!--************************************
               Inner Banner Start
         *************************************-->
    <%--
      <jsp:include page="/rent/search_include/search_banner.jsp"/>
       --%>
    <div class="tg-homebannerslider"
      class="tg-homebannerslider tg-haslayout">
      <div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
        <figure class="item"
          data-vide-bg="poster: ../images/slider/img-02.jpg"
          data-vide-options="position: 50% 50%">
          <figcaption>
            <div class="container">
              <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                  <form id="showCarList"
                    class="tg-formtheme tg-formtrip"
                    action="<%=application.getContextPath()%>/model/search.rent"
                    method="get">
                    <fieldset>
                      <div class="row">
                        <div class="form-group-row col-md-8">
                          <div class="col-md-8">
                            <input type="text" id="datepicker"
                              data-language="en" data-range="true"
                              data-multiple-dates-separator="  ~  "
                              placeholder="기간을 선택해 주세요" readonly
                              class="datepicker-here form-control"
                              required style="height: 50px" />
                          </div>
                          <div class="col-md-4">
                            <!-- 총 시간 입력 -->
                            <input type="text" id="total-time"
                              class="form-control" readonly="readonly"
                              style="height: 50px">
                          </div>
                        </div>
                        <div class="form-group col-md-4">
                          <div class="tg-select">
                            <select class="selectpicker"
                               data-width="100%"
                              title="차종">
                              <option data-tokens="all">전체</option>
                              <option data-tokens="ASegment">소형</option>
                              <option data-tokens="DSegment">중형</option>
                              <option data-tokens="ESegment">대형</option>
                              <option data-tokens="JSegment">승합</option>
                              <option data-tokens="MSegment">SUV</option>
                              <option data-tokens="SSegment">외제차</option>
                            </select>
                          </div>
                        </div>
                        <div class="form-group">
                          <button class="tg-btn" type="submit">
                            <span>렌트카 찾기</span>
                          </button>
                        </div>
                      </div>
                    </fieldset>

                    <!-- 체크박스 시작 -->
                    <fieldset class='row'
                      style='padding-right: 0px; margin-top: 20px;'>
                      <form>
                        <div class="checkbox-inline">
                          <label class="checkbox-label"> <input
                            type="checkbox" name="navigation"> <span
                            class="label-text">네비게이션</span>
                          </label>
                        </div>
                        <div class="checkbox-inline">
                          <label class="checkbox-label"> <input
                            type="checkbox" name="cameraRear"> <span
                            class="label-text">후방카메라</span>
                          </label>
                        </div>
                        <div class="checkbox-inline">
                          <label class="checkbox-label"> <input
                            type="checkbox" name="highpass"> <span
                            class="label-text">하이패스</span>
                          </label>
                        </div>
                        <div class="checkbox-inline">
                          <label class="checkbox-label"> <input
                            type="checkbox" name="blackBox"> <span
                            class="label-text">블랙박스</span>
                          </label>
                        </div>
                        <select data-width='130px' title="연료"
                          class="selectpicker">
                          <option data-tokens="all">전체</option>
                          <option data-tokens="LPG">LPG</option>
                          <option data-tokens="디젤">디젤</option>
                          <option data-tokens="가솔린">가솔린</option>
                        </select>
                        <select data-width='100px' title="기어"
                          class="selectpicker">
                          <option data-tokens="all">전체</option>
                          <option data-tokens="수동">수동</option>
                          <option data-tokens="자동">자동</option>
                        </select>
                        <select data-width='100px' title="인승"
                          class="selectpicker">
                          <option data-tokens="all">전체</option>
                          <option data-tokens="5">5</option>
                          <option data-tokens="7">7</option>
                          <option data-tokens="9">9</option>
                          <option data-tokens="11">11</option>
                        </select>
                      </form>
                    </fieldset>
                  </form>
                </div>
              </div>
            </div>
          </figcaption>
        </figure>
      </div>
    </div>
    <!--************************************
               Inner Banner End
      *************************************-->

    <!--************************************
            Main Start
      *************************************-->
    <main id="tg-main"
      class="tg-main tg-sectionspace tg-haslayout tg-bglight">
    <div class="container" style="width: 90%">
      <!--************************************
              Detail Model Modal Start
         *************************************-->
      <jsp:include page="/rent/search_detail.jsp" />
      <!--************************************
              Detail Model Modal End
         *************************************-->

      <!--************************************
              Wish Result Modal Start
         *************************************-->
      <jsp:include page="/rent/search_include/wish_result_modal.jsp" />
      <!--************************************
              Wish Result Modal End
         *************************************-->

      <!--************************************
              Search Login Modal Start
         *************************************-->
      <jsp:include page="/rent/search_include/search_login_modal.jsp" />
      <!--************************************
              Search Login Modal End
         *************************************-->

      <div class="row" id="ModelDisplayRow">
        <div id="tg-twocolumns" class="tg-twocolumns">
          <div class="col-xs-12 col-sm-9 col-md-9 col-lg-9 pull-left">
            <div id="tg-content" class="tg-content">
              <div class="tg-listing tg-listingvone">
                <%--
                        <div class="tg-sectiontitle" style="padding-bottom: 20px">
                           <h2>렌트카</h2>
                        </div>
                        <div class="clearfix"></div>
                     --%>
                <!--************************************
                               Model List Start
                         *************************************-->
                <div class="row" id="carListRow"></div>
                <!--************************************
                               Model List End
                         *************************************-->
              </div>
            </div>
          </div>
          <!--************************************
                     Ranking Start
               *************************************-->
          <div id="rank-list"></div>
          <!--************************************
                     Ranking End
               *************************************-->
        </div>
      </div>
    </div>
    </main>
    <!--************************************
            Main End
      *************************************-->
  </div>
  <!--************************************
               Login method
   *************************************-->

  <jsp:include page="/rent/search_include/search_login.jsp" />


</body>
</html>