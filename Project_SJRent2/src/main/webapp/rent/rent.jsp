<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<style type="text/css">
	input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>

<script type="text/javascript">
/**
 *  정보를 넘겨서 예약 컨트롤러로 보냄
 */
function rent() {
	/**
	 *  이전 페이지에서 넘어오면서 받아올 데이터들 테스트를 위해 임의로 설정
	 */
	var startDate = "2018-11-10";
	var endDate="2018-11-12";
	var carNumber= "11호5432";
	var pickupPlace="인천광역시 서구";
	/**
	* 현재 페이지에서 입력받을 정보 테스트를 위해 임의로 입력
	*/
	//request.setAttribute("userName", "테스트예약자");
	//request.setAttribute("userEmail", "테스트메일");	
	var insuranceNumber= "4";
	var paidAmount="100000";
	var paymentOption= "카드";
	// 예약번호, 고객번호, 아이디, 취소여부는 받는쪽에서 알아서
	location.href="/sjrent/rent/rent.rent?"+
			"startDate="+startDate+
			"&endDate="+endDate+
			"&carNumber="+carNumber+
			"&pickupPlace="+pickupPlace+
			"&insuranceNumber="+insuranceNumber+
			"&paidAmount="+paidAmount+
			"&paymentOption=" + paymentOption;
	
}
/** servletContext에 저장된 id로 유저 정보를 읽어서 반환하는 컨트롤러로 이동 
 *  뷰에서 Ajax로 처리..
 */
function sameData() {
	location.href="/sjrent/user/read.rent"
}
</script>
</head>
<body>
<span>${model}</span>
	<!--************************************
			Mobile Menu Start
	*************************************-->
	<jsp:include page="../include/nav.jsp" />
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
		<jsp:include page="../include/header.jsp"></jsp:include>
		<!--************************************
					Header End
		*************************************-->
		<!--************************************
				Main Start
		*************************************-->
		<main id="tg-main" class="tg-main tg-haslayout">
			<div class="tg-sectionspace tg-haslayout">
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div id="tg-content" class="tg-content">
								<div class="tg-billingdetail">
									<form class="tg-formtheme tg-formbillingdetail" action="">
										<fieldset>
											<div class="tg-bookingdetail">
												<div class="tg-box">
													<div class="tg-heading">
														<h3>결제 정보</h3>
													</div>
													<div class="clearfix"></div>
													<div class="row">
														<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
															<div class="form-group">
																<label>이름 <sup>*</sup></label>
																<input type="text" name="user_name" class="form-control" placeholder="" required>
															</div>
														</div>
														<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
															<div class="form-group">
																<label>이메일 </label>
																<input type="email" name="user_email" class="form-control" placeholder="">
															</div>
														</div>
														<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding: 0">
															<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
																<div class="form-group">
																	<label>핸드폰 <sup>*</sup></label>
																	<input type="Number" name="user_cellphone" class="form-control" placeholder="" required>
																</div>
															</div>
															<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
																<div class="form-group">
																	<div class = "tg-checkbox">
																		<br>
																		<br>
																		<!-- 어떤 상태이냐에 따라서 체크 여부 바뀌는 지 파악 -->
																		<input type="checkbox" name = "sameUser" id="sameUser" onclick="sameData()">
																		<label for="sameUser">아이디 정보와 동일</label>
																	</div>
																</div>
															</div>
														</div>
														<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
															<div class="form-group">
																<label>시작날짜</label>
																<input type="text" name="rent_start_date" class="form-control" readonly="readonly">
															</div>
														</div>
														<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
															<div class="form-group">
																<label>종료날짜 </label>
																<input type="text" name="rent_end_date" class="form-control" readonly="readonly">
															</div>
														</div>
														<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
															<div class="form-group">
																<label>차량금액 </label>
																<input type="text" name="car_paid_amount" class="form-control" readonly="readonly">
															</div>
														</div>
														<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
															<div class="form-group">
																<label>수령장소 </label>
																<input type="text" name="rent_pickup_place" class="form-control" readonly="readonly" value="서울지점">
															</div>
														</div>
														<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
															<div class="form-group">
																<label>보험<sup>*</sup></label>
																<span>
																	<select class="ins_num" required>
																		<option value="">보험종류 선택</option>
																		<option value="0">완전자차--</option>
																		<option value="1">일반자차--</option>
																	</select>
																</span>
															</div>
														</div>
														
														<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
															<div class="form-group">
																<label>결제정보 <sup>*</sup></label>
																<span class="tg-select">
																	<select class="rent_payment_option" required>
																		<option value="">결제방법 선택</option>
																		<option value="card">카드</option>
																		<option value="transfer">계좌이체</option>
																	</select>
																</span>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="tg-bookingdetail">
												<div class="tg-box tg-addtionalinfo">
													<div class="tg-heading">
														<h3>추가 정보</h3>
													</div>
													<div class="form-group">
														<label>추가 정보 기입</label>
														<textarea placeholder="추가적으로 필요한 것을 적어주세요"></textarea>
													</div>
												</div>
												<div class="tg-box tg-yourorder">
													<div class="tg-heading">
														<h3>결제 정보</h3>
													</div>
													<div class="tg-widgetpersonprice">
														<div class="tg-widgetcontent">
															<ul>
																<li class="tg-personprice"><div class="tg-perperson"><span>차량 금액  (3 x 100,000￦)</span><em>300,000￦</em></div></li>
																<li><span>보험비</span><em>30,000￦</em></li>
																<li><span>총 일수</span><em>3일</em></li>
																<li class="tg-totalprice"><div class="tg-totalpayment"><span>총 금액</span><em>390,000￦</em></div></li>
															</ul>
														</div>
													</div>
												</div>
											</div>
										</fieldset>
										
										<fieldset>
											<button style="float: right" class="tg-btn" type="button" onclick="rent()"><span>결제하기</span></button>
										</fieldset>
									</form>
								</div>
							</div>
						</div>
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
	<div id="tg-loginsingup" class="tg-loginsingup col-6 " data-vide-bg="poster: ../images/singup-img.jpg" data-vide-options="position: 0% 50%">
      <div class="tg-contentarea tg-themescrollbar">
         <div class="tg-scrollbar">
            <button type="button" class="close">x</button>
            <div class="tg-logincontent">
               <div class="tg-themetabs">
                  <ul style= "text-align: center;">
                     <li style="list-style: none;"><h2>로그인</h2></li>
                  </ul>
                  <div class="tg-tabcontent tab-content">
                     <div role="tabpanel" class="tab-pane active fade in" id="home">
                        <form class="tg-formtheme tg-formlogin">
                           <fieldset>
                              <div class="form-group">
                                 <label>아이디 <sup>*</sup></label>
                                 <input type="text" name="firstname" class="form-control" placeholder="" maxlength="10">
                              </div>
                              <div class="form-group">
                                 <label>비밀번호 <sup>*</sup></label>
                                 <input type="password" name="password" class="form-control" placeholder="" maxlength="10">
                              </div>
                              <div class="form-group">
                                 <div class="tg-checkbox">
                                    <input type="checkbox" name="remember" id="rememberpass">
                                    <label for="rememberpass">아이디 저장</label>
                                 </div>
                              </div>
                              <button class="tg-btn tg-btn-lg"><span>로그인</span></button>
                           </fieldset>
                        </form>
                     </div>
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
	<jsp:include page="../common/commonjs.jsp" />
</body>
</html>