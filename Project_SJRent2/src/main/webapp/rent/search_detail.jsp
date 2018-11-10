<%@page import="kr.or.kosta.sjrent.model.domain.Model"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
Model model = (Model)request.getAttribute("model");
String imagePath = "../images/cars/"+model.getType()+"/"+model.getPicture();
%>
<script>
/** 위시리스트에 저장 버튼이 눌렸을 때 Controller로 데이터를 보낸다.
	Controller로부터 받은 데이터를 검사한다.
*/
function addToWishList1() {
	$.ajax({	
		url:"<%=application.getContextPath()%>/wish/add.rent",
		dataType:"text",
		type:'POST', 
		data : {
             //'model_name' : modelName,
             //'weekday' : weekday,
             //'weekend' : weekend
        },
		success:function(result){
			// result 값에 따라 위시리스트에 저장했다고 알려주기
			//$(e.currentTarget).html(result);
		}
	});
}
/** 위시리스트에 저장 버튼이 눌렸을 때 Controller로 데이터를 보낸다.
Controller로부터 받은 데이터를 검사한다.
*/
function addToWishList2() {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", '<%=application.getContextPath()%>/rent/rent.rent');
 
    var params = {
  		startDate : '2018-11-15',
  		endDate : '2018-11-20',
  		insuranceNumber : '1',
  		pickupPlace : '인천 서구',
  		paidAmount : '50000',
  		paymentOption : '카드결제',
  		modelName : 'NIRO'
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
</script>
<!--************************************
		Rent_history Detail Start
*************************************-->
<div class="modal-dialog modal-lg">
	<div id = "tg-content" class="modal-content tg-content">	
		<div class="modal-body tg-tourbookingdetail">
		<div class="tg-tourbookingdetail">
			<div class="tg-bookinginfo" style="margin: 10px 0">
				<div class= "row">
					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-5">
						<img src='<%=imagePath %>' alt="image description">
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-7">
						<h2>${model.name}</h2>
						<div class="tg-durationrating">
							<span class='tg-stars'>
                              <span style='width: ${model.evalScore * 100}%'></span> 
                            </span>
                            <em>(${model.reviewCount} Review)</em> 
						</div>
						<div class="tg-pricearea">
							<span>총 금액</span>
							<h4>
								&#8361 ${model.weekdayPrice * weekday + model.weekendPrice * weekend }
							</h4>
						</div>
						<div class="tg-description">
							<p>There’s only 5 spot left. Join 19 others at Travelu’s
								experience this Saturday.</p>
						</div>
                        <div class="tg-description">
                          <ul class="my-tg-likeshare" >
                            <li><a href="javascript:void(0);"><i class="icon-heart"></i>Wish List</a></li>
                            <li><a href="<%=application.getContextPath()%>/rent/rent.jsp"><i class="icon-eye"></i>Reserve</a></li>
                          </ul>
                        </div>
					</div>
				</div>
				<ul class="tg-tripinfo">
					<li><span class="tg-tourduration">12 Days 11 Nights</span></li>
					<li><span class="tg-tourduration tg-availabilty">Availability
							May 12</span></li>
					<li><span class="tg-tourduration tg-location">San
							Francisco</span></li>
					<li><span class="tg-tourduration tg-peoples">24 People
							in Group</span></li>
				</ul>
				<div class="tg-refundshare">
					<div class="tg-refund">
						<figure>
							<img src="../images/img-03.jpg" alt="image description">
						</figure>
						<div class="tg-refundinfo">
							<h3>100% Refundable</h3>
							<div class="tg-description"> 
								<p>Cancel up to 72 days before your trip and get a full
									refund, including service fees.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="car_detail.jsp"></jsp:include>
		</div>
		</div>
	</div>
</div>
<!--************************************
		Rent_history Detail End
*************************************-->