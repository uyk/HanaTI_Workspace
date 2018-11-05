<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
</head>
<body>

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
		<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout tg-bglight">
			<div class="container">
				<div class="row">
					<div id="tg-twocolumns" class="tg-twocolumns">
						<form class="tg-formtheme tg-formtourpayment">
							<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 pull-left">
								<div id="tg-content" class="tg-content">
									<div class="tg-tourpaymentdetail">
										<div class="tg-tourname">
											<a class="tg-btnedit" href="#">(결제취소)</a>
											<figure>
												<a href="javascript:void(0);"><img src="images/img-04.jpg" alt="image destinations"></a>
											</figure>
											<div class="tg-populartourcontent">
												<div class="tg-populartourtitle">
													<h3><a href="javascript:void(0);">Switzerland – 12 Days Mountain Hiking Tour</a></h3>
												</div>
												<div class="tg-populartourfoot">
													<div class="tg-durationrating">
														<span class="tg-tourduration">12 Days 11 Nights</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 pull-right">
								<aside id="tg-sidebar" class="tg-sidebar">
									<div class="tg-widget tg-widgettourinfo">
										<div class="tg-widgetcontent">
											<ul>
												<li><span>Travel Date</span><em>May 12, 2017</em></li>
												<li><span>Period</span><em>12 Days</em></li>
												<li><span>Persons</span><em>5</em></li>
												<li><span>Rooms</span><em>1</em></li>
												<li>
													<button class="btn-primary">next step</button>
												</li>
											</ul>
										</div>
									</div>
								</aside>
							</div>
						</form>
					</div>
				</div>
			</div>
		</main>
		<!--************************************
				Main End
		*************************************-->
	
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