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
						<h2>About this Model</h2>
						<div class="tg-description" id='about-this-model'>
						</div>
					</div>
					<div class="tg-box">
						<h2>Important Options</h2>
						<div class="tg-description" id='important-options'>
						</div>
					</div>
				</div>
				<div class="tg-bookingdetail tg-bookingdetailstyle">
					<div class="tg-box tg-amentities">
						<h3>Others</h3>
						<div class="tg-content" >
							<ul class="tg-liststyle" id='car-detail-others'>
							</ul>
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
             <%--<div id="review_tab_div"></div> --%>
            <jsp:include page="/rent/search_include/review_list.jsp"></jsp:include>
		</div>
	</div>
</div>