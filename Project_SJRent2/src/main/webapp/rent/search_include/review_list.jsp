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
				<ul id='each_review_ul'>
                    
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