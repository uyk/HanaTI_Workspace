<%@ page contentType="text/html; charset=utf-8"%>
	<nav id="menu">
		<ul>
			<li><a href="<%=application.getContextPath()%>/rent/search.jsp">실시간</a></li>
			<li class="menu-item-has-children"><a
				href="<%=application.getContextPath()%>/community/community.jsp">커뮤니티</a>
				<ul class="sub-menu">
					<li><a href="#">Q&A</a></li>
					<li><a href="#">FAQ</a></li>
					<li><a href="#">공지사항</a></li>
				</ul></li>
			<li><a href="<%=application.getContextPath()%>/wish/wish_list.jsp">예약확인</a></li>
		</ul>
	</nav>