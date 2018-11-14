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
                            <ul class="my-tg-likeshare" >
                            <%
                            // 로그인일때의 wish, reserver 버튼
                            if(request.getAttribute("loginId")!= null ) { %> 
                              <li><a href="#" id="wish-list-anchor"><i class="icon-heart"></i>Wish List</a></li>
                              <li><a href="#" id="go-reserve-anchor"><i class="icon-eye"></i>Reserve</a></li>
                            <% }
                            // 로그아웃일때의 reserver 버튼(wish 없음)
                            else { %> 
                              <li><a href=# id="go-reserve-anchor"><i class="icon-eye"></i>Reserve</a></li>
                            <% } %>
                            </ul>
                          </div>
                          <div class="tg-description">
                            <div id="showCalendar" class="row">
                            	<!-- 달력 띄우기, 날짜는 한 개만 보내게 해야 함 -->

                            </div>
                          </div>
  					</div>
  				</div>
  				<ul class="tg-tripinfo">
  					<li><i class="fas fa-won-sign"></i><span id='detail-weekday-price'>weekday price field</span></li>
  					<li><i class="fas fa-won-sign"></i><span id='detail-weekend-price'>weekend price field</span></li>
  					<li><i class="fas fa-heart"></i><span id='detail-wish-count'>wish count field</span></li>
  					<li><i class="fas fa-user-alt"></i><span id='detail-reserve-count'>reserved count field</span></li>
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
</div>