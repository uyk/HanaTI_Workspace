<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!--************************************
		Product Detail Start
*************************************-->
<div class="tg-sectionspace tg-haslayout" style="display: block; filter: alpha(opacity=50);">
<span>${model}</span><button onclick="location.href='/sjrent/rent/rent.rent'">예약</button>
	<div class="container">
		<div class="row">
			<div class="tg-productdetail">
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-5">
					<img src="../images/G70.jpg" alt="image description">
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-7">
					<div class="tg-productinfo">
						<h3>차 이름</h3>
						<div class="tg-pricearea">
							<h4>$2,500</h4>
						</div>
						<div class="tg-description">
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
								sed diam nonummy Etiam porta sem malesuada magna mollis euismod.
								Maecenas sed diam eget risus varius blandit sit amet non magna.
								Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor
								auctor.</p>
							<p>Maecenas sed diam eget risus varius blandit sit amet non
								magna.</p>
						</div>
						<div class="tg-quantitycolor">
							<form class="tg-formtheme tg-formquantity">
								<fieldset>
									<div class="form-group">
										<input type="number" class="form-control" name="numbers"
											placeholder="2">
									</div>
									<div class="form-group">
										<span class="tg-select"> <select>
												<option>Choose Color</option>
												<option>Blue</option>
												<option>Black</option>
												<option>Green</option>
												<option>Grey</option>
												<option>White</option>
										</select>
										</span>
									</div>
									<div class="form-group">
										<a class="tg-btnaddtocart" href="javascript:void(0);"> <i
											class="icon-icons240"></i> <span>렌트하기</span>
										</a>
									</div>
								</fieldset>
								<fieldset>
									<ul class="tg-likeshare">
										<li class="tg-shareicon"><a href="javascript:void(0);"><i
												class="icon-share-button-outline"></i><span>share</span></a>
											<ul class="tg-share">
												<li><a href="javascript:void(0);"><i
														class="icon-twitter"></i></a></li>
												<li><a href="javascript:void(0);"><i
														class="icon-facebook"></i></a></li>
												<li><a href="javascript:void(0);"><i
														class="icon-pinterest"></i></a></li>
											</ul></li>
										<li><a href="javascript:void(0);"><i
												class="icon-heart"></i><span>save to wish list</span></a></li>
									</ul>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--************************************
		Product Detail End
*************************************-->
