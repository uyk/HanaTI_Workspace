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
   			  	/** 리뷰 탭 클릭시 getReviewList 시작 */
   			  	/** 
   			  	$('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
   			  		//e.target // newly activated tab
   			  		//e.relatedTarget // previous active tab
   			  		console.log(e.target.getAttribute('aria-controls'));
   			  		if(e.target.getAttribute('aria-controls') == 'review') {
   			  			getReviewList(modelName, 1, 10)
   			  		}
   			  	});
   			  	*/
   			});
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
         <jsp:include page="/rent/search_detail.jsp" />
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
							<img alt="추천자동차" src="" id="resultCar" class="resultImg">	
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