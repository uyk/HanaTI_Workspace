<%@ page contentType="text/html; charset=utf-8" %>
<div role="tabpanel" class="tab-pane tg-reviewtab" id="review">
	<div class="tg-reviewsarea">
		<form class="tg-formtheme tg-formreviews" action="<%=application.getContextPath()%>/review/add.rent" method="post" enctype="multipart/form-data">
			<!-- <fieldset class="tg-filterby">
				<div class="tg-durationrating">
					<em id='review-list-count'></em> 
				</div>
				<span class="tg-select"> <select>
						<option>Filter by</option>
						<option>Rating</option>
						<option>New</option>
						<option>date</option>
				</select>
				</span>
			</fieldset> -->
			<fieldset class="tg-reviews">
				<ul id='each_review_ul'>
                    
				</ul>
			</fieldset>
      <!-- 리뷰남기기 시작 -->
			<fieldset class="tg-formleavereview">
				<div class="tg-leavereviewhead">
					<h2>댓글을 남겨주세요</h2>
					<div class="tg-durationrating">
						<h3>별점을 입력해주세요</h3>
						<select class="selectpicker" name="evalScore"
                              title="별점" required=>
                              <option data-tokens="10">10</option>
                              <option data-tokens="9">9</option>
                              <option data-tokens="8">8</option>
                              <option data-tokens="7">7</option>
                              <option data-tokens="6">6</option>
                              <option data-tokens="5">5</option>
                              <option data-tokens="4">4</option>
                              <option data-tokens="3">3</option>
                              <option data-tokens="2">2</option>
                              <option data-tokens="1">1</option>
                            </select>
					</div>
				</div>
				<input type="hidden" id="getModelName" name="modelName" value="">
				<div class="tg-reviewformarea">
					<div class="form-group">
						<input type="text" name="title" class="form-control"
							placeholder="제목을 입력해주세요" required maxlength="20">
					</div>
					<div class="form-group"></div>
					<div class="form-group">
						<textarea placeholder="댓글을 남겨주세요" name="content" required></textarea>
					</div>
					<div class="form-group">
						<input type="file" class="btn btn-secondary" name="picture" style="float: right;">
					</div>
					<div class="form-group">
						<!-- <a id="addReview" class="tg-btn" style="float: right;"><span>댓글 쓰기</span></a> -->
						<input type="submit" class="tg-btn" style="float: right;" value="댓글 쓰기">
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>