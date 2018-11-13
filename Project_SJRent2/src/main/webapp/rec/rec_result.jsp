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

.resultImg {
   	position: absolute;
   	top: 55%;
	left: 50%;
	transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	background-color: #d64161;
	color: white;
	font: bold; 
	font-size: 32px;
	padding: 10px;
	border: none;
	cursor: pointer;
	/* box-shadow: 0 9px #999; */ 
	/* border-radius: 50%; */
	text-align: center;
	height: 30%;
}

.resultImg:active {
	  background-color: #c94c4c;
	  box-shadow: 0 5px #666;
	  /* transform: translateY(4px); */
	}
	
.resultImg:hover {
background-color: #ff8080;
}
.in {
   background: rgba(0, 0, 0, 0.8);
}
.modal-backdrop{
   position: static;
}
</style>

<script>

   <%-- $(document).ready(function(){
	   var result = '초기값';
	   
		console.log('id : ' + '<%=request.getAttribute("loginId")%>');
		console.log('<%=request.getParameter("hidden")+","+request.getParameter("click")%>');
	      /** 모델 목록을 불러오는 search controller로 요청 전달 */
	      $.ajax({
	         type : "POST",
	          url : "<%=application.getContextPath()%>/model/recommend.rent",
	          async: false, 
	          data : {
	             'result' : '<%=request.getParameter("hidden")+","+request.getParameter("click")%>',
	          },
	          dataType: "json",
	          success: function(data){
				//console.log(data.modelName);
				//console.log(data.picture);
				//console.log(data.type);
				
				var type = data.type; 
				var picture = data.picture; 

				//console.log(typeof modelName);//string
				//console.log(typeof type);//string
				
				result = ("..images/" + type + "/" + picture).trim();
				console.log('ajax안에서  : ' + result);
				
				
	          }
	       });
		   return result;
	   }) --%>

   		/* 차 모델 이름 저장 */
   		var car_model;
   		
   		/* 예약 가능한 차 개수 */
   		var car_num;
   		
	   /** 이미지 경로 받아오기 */
	   function getImagePath() {
	   var result; 
	   	console.log('id : ' + '<%=request.getAttribute("loginId")%>');
		console.log('<%=request.getParameter("hidden")+","+request.getParameter("click")%>');
	   $.ajax({
	         type : "POST",
	          url : "<%=application.getContextPath()%>/model/recommend.rent",
	          async: false, 
	          data : {
	             'result' : '<%=request.getParameter("hidden")+","+request.getParameter("click")%>',
	          },
	          dataType: "json",
	          success: function(data){
				//console.log(data.modelName);
				//console.log(data.picture);
				//console.log(data.type);
				
				var type = data.type; 
				var picture = data.picture; 
				car_model = data.modelName;
				//console.log(typeof modelName);//string
				//console.log(typeof type);//string
				
				result = ("../images/cars/" + type + "/" + picture).trim();
				console.log('ajax안에서  : ' + result);
				
				
	          }
	       });
	   	   console.log("최종적으로 넘어가는 리절트: " + result);
	   	   return result; 
		}
   
	   	/* 차 시작 날짜 */
	 	var rent_start_date;
	   	
	   	/* 차 종료 날짜 */
	   	var rent_end_date;
	   	
	   	/* 차 가격 */
	   	var amountMoney;
	   	var weekdayPrice;
	   	var weekendPrice;
	   	
   		/** 시작하자마자 */
   		$(document).ready(function(){ 
			var imagePath = getImagePath(); 
   			//console.log('이미지경로 : '+ imagePath);
   			
			var resultCar = document.getElementById('resultCar');
   			resultCar.src = imagePath;
			//resultCar.src = "../images/K5.jpg";
   			console.log('11111111 : '+resultCar.src);
			//alert(resultCar.src);
			//console.log('어떤 값이 들어가지? ' + imagePath);
			//var resultImg = document.getElementsByClassName('resultImg'); 
   			
			/* DatePicker */
		   function setDisabledate(id, disabledDates, count){
			   /* var disabledDates = ['2018.11.18', '2018.11.14', '2018.11.20', '2018.11.24'] */
			   $("#datepicker"+id).datepicker({
				      onRenderCell: function(d, type) {
				    	    if (type == 'day') {
				    			var disabled = false,
				    	      	formatted = getFormattedDate(d);
				    	        disabled = disabledDates.filter(function(date){
				    	         return date == formatted;
				    	 	}).length
				    		return {
				    	          	disabled: disabled
				    	          }
				    	    }
				    	},
					   onSelect: function(selectedDate){
					          if(selectedDate.includes('~')){
					             start_date = new Date(selectedDate.split('~')[0]);
					             end_date = new Date(selectedDate.split('~')[1]);
					             for (var i = 0; i < disabledDates.length; i++) {
									var mustCheck = new Date(disabledDates[i]);
									if((mustCheck - start_date) > 0 && (end_date - mustCheck) > 0){
										alert('불가능한 날짜입니다.');
										$("#datepicker"+id).val('');
										return;
									}
								}
					             rent_start_date = formatDate(start_date);
					             rent_end_date = formatDate(end_date);
					             var startDay = start_date.getDate();
					             var date = ((end_date - start_date) / (1000*60*60*24))+1; 
					             var weekend = 0;
					             var weekday = 0;
					             /* 주말 주중 계산 */
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
					             amountMoney = weekdayPrice * weekday + weekendPrice * weekend;
					             /* 다른 것들도 초기화 */
					             for (var i = 1; i <= count; i++) {
					            	 if(id != i){
					            		 $("#datepicker"+i).val('');
					            	 }
								}
				             }
					  }
			   			
				   })
				   
				   $("#datepicker"+id).keydown(function (event) {
				       event.preventDefault();
				   })
					
			}
			/* Datepicker 불가능한 날짜 formatting */
		   function getFormattedDate(date) {
			   var year = date.getFullYear(),
			     month = date.getMonth() + 1,
			     date = date.getDate();
			     
			     return year + '.' + month + '.' + date;
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
			
			/* Modal 작동 */
			$('#ModelDisplayRow').show();
   			
   			/** 모델 클릭 시 모델 이름을 모달에 전달, 리뷰 세팅 */
   			$('#detail_show').on('show.bs.modal', function(e) {
   				console.log(car_model);
   				window.e = $(e.currentTarget);
   				$.ajax({	
   					url:"<%=application.getContextPath()%>/model/detailperiod.rent",
   					dataType:"json",
   					type:'POST', 
   					data : {
   			             'modelName' : car_model
   			        },
   					success:function(result){
   						var model = result.model;
   						car_num = result.period;
   						/* console.log(car_num); */
   						/* console.log(Object.keys(car_num).length); */
   						weekdayPrice = model.weekdayPrice;
   						weekendPrice = model.weekendPrice;
   						var i = 1;
   						setDetailModal(model, car_num);
   						for (var x in car_num) {
   							var disableDay = car_num[x];	
   							/* console.log(disableDay) */
   							setDisabledate(i++, disableDay,Object.keys(car_num).length);
						}
   					},
   			        error : function(result) {
   			        	console.log('error in openning detail show' + result);
   			        }
   				});
   			});
   			/**
   			 * 모델 디테일 정보를 표시하는 모달 setDetailModal의 정보를 model객체에서 가져와 설정하는 함수.
   			 * 위시리스트로 넘길 정보 :  model(name,picture,type,fueltype), startDate, endDate, amountMoney
   			 * 예약화면으로 넘길 정보 :  model, startDate, endDate, amountMoney, location
   			 */
   			function setDetailModal(model, car_num) {
   				var imagePath = "../images/cars/"+model.type+"/"+model.picture;
   				$('#detail-img').attr('src',imagePath);
   				$('#detail-name').html(model.name);
   				$('#detail-star').css('width', model.evalScore * 10 + '%');
   				$('#detail-review-count').html('(' + model.reviewCount + ' Review)');
   				/* 달력 가져오기 */
   				if(Object.keys(car_num).length >= 1){
	   				$('#showCalendar').html(
	   					'<div class="form-group-row" style="padding-bottom: 60px">' +
	                        '<div class = "col-md-2">'								+
	                           '<label>1번 차</label>'				+
	                        '</div>'												+
	                       '<div class = "col-md-8">'								+
	                        '<input type="text"'									+
	                              'id = "datepicker1"'								+
	                               'data-language="en"'								+
	                               'data-range="true"'								+
	                               'data-multiple-dates-separator="  ~  "'			+
	                               'placeholder="기간을 선택해 주세요"'				+
	                               'readonly 	'										+
	                               'class="datepicker-here form-control" required style="height: 50px" />' +
	                        '</div>'												+		
	                	'</div>'
	   				);
   				}
   				if(Object.keys(car_num).length > 1){
	   				for (var i = 2; i <= Object.keys(car_num).length; i++) {
		   				$('#showCalendar').append(
		   					'<div class="form-group-row" style="padding-bottom: 60px">' +
		                        '<div class = "col-md-2">'								+
		                           '<label>'+i+'번 차</label>'				+
		                        '</div>'												+
		                       '<div class = "col-md-8">'								+
		                        '<input type="text"'									+
		                              'id = "datepicker'+i+'"'				+
		                               'data-language="en"'								+
		                               'data-range="true"'								+
		                               'data-multiple-dates-separator="  ~  "'			+
		                               'placeholder="기간을 선택해 주세요"'				+
		                               'readonly 	'										+
		                               'class="datepicker-here form-control" required style="height: 50px" />' +
		                        '</div>'												+		
		                	'</div>'
		   				);
	   				}
   				}
   				
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
   				
   				// 리뷰 목록 가져와서 설정
   				getReviewList(model.name, 1, 10);
   				// 리뷰탭 리뷰 개수, 별 css 설정
   				$('#review-list-count').html('(' + model.reviewCount + ' Review)');
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
   					var review = $('<li></li>').load("<%=application.getContextPath()%>/rent/search_include/review_each.jsp", params);
   					$("#each_review_ul").append(review);
   				}
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
		}) 
		
		
   
</script> 
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
    <main id="tg-main" class="tg-main tg-sectionspace tg-haslayout">
    <div class="container">
   	 <!--************************************
             Detail Model Modal Start
        *************************************-->
         <jsp:include page="search_detail.jsp" />
        <!--************************************
             Detail Model Modal End
        *************************************-->
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
          style="padding: 0px 300px">
          <div class="tg-pkgplan" style="padding: 0px">

            <!--************************************
									Content 시작
							*************************************-->
							<img alt="여행선택지" src="../images/rec/rec_result.JPG">
							<img alt="추천자동차" src="" id="resultCar" class="resultImg" data-toggle='modal' data-target='#detail_show' data-model-name='<%=request.getParameter("modelName") %>' >	
							<span></span>
			<!-- ../images/cars/ASegment/2017K3.jpg  -->	
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

</body>
</html>