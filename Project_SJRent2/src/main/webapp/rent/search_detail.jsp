<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
System.out.println(request.getParameter("model_name"));
%>
<span>Model Name  : ${model_name}</span>
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
						<img src="../images/G70.jpg" alt="image description">
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-7">
						<h2>G70 (예약정보 or 과거 or 취소)</h2>
						<div class="tg-durationrating">
							<span class="tg-stars"><span></span></span> <em>(3 Review)</em>
						</div>
						<div class="tg-pricearea">
							<span>총 금액</span>
							<h4>
								$2,500
							</h4>
						</div>
						<div class="tg-description">
							<p>There’s only 5 spot left. Join 19 others at Travelu’s
								experience this Saturday.</p>
						</div>
						<form class="tg-formtheme tg-formbookingdetail">
							<fieldset>
								<div class="form-group">
								
								
								</div>
								<div class="form-group">
		
								</div>
							</fieldset>
						</form>
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
					<ul class="tg-likeshare">
						<li><a href="javascript:void(0);"><i class="icon-heart"></i>save to wish list</a></li>
						<li><a href="javascript:void(0);"><i class="icon-eye"></i>how many rented</a></li>
					</ul>
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