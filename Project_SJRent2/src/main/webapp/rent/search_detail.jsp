<%@page import="kr.or.kosta.sjrent.model.domain.Model"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<%-- Model정보를 출력하는 jsp (search.jsp에 include됨)
     컨트롤러로 부터 받은 정보 : model, startDate, endDate, weekday, weekend
     위시리스트로 넘길 정보 :  model(name,picture,type,fueltype), startDate, endDate, amountMoney
     예약화면으로 넘길 정보 :  model, startDate, endDate, amountMoney, location
 --%>
 
<% 
Model model = (Model)request.getAttribute("model");
int amountMoney = 0;
if(model == null) {
  System.out.println("null model"); 
  model = new Model();
  model.setEvalScore(10.0);
  model.setFuelType("testFT");
  model.setName("testName");
  model.setPicture("NIRO.jpg");
  model.setReviewCount(5);
  model.setType("JSegment");
  model.setWeekdayPrice(50000);
  model.setWeekendPrice(100000);
  
}
else {
  amountMoney = model.getWeekdayPrice() * (Integer)request.getAttribute("weekday") + 
                  model.getWeekendPrice() * (Integer)request.getAttribute("weekend");
}
String imagePath = "../images/cars/"+model.getType()+"/"+model.getPicture();
String modelName = model.getName();
String startDate = (String)request.getAttribute("startDate");
String endDate = (String)request.getAttribute("endDate");
String picture = model.getPicture();
String type = model.getType();
String fuelType = model.getFuelType();

%>
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
								&#8361 <%=amountMoney %>
							</h4>
						</div>
						<div class="tg-description">
							<p>There’s only 5 spot left. Join 19 others at Travelu’s
								experience this Saturday.</p>
						</div>
                        <div class="tg-description">
                          <ul class="my-tg-likeshare" >
                          <%
                          // 로그인일때의 wish, reserver 버튼
                          if(request.getAttribute("loginId")!= null ) { %> 
                            <li><a onclick="addToWishList('<%=modelName%>', '<%=startDate%>', '<%=endDate%>', '<%=amountMoney%>', '<%=picture%>', '<%=type%>', '<%=fuelType%>')" id="wishListAnchor"><i class="icon-heart"></i>Wish List</a></li>
                            <li><a href="<%=application.getContextPath()%>/rent/rent.jsp"><i class="icon-eye"></i>Reserve</a></li>
                          <% }
                          // 로그아웃일때의 reserver 버튼(wish 없음)
                          else { %> 
                            <li><a href="<%=application.getContextPath()%>/rent/rent.jsp"><i class="icon-eye"></i>Reserve</a></li>
                          <% } %>
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