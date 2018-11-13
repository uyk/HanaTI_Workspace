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
            <%--
                OverView 탭 시작
             --%>
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
      
            <%--
                Location 탭 시작
             --%>
			<div role="tabpanel" class="tab-pane tg-locationtab" id="location">
				<div class="tg-box tg-location">
					<h3>수령장소를 골라주세요</h3>
					<div class="tg-description">
						<p id="yourPlace"></p>
					</div>
					<div id="floating-panel">
				    	<input id="yourAddress" type="text" value="하나금융티아이">
				      	<input id="findPlace" type="button" class="btn btn-primary" value="장소 찾기">
				    </div>	
				    <div id="map"></div>
				</div>
			</div>
      
            <%--
                Review 탭 시작
             --%>
            <jsp:include page="/rent/search_include/review_list.jsp"></jsp:include>
		</div>
	</div>
</div>