<%@ page contentType="text/html; charset=utf-8"%>
	<nav id="menu">
		<ul>
			<li><a href="<%=application.getContextPath()%>/rent/search.jsp">실시간 예약</a></li>
			<li class="menu-item-has-children"><a
				href="<%=application.getContextPath()%>/qna/qna.jsp">커뮤니티</a>
				<ul class="sub-menu">
					<li><a href="/community/qna_index.jsp">Q&A</a></li>
					<li><a href="/community/faq_index.jsp">FAQ</a></li>
					<li><a href="/community/notice_index.jsp">공지사항</a></li>
				</ul></li>
			<li><a href="<%=application.getContextPath()%>/wishitem/list.rent">위시리스트</a></li>
			<li><a href="<%=application.getContextPath()%>/rent/list.rent">예약확인</a></li>
		</ul>
	</nav>