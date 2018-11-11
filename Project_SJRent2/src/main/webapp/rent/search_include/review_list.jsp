<%@ page contentType="text/html; charset=utf-8" %>
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
      <%--
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
       --%>
		</form>
	</div>
</div>