
<%
	String loginId = (String) request.getAttribute("loginId");
	//System.out.println("header에 넘어온 loginId : " + loginId);
%>

<%@ page contentType="text/html; charset=utf-8"%>
<header id="tg-header" class="tg-header tg-haslayout">
  <div class="container-fluid">
    <div class="row">
      <div class="tg-navigationarea tg-headerfixed">
        <strong class="tg-logo"><a
          href="<%=application.getContextPath()%>/index.jsp"><img
            src="<%=application.getContextPath()%>/images/SJRentLogoSmall.png"
            alt="company logo here"></a></strong>
        <div class="tg-socialsignin">
          <div class="tg-userbox">


            <!-- 회원인 경우 Header -->
            <%
            	if (loginId != null) {
            %>
            <a id="tg-btnsignin" class="tg-btn"
              href="/sjrent/user/logout.rent"><span
              style="size: 15pt">로그아웃</span></a>



            <div class="dropdown tg-dropdown"></div>
          </div>
        </div>
        <nav id="tg-nav" class="tg-nav">
          <div id="tg-navigation"
            class="collapse navbar-collapse tg-navigation">
            <ul>
              <li><a
                href="<%=application.getContextPath()%>/rent/search.jsp">실시간</a></li>
              <li><a
                href="<%=application.getContextPath()%>/rec/rec_index.jsp">추천예약</a></li>
              <li class="menu-item-has-children"><a
                href="<%=application.getContextPath()%>/qna/qnaIndex.rent">커뮤니티</a>
                <ul class="sub-menu">
                  <li><a
                    href="<%=application.getContextPath()%>/qna/qnaIndex.rent">Q&A</a></li>
                  <li><a
                    href="<%=application.getContextPath()%>/qna/qnaIndex.rent">FAQ</a></li>
                  <li><a
                    href="<%=application.getContextPath()%>/qna/qnaIndex.rent">공지사항</a></li>
                </ul></li>

              <li><a
                href="<%=application.getContextPath()%>/wishitem/list.rent">위시리스트</a></li>
              <li><a
                href="<%=application.getContextPath()%>/rent/list.rent">예약확인</a></li>
              <li><a
                href="<%=application.getContextPath()%>/mypage/myPage.jsp">MYPAGE</a></li>
            </ul>
          </div>
        </nav>






        <!-- 비회원인 경우 Header -->
        <%
        	} else {
        %>
        <a id="tg-btnsignin" class="tg-btn"
          href="/sjrent/user/login.jsp"><span style="size: 15pt">로그인</span></a>

        <div class="dropdown tg-dropdown"></div>
      </div>
    </div>
    <nav id="tg-nav" class="tg-nav">
      <div id="tg-navigation"
        class="collapse navbar-collapse tg-navigation">
        <ul>
          <li><a
            href="<%=application.getContextPath()%>/rent/search.jsp">실시간</a></li>
          <li><a
            href="<%=application.getContextPath()%>/rec/rec_index.jsp">추천
              예약</a></li>
          <li class="menu-item-has-children"><a
            href="<%=application.getContextPath()%>/qna/qnaIndex.rent">커뮤니티</a>
            <ul class="sub-menu">
              <li><a
                href="<%=application.getContextPath()%>/qna/qnaIndex.rent">Q&A</a></li>
              <li><a
                href="<%=application.getContextPath()%>/qna/qnaIndex.rent">FAQ</a></li>
              <li><a
                href="<%=application.getContextPath()%>/qna/qnaIndex.rent">공지사항</a></li>
            </ul></li>

          <li><a
            href="<%=application.getContextPath()%>/user/login.jsp">위시리스트</a></li>
          <li><a
            href="<%=application.getContextPath()%>/user/login2.jsp">예약확인</a></li>
          <li><a
            href="<%=application.getContextPath()%>/user/login.jsp">MYPAGE</a></li>
        </ul>
      </div>
    </nav>


    <%
    	}
    %>


  </div>
</header>



