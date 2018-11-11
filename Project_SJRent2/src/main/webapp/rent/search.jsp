<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" />

<!-- datePicker -->
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/datepicker.min.css" type="text/css">
<script src="<%=application.getContextPath()%>/js/datepicker.min.js"></script>
<script src="<%=application.getContextPath()%>/js/datepicker.en.js"></script>
<style type="text/css">
.in {
   background: rgba(0, 0, 0, 0.8);
}
.modal-backdrop{
   position: static;
}
.tg-widget{
   border: 1px solid black;
   padding : 10px;
   padding-top: 30px;
}
.tg-widgettitle{
   padding: 0px;
}
.tg-listing .tg-populartour, .tg-listing .tg-trendingtrip{
   padding: 10px 5px 5px;
}
</style>
<script type="text/javascript">
var rent_start_date;
var rent_end_date;
var date;
var weekday = 0;
var weekend = 0;
$(document).ready(function(){
	console.log('id : ' + '<%=request.getAttribute("loginId")%>');
	// 검색된 모델과 랭킹을 시작할 때는 표시 안하게
	$('#ModelDisplayRow').hide();
	
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
   
   /** 검색버튼이 클릭됨 */
   $('#showCarList').submit(function(e) {
       e.preventDefault();
      var model_type = $('.selectpicker').val();
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
      /** 모델 목록을 불러오는 search controller로 요청 전달 */
      $.ajax({
         type : "POST",
         url : "<%=application.getContextPath()%>/model/search.rent",
         data : {
            'rent_start_date' : rent_start_date,
            'rent_end_date' : rent_end_date,
            'model_type' : type_name
         },
         dataType: "json",
         success: function(data){
           	setModelList(data);
         }
      });
      
      /** 랭킹 목록을 불러오는 poularController로 요청 전달. html로 받아서 표시*/
    	$.ajax({	
    		url:"<%=application.getContextPath()%>/model/popular.rent",
    		dataType:"html",
    		type:'GET', 
    		success:function(result){
    			$("#rank-list").html(result);
    		}
    	});
      
   });
   
});
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
 
