<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout tg-bglight">
		<div class="container" style="width: 90%">
			<div id = "detail_show" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
				<jsp:include page="search_detail.jsp"/>
			</div>
			<div class="row">
				<div id="tg-twocolumns" class="tg-twocolumns">
					<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9 pull-left">
						<div id="tg-content" class="tg-content">
							<div class="tg-listing tg-listingvone">
								<div class="tg-sectiontitle" style="padding-bottom: 20px">
									<h2>렌트카</h2>
								</div>
								<div class="clearfix"></div>
								<div class="row">
									<!-- Car List 출력-->
									<c:forEach var="item" items="${list}">
									<div class="col-xs-6 col-sm-6 col-md-4 col-lg-4" data-toggle="modal" data-target="#detail_show">
										<div class="tg-populartour"	>
											<figure>
												<a><img
													src="../images/cars/${item.getType()}/${item.getPicture()}" alt="image destinations"></a>
											</figure>
											<div class="tg-populartourcontent">
												<div class="tg-populartourtitle">
													<h3>
														<a class="car_detail">City Tours in Europe,
															Paris</a> 
													</h3>
												</div>
												<div class="tg-description">
													<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
														elit, sed diam nonummy nibh...</p>
												</div>
												<div class="tg-populartourfoot">
													<div class="tg-durationrating">
														<span class="tg-tourduration tg-availabilty">2 Days</span> <span
															class="tg-stars"><span style="width: 60%"></span></span>
														<em>(3 Review)</em>
													</div>
													<div class="tg-pricearea">
														<h4>￦2,500</h4>
													</div>
												</div>
											</div>
										</div>
									</div>
									</c:forEach>
									<div class="clearfix"></div>
									<nav class="tg-pagination">
										<ul>
											<li class="tg-active"><a href="javascript:void(0);">1</a></li>
											<li><a href="javascript:void(0);">2</a></li>
											<li><a href="javascript:void(0);">3</a></li>
											<li><a href="javascript:void(0);">4</a></li>
											<li class="tg-nextpage"><a href="javascript:void(0);"><i
													class="fa fa-angle-right"></i></a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
					<!--************************************
							Ranking Start
					*************************************-->
					<jsp:include page="rank_list.jsp"></jsp:include>
					<!--************************************
							Ranking End
					*************************************-->
				</div>
			</div>
		</div>
		</main>