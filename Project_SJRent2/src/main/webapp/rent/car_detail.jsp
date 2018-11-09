<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tg-sectionspace tg-haslayout" style="padding: 70px 0">
	<div class="tg-themetabs tg-bookingtabs">
		<ul class="tg-themetabnav" role="tablist">
			<li role="presentation" class="active"><a href="#overview"
				aria-controls="overview" role="tab" data-toggle="tab"> <span>Overview</span>
			</a></li>
			<li role="presentation"><a href="#location"
				aria-controls="location" role="tab" data-toggle="tab"> <span>Location</span>
			</a></li>
			<li role="presentation"><a href="#review"
				aria-controls="review" role="tab" data-toggle="tab"> <span>Reviews</span>
			</a></li>
		</ul>
		<div class="tab-content tg-themetabcontent">
			<div role="tabpanel" class="tab-pane active tg-overviewtab"
				id="overview">
				<div class="tg-bookingdetail">
					<div class="tg-box">
						<h2>About this listing</h2>
						<div class="tg-description">
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
								elit, sed diam nonummy Etiam porta sem malesuada magna mollis
								euismod.</p>
							<p>Maecenas sed diam eget risus varius blandit sit amet
								non magna. Vivamus sagittis lacus vel augue Sed non mauris
								vitae;erat consequat auctor eu in elit. Class aptent taciti
								sociosqu ad litora torquent per conubia nostra, per inceptos
								himenaeos. Mauris in erat justo.</p>
							<p>Nullam ac urna eu felis dapibus condimentum sit amet a
								augue. Sed non neque elit. Sed ut imperdiet nisi.</p>
							<p>Proin condimentum fermentum nunc. Etiam pharetra, erat
								sed fermentum feugiat, velit mauris egestas quam.</p>
						</div>
					</div>
					<div class="tg-box">
						<h2>Guest access</h2>
						<div class="tg-description">
							<p>Proin condimentum fermentum nunc. Etiam pharetra, erat
								sed fermentum feugiat, velit mauris egestas quam.</p>
							<p>Maecenas sed diam eget risus varius blandit sit amet
								non magna. Vivamus sagittis lacus vel augue Sed non mauris
								vitae;erat consequat auctor eu in elit. Class aptent taciti
								sociosqu ad litora torquent per conubia nostra.</p>
							<ul class="tg-liststyle">
								<li><span>Ipsum Amet Mattis Pellentesque</span></li>
								<li><span>Ultricies Vehicula Mollis Vestibulum
										Fringilla</span></li>
								<li><span>Condimentum Sollicitudin Fusce
										Vestibulum Ultricies</span></li>
								<li><span>Sollicitudin Consectetur Quam Ligula
										Vehicula</span></li>
								<li><span>Cursus Pharetra Purus Porta Parturient</span></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="tg-bookingdetail tg-bookingdetailstyle">
					<div class="tg-box tg-amentities">
						<h3>Amenities</h3>
						<div class="tg-content">
							<ul class="tg-liststyle">
								<li><span>Pets allowed</span></li>
								<li><span>Internet</span></li>
								<li><span>Gym</span></li>
								<li><span>Hot tub</span></li>
								<li><span>Doorman</span></li>
								<li><span>Wheelchair accessible</span></li>
								<li><span>Pool</span></li>
							</ul>
							<ul class="tg-liststyle">
								<li><span>Kitchen</span></li>
								<li><span>Suitable for events</span></li>
								<li><span>Dryer</span></li>
								<li><span>Family/kid friendly</span></li>
								<li><span>Cable TV</span></li>
								<li><span>Wireless Internet</span></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="tg-bookingdetail tg-bookingdetailstyle">
					<div class="tg-box tg-priceinclude">
						<h3>Price Includes</h3>
						<div class="tg-content">
							<ul class="tg-liststyle">
								<li><span>Air fares</span></li>
								<li><span>3 Nights Hotel Accomodation</span></li>
								<li><span>Tour Guide</span></li>
								<li><span>Entrance Fees</span></li>
								<li><span>All transportation in destination
										location</span></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="tg-bookingdetail tg-bookingdetailstyle">
					<div class="tg-box tg-amentities">
						<h3>Tour Rules</h3>
						<div class="tg-content">
							<div class="tg-description">
								<p>Maecenas sed diam eget risus varius blandit sit amet
									non magna. Vivamus sagittis lacus vel augue Sed non mauris
									vitae;erat consequat auctor eu in elit. Class aptent taciti
									sociosqu ad litora torquent.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane tg-locationtab" id="location">
				<div class="tg-box tg-location">
					<h3>The neighborhood</h3>
					<div class="tg-description">
						<p>Curabitur blandit tempus porttitor. Lorem ipsum dolor
							sit amet, consectetur adipiscing elit. Cras mattis consectetur
							purus sit amet fermentum. Etiam porta sem malesuada magna
							mollis euismod. Lorem ipsum dolor sit amet, consectetur
							adipiscing elit.</p>
					</div>
					<div id="tg-locationmap" class="tg-locationmap tg-map"></div>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane tg-reviewtab" id="review">
				<div class="tg-reviewsarea">
					<form class="tg-formtheme tg-formreviews">
						<fieldset class="tg-filterby">
							<div class="tg-durationrating">
								<em>(3 Review)</em> <span class="tg-stars"><span></span></span>
							</div>
							<span class="tg-select"> <select>
									<option>Filter by</option>
									<option>Rating</option>
									<option>New</option>
									<option>date</option>
							</select>
							</span>
						</fieldset>
						<fieldset class="tg-reviews">
							<ul>
								<li>
									<div class="tg-review">
										<div class="tg-author">
											<figure class="tg-authorimg">
												<img src="../images/avatars/img-01.jpg"
													alt="image description">
											</figure>
											<div class="tg-authorinfo">
												<h3>Katie</h3>
												<span>Family Vacation</span> <span class="tg-stars"><span></span></span>
											</div>
										</div>
										<div class="tg-reviewcontent">
											<div class="tg-reviewhead">
												<span class="tg-tourduration">January 25, 2017</span> <a
													class="tg-btnhelpfull" href="#"><i
													class="icon-thumb-up"></i>Helpful</a>
											</div>
											<div class="tg-description">
												<p>Maecenas sed diam eget risus varius blandit sit
													amet non magna. Vivamus sagittis lacus vel augue Sed non
													mauris vitae;erat consequat auctor eu in elit. Class
													aptent taciti sociosqu.</p>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="tg-review">
										<div class="tg-author">
											<figure class="tg-authorimg">
												<img src="../images/avatars/img-01.jpg"
													alt="image description">
											</figure>
											<div class="tg-authorinfo">
												<h3>Katie</h3>
												<span>Family Vacation</span> <span class="tg-stars"><span></span></span>
											</div>
										</div>
										<div class="tg-reviewcontent">
											<div class="tg-reviewhead">
												<span class="tg-tourduration">January 25, 2017</span> <a
													class="tg-btnhelpfull" href="#"><i
													class="icon-thumb-up"></i>Helpful</a>
											</div>
											<div class="tg-description">
												<p>Maecenas sed diam eget risus varius blandit sit
													amet non magna. Vivamus sagittis lacus vel augue Sed non
													mauris vitae;erat consequat auctor eu in elit. Class
													aptent taciti sociosqu.</p>
												<p>First, please don’t fall sick. However, if in case
													something does catchup with you, we will airlift you to
													hospital but your insurance will have to pay for this.
													Ulins aliquam massa nisl quis neque. Proin condimentum
													fermentum nunc. Etiam pharetra, erat sed fermentum
													feugiat, velit mauris egestas quam, ut liquam massa nisl
													quis neque.</p>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="tg-review">
										<div class="tg-author">
											<figure class="tg-authorimg">
												<img src="../images/avatars/img-01.jpg"
													alt="image description">
											</figure>
											<div class="tg-authorinfo">
												<h3>Katie</h3>
												<span>Family Vacation</span> <span class="tg-stars"><span></span></span>
											</div>
										</div>
										<div class="tg-reviewcontent">
											<div class="tg-reviewhead">
												<span class="tg-tourduration">January 25, 2017</span> <a
													class="tg-btnhelpfull" href="#"><i
													class="icon-thumb-up"></i>Helpful</a>
											</div>
											<div class="tg-description">
												<p>What a magical place, even better than I imagined!
													Teresa and Daniella were so helpful and awesome</p>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="tg-review">
										<div class="tg-author">
											<figure class="tg-authorimg">
												<img src="../images/avatars/img-01.jpg"
													alt="image description">
											</figure>
											<div class="tg-authorinfo">
												<h3>Katie</h3>
												<span>Family Vacation</span> <span class="tg-stars"><span></span></span>
											</div>
										</div>
										<div class="tg-reviewcontent">
											<div class="tg-reviewhead">
												<span class="tg-tourduration">January 25, 2017</span> <a
													class="tg-btnhelpfull" href="#"><i
													class="icon-thumb-up"></i>Helpful</a>
											</div>
											<div class="tg-description">
												<p>Very nice place</p>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="tg-review">
										<div class="tg-author">
											<figure class="tg-authorimg">
												<img src="../images/avatars/img-01.jpg"
													alt="image description">
											</figure>
											<div class="tg-authorinfo">
												<h3>Katie</h3>
												<span>Family Vacation</span> <span class="tg-stars"><span></span></span>
											</div>
										</div>
										<div class="tg-reviewcontent">
											<div class="tg-reviewhead">
												<span class="tg-tourduration">January 25, 2017</span> <a
													class="tg-btnhelpfull" href="#"><i
													class="icon-thumb-up"></i>Helpful</a>
											</div>
											<div class="tg-description">
												<p>Maecenas sed diam eget risus varius blandit sit
													amet non magna. Vivamus sagittis lacus vel augue Sed non
													mauris vitae;erat consequat auctor eu in elit. Class
													aptent taciti sociosqu ad litora torquent per conubia
													nostra, per inceptos himenaeos. Mauris in erat justo
													First, please don’t fall sick. However, if in case
													something does catchup.</p>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</fieldset>
                        <!-- 리뷰남기기 시작 -->
						<fieldset class="tg-formleavereview">
							<div class="tg-leavereviewhead">
								<h2>Leave your Comment</h2>
								<div class="tg-durationrating">
									<h3>Your Rating</h3>
									<span class="tg-stars"><span></span></span>
								</div>
							</div>
							<div class="tg-reviewformarea">
								<div class="form-group">
									<input type="text" name="fullname" class="form-control"
										placeholder="Full Name">
								</div>
								<div class="form-group">
									<input type="email" name="email" class="form-control"
										placeholder="Email Address">
								</div>
								<div class="form-group">
									<textarea placeholder="">Your Comment</textarea>
								</div>
								<div class="form-group">
									<a class="tg-btn" href="#"><span>submit</span></a>
								</div>
							</div>
						</fieldset>
                        <!-- 리뷰남기기 끝 -->
					</form>
				</div>
			</div>
		</div>
	</div>
</div>