<%@page import="kr.or.kosta.sjrent.model.domain.Model"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Model정보를 출력하는 jsp (search.jsp에 include됨)
     컨트롤러로 부터 받은 정보 : model, startDate, endDate, weekday, weekend

 --%>
<div id = "detail_show" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-lg">
  	<div id = "tg-content" class="modal-content tg-content">	
  		<div class="modal-body tg-tourbookingdetail">
  		<div class="tg-tourbookingdetail">
  			<div class="tg-bookinginfo" style="margin: 10px 0">
  				<div class= "row">
  					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-5">
  						<img src='' alt="image description" id='detail-img'>
  					</div>
  					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-7">
  						<h2 id="detail-name">model name filed</h2>
  						<div class="tg-durationrating">
  							<span class='tg-stars'>
                                <span id='detail-star'></span> 
                              </span>
                              <em id='detail-review-count'>model review count filed</em> 
  						</div>
  						<div class="tg-pricearea">
  							<span>총 금액</span>
  							<h4 id='detail-amount-money'>
  								model amountMoney filed
  							</h4>
  						</div>
  						<div class="tg-description">
  							<p>There’s only 5 spot left. Join 19 others at Travelu’s
  								experience this Saturday.</p>
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
  			<jsp:include page="car_detail_list.jsp"></jsp:include>
  		</div>
  		</div>
  	</div>
  </div>
</div>