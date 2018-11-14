<%@ page contentType="text/html; charset=utf-8"%>
<%
String loginId = (String)request.getAttribute("loginId"); 
%>
<header id="tg-header"
  class="tg-header tg-headervtwo tg-headerfixed tg-haslayout">
  <div class="container-fluid">
    <div class="row">
      <strong class="tg-logo"><a
        href="<%=application.getContextPath()%>/index.jsp"><img
          src="<%=application.getContextPath()%>/images/SJRentLogoSmallWhite.png"
          alt="shoppingmall logo"></a></strong>
      <nav class="tg-infonav">
        <ul>
          <!-- 로그인 체크 -->
          <%
                        if(loginId != null){
                        %>
          <!-- 로그인 되어 있는 경우 -->
          <li><a id="tg-btnsignin" href="/sjrent/user/logout.rent">로그아웃</a></li>
          <%	
                        }else{
                        %>
          <li><a id="tg-btnsignin" href="#"
            onclick="loginModalShow()">로그인</a></li>
          <%
                        }
                        %>
        </ul>
      </nav>
      <div class="tg-navigationarea">
        <div class="tg-navigationholder">
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
        </div>
      </div>
    </div>
  </div>
</header>