/** list의 모델들을 html로 추가하는 함수 */
function setModelList(list) {
	var startDay = new Date(rent_start_date).getDay();
	var end = new Date(rent_end_date);
	var output = "";
	
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
		output += "" + 
		"                           <div class=\"col-xs-6 col-sm-6 col-md-4 col-lg-4\" data-toggle=\"modal\" data-target=\"#detail_show\" data-model-name='"+list[i].name+"'>\r\n" + 
		"                              <div class=\"tg-populartour\"   >\r\n" + 
		"                                 <figure>\r\n" + 
		"                                    <a><img\r\n" + 
		"                                       src=\"../images/cars/"+list[i].type+"/"+list[i].picture+"\" alt=\"image destinations\"></a>\r\n" + 
		"                                 </figure>\r\n" + 
		"                                 <div class=\"tg-populartourcontent\">\r\n" + 
		"                                    <div class=\"tg-populartourtitle\">\r\n" + 
		"                                       <h3>\r\n" + 
		"                                          <a class=\"car_detail\">"+ list[i].name +"</a> \r\n" + 
		"                                       </h3>\r\n" + 
		"                                    </div>\r\n" + 
		"                                    <div class=\"tg-description\" style=\"height: 150px;\">\r\n" + 
		"                                       <p>"+ list[i].options +"</p>\r\n" + 
		"                                    </div>\r\n" + 
		"                                    <div class=\"tg-populartourfoot\">\r\n" + 
		"                                       <div class=\"tg-durationrating\">\r\n" + 
		"                                          <span class=\"tg-tourduration tg-availabilty\"> weekday "+list[i].weekdayPrice+"&#8361<br/>weekend "+list[i].weekendPrice+"&#8361</span>" + 
		"										   <span class=\"tg-stars\">"+
		"											  <span style=\"width: "+list[i].evalScore*10+"%\"></span>" + 
		"										   </span>\r\n" + 
		"                                          <em>(3 Review)</em>\r\n" + 
		"                                       </div>\r\n" + 
		"                                       <div class=\"tg-pricearea\">\r\n" + 
		"                                          <h4>"+ (list[i].weekdayPrice * weekday + list[i].weekendPrice * weekend)  +"</h4>\r\n" + 
		"                                       </div>\r\n" + 
		"                                    </div>\r\n" + 
		"                                 </div>\r\n" + 
		"                              </div>\r\n" + 
		"                           </div>\r\n";
		$("#carListRow").html(output);
	}	//for 끝
	
	$('#ModelDisplayRow').show();
	
	/** 모델 클릭 시 모델 이름을 모달에 전달 */
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
			success:function(result){
				//$(e.currentTarget).html(result);
				setDetailModal(result);
			},
	        error : function(result) {
	        	console.log('error in openning detail show' + result);
	        }
		});
	});
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
}
/** 
 * <위시리스트에 저장> 버튼이 눌렸을 때 Controller로 데이터를 보낸다.
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
 * 리뷰 리스트를 가져오는 함수.
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
	for ( var i in list) {
		var params = {
			imgPath : '/sjrent/images/review/image1.jpg',
			userId : list[i].userId,
			evalScore : list[i].evalScore,
			date : list[i].date,
			content : list[i].content
		};
		var review = $('<li></li>').load("<%=application.getContextPath()%>/rent/search_include/review_each_sample.jsp", params);
		$("#each_review_ul").append(review);
		console.log(i + " : " + list[i].date);
	}
}
</script>
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
      <jsp:include page="/rent/search_include/search_header.jsp"/>
      <!--************************************
               Header End
         *************************************-->
      <!--************************************
               Inner Banner Start
         *************************************-->
         
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
                           <form id = "showCarList" class="tg-formtheme tg-formtrip" action="<%=application.getContextPath()%>/model/search.rent" method="get">
                              <fieldset>
                                 <div class="row">
                                    <div class="form-group-row col-md-8">
                                    <div class = "col-md-8">
                                    <input type="text"
                                          id = "datepicker"
                                           data-language="en"
                                           data-range="true"
                                           data-multiple-dates-separator="  ~  "
                                           placeholder="기간을 선택해 주세요"
                                           readonly 
                                           class="datepicker-here form-control" required style="height: 50px" />
                                    </div>
                                    <div class = "col-md-4">
                                       <!-- 총 시간 입력 -->
                                       <input type = "text" id = "total-time" class="form-control" readonly="readonly" style="height: 50px">
                                    </div>
                                    </div>
                                 <div class="form-group col-md-4">
                                    <div class="tg-select" style="padding-left: 15px">
                                       <select class="selectpicker" data-live-search="true"
                                          data-width="100%" title="차종">
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
      <main id="tg-main" class="tg-main tg-sectionspace tg-haslayout tg-bglight">
      <div class="container" style="width: 90%">
         <!--************************************
              Detail Modal Start
         *************************************-->
         <jsp:include page="/rent/search_detail.jsp" />
         <!--************************************
              Detail Modal End
         *************************************-->
         
         <!--************************************
              Wish Result Modal Start
         *************************************-->
         <jsp:include page="/rent/search_include/wish_result_modal.jsp" />
         <!--************************************
              Wish Result Modal End
         *************************************-->
         <div class="row" id="ModelDisplayRow">
            <div id="tg-twocolumns" class="tg-twocolumns">
               <div class="col-xs-12 col-sm-9 col-md-9 col-lg-9 pull-left">
                  <div id="tg-content" class="tg-content">
                     <div class="tg-listing tg-listingvone">
                        <div class="tg-sectiontitle" style="padding-bottom: 20px">
                           <h2>렌트카</h2>
                        </div>
                        <div class="clearfix"></div>
                        <!--************************************
                               Model List Start
                         *************************************-->
                        <div class="row" id="carListRow">
                        </div>
                        <!--************************************
                               Model List End
                         *************************************-->
                     </div>
                  </div>
               </div>
               <!--************************************
                     Ranking Start
               *************************************-->
               <div id="rank-list"> </div>
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
   <jsp:include page="/rent/search_include/search_login.jsp"/>

</body>
</html>