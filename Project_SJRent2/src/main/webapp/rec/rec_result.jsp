<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" />

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
   			
			/* Modal 작동 */
			$('#ModelDisplayRow').show();
   			
   			/** 모델 클릭 시 모델 이름을 모달에 전달, 리뷰 세팅 */
   			$('#detail_show').on('show.bs.modal', function(e) {
   				console.log(car_model);
   				window.e = $(e.currentTarget);
   				$.ajax({	
   					url:"<%=application.getContextPath()%>/model/detail.rent",
   					dataType:"json",
   					type:'POST', 
   					data : {
   			             'modelName' : car_model
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
   			/**
   			 * 모델 디테일 정보를 표시하는 모달 setDetailModal의 정보를 model객체에서 가져와 설정하는 함수.
   			 * 위시리스트로 넘길 정보 :  model(name,picture,type,fueltype), startDate, endDate, amountMoney
   			 * 예약화면으로 넘길 정보 :  model, startDate, endDate, amountMoney, location
   			 */
   			function setDetailModal(model) {
   				var imagePath = "../images/cars/"+model.type+"/"+model.picture;
   				$('#detail-img').attr('src',imagePath);
   				$('#detail-name').html(model.name);
   				$('#detail-star').css('width', model.evalScore * 10 + '%');
   				$('#detail-review-count').html('(' + model.reviewCount + ' Review)');
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