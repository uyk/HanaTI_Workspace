<%@ page contentType="text/html; charset=utf-8" %>
<div role="tabpanel" class="tab-pane tg-reviewtab" id="review">
	<div class="tg-reviewsarea">
		<form class="tg-formtheme tg-formreviews" action="<%=application.getContextPath()%>/review/add.rent" method="post" enctype="multipart/form-data">
			<fieldset class="tg-reviews">
				<ul id='each_review_ul'>
                    
				</ul>
			</fieldset>
		</form>
	</div>
</div>