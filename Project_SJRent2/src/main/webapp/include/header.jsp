<%
String loginId = (String)request.getAttribute("loginId"); 
//System.out.println("header에 넘어온 loginId : " + loginId);

%>

<%@ page contentType="text/html; charset=utf-8"%>
      <header id="tg-header" class="tg-header tg-haslayout">
         <div class="container-fluid">
            <div class="row">
               <div class="tg-navigationarea tg-headerfixed">
                  <strong class="tg-logo"><a href="<%=application.getContextPath()%>/index.jsp"><img src="<%=application.getContextPath()%>/images/logo.png" alt="company logo here"></a></strong>
                  <div class="tg-socialsignin">
                     <ul class="tg-socialicons">
                        <li><a href="javascript:void(0);"><i class="icon-facebook-logo-outline"></i></a></li>
                     </ul>
                     <div class="tg-userbox">
                        <!-- 로그인 화면 띄우자 -->
                        <%
                        if(loginId != null){//로그인
                        //System.out.println("loginId : "+loginId);
                        %>
                        <a id="tg-btnsignin" class="tg-btn" href="/sjrent/user/logout.rent"><span style="size: 15pt">로그아웃</span></a>
                        
                        <%	
                        }else{
                        %>	
                            <a id="tg-btnsignin" class="tg-btn" href="#tg-loginsingup"><span style="size: 15pt">로그인</span></a>                        	
                        <%
                        }
                        %>
                         <!-- 재민 수정 시작(1/2) -->
                        <!-- 재민 수정 끝(1/2) -->
                        <div class="dropdown tg-dropdown">
                         <!-- 로그인 되어 있는 경우 -->
                        </div>
                     </div>
                  </div>
                  <nav id="tg-nav" class="tg-nav">
                     <div id="tg-navigation" class="collapse navbar-collapse tg-navigation">
                        <ul>
                           <li><a href="<%=application.getContextPath()%>/rent/search.jsp">실시간</a></li>
                           <li class="menu-item-has-children"><a
                              href="javascript:void(0);">커뮤니티</a>
                              <ul class="sub-menu">
                                 <li><a href="<%=application.getContextPath()%>/community/community.jsp">Q&A</a></li>
                                 <li><a href="<%=application.getContextPath()%>/community/community.jsp">FAQ</a></li>
                                 <li><a href="<%=application.getContextPath()%>/community/community.jsp">공지사항</a></li>
                              </ul></li>
                           <li><a href="<%=application.getContextPath()%>/wishitem/list.rent">위시리스트</a></li>
                           <li><a href="<%=application.getContextPath()%>/rent/list.rent">예약확인</a></li>
                        </ul>
                     </div>
                  </nav>
               </div>
            </div>
         </div>
      </header>
      
      <!-- 재민 수정 시작(2/2) -->
      <!--  로그인 화면  -->
      <div id="tg-loginsingup" class="tg-loginsingup" data-vide-bg="poster: images/singup-img.jpg" data-vide-options="position: 0% 50%">
      <div class="tg-contentarea tg-themescrollbar">
         <div class="tg-scrollbar">
            <button type="button" class="close">x</button>
            <div class="tg-logincontent">
               <nav id="tg-loginnav" class="tg-loginnav">
                  
               </nav>
               <div class="tg-themetabs">
                  <ul style= "text-align: center;">
                     <li style="list-style: none;"><h2>로그인</h2></li>
                  </ul>
                  <div class="tg-tabcontent tab-content">
                     <div role="tabpanel" class="tab-pane active fade in" id="home">
                        <form class="tg-formtheme tg-formlogin">
                           <fieldset>
                              <div class="form-group">
                                 <label>아이디 <sup>*</sup></label>
                                 <input type="text" name="firstname" class="form-control" placeholder="" maxlength="10">
                              </div>
                              <div class="form-group">
                                 <label>비밀번호 <sup>*</sup></label>
                                 <input type="password" name="password" class="form-control" placeholder="" maxlength="10">
                              </div>
                              <div class="form-group">
                                 <div class="tg-checkbox">
                                    <input type="checkbox" name="remember" id="rememberpass">
                                    <label for="rememberpass">아이디 저장</label>
                                 </div>
                              </div>
                              <button class="tg-btn tg-btn-lg"><span>로그인</span></button>
                           </fieldset>
                        </form>
                     </div>
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div> 