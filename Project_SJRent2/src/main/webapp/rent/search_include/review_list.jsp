<%@ page contentType="text/html; charset=utf-8"%>
<%--
	//페이지 인덱스 처리
    String index = request.getParameter("page");
	//page 인덱스가 요청 인자로 안오면 1페이지 출력
	if (index == null || index.equals("") || index.equals("null")) {
		index = "1";
	}
	int indexI = Integer.parseInt(index);

	//페이징 연산
	//페이지당 보여지는 목록수 설정
	int listSize = 10;
	//페이징 처리에 필요한 검색 개수 DB조회
	int rowCount = 0;

	//검색 또는 전체 결과에 따른 게시글 개수
	rowCount = Integer.parseInt(request.getParameter("reviewCount"));

	//페이지 개수
	int pageCount = (int) Math.ceil((double) rowCount / listSize);
	//페이지 목록의 시작페이지번호와 마지막페이지번호 계산
	//목록별 번호
	int pageSize = 5;
	int listNo = (indexI - 1) / pageSize; // 목록 식별번호
	//(1~5): 0, (6~10): 1, (11~15): 2, .....
	int startPage = (listNo * pageSize) + 1;
	int endPage = (listNo * pageSize) + pageSize;
	if (endPage > pageCount) {
		endPage = pageCount;
	}
--%>
<div role="tabpanel" class="tab-pane tg-reviewtab" id="review" >
  <div class="tg-reviewsarea">
    <form class="tg-formtheme tg-formreviews">
    <%-- 리뷰 개수, 필터 
      <fieldset class="tg-filterby">
        <div class="tg-durationrating">
          <em id='review-list-count'></em>
        </div>
        <span class="tg-select">
        <select>
            <option>Filter by</option>
            <option>Rating</option>
            <option>New</option>
            <option>date</option>
        </select>
        </span>
      </fieldset>
    --%>
      <fieldset class="tg-reviews">
        <ul id='each_review_ul' style='margin-botton: 30px;'>

        </ul>
      </fieldset>
<%-- 페이징 시작
      <div class="row">
        <div class="col-md-12 text-center">
          <nav aria-label="Page navigation" class="text-center">
            <ul class="pagination">
              <%
              	if (indexI == 1) {
              %>
              <li class="page-item"><a class="page-link"
                style="pointer-events: none; cursor: default;">Prev</a></li>
              <%
              	} else {
              %>
              <li class="page-item"><a class="page-link"
                href="..">Prev</a></li>
              <%
              	}
              	for (int i = startPage; i <= endPage; i++) {
              		if (i == indexI) {
              %>
              <li class="page-item active"><a class="page-link"
                href="#"><%=i%></a></li>
              <%
              	} else {
              %>
              <li class="page-item"><a class="page-link"
                href=".."><%=i%></a></li>
              <%
              	}
              	}
              	if (indexI == pageCount) {
              %>
              <li class="page-item"><a class="page-link"
                style="pointer-events: none; cursor: default;">Next</a></li>
              <%
              	} else {
              %>
              <li class="page-item"><a class="page-link"
                href="..">Next</a></li>
              <%
              	}
              %>
            </ul>
          </nav>
        </div>
      </div>
      
       --%>
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