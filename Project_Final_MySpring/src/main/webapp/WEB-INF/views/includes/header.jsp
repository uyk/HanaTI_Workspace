<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header -->

<header class="header--standard header--standard-dark" id="header--standard-2" style="width: 100%; left: 0px; padding: 0px 55px;">

  <div class="header-content-wrapper" >
  
    <a href="#" class="logo" style="float: left; padding:10px; min-width: 160px;">
      <img src="<%=application.getContextPath()%>/resources/img/logo-colored.png" alt="Olympus" style="width: 40px; height: auto;">
      <h6 class="logo-title" style="margin-top: 0px">olympus</h6>
      SOCIAL NETWORK
    </a>
    <a href="#" class="open-responsive-menu js-open-responsive-menu">
    	<svg class="olymp-menu-icon"><use xlink:href="icons/icons.svg#olymp-menu-icon"></use></svg>
    </a>
    
    <div class="nav nav-pills nav1 header-menu" style=" margin-left: 18%">
      <div class="mCustomScrollbar">
        <ul>
          <li class="nav-item">
            <a href="#" class="nav-link">Interests</a>
          </li>
          <li class="nav-item dropdown" style="min-width: 120px;">
            <a class="nav-link dropdown-toggle" data-hover="dropdown" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false" tabindex='1'>Trading Lists</a>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="#">Profile Page</a>
              <a class="dropdown-item" href="#">Newsfeed</a>
              <a class="dropdown-item" href="#">Post Versions</a>
            </div>
          </li>
          <li class="nav-item" style="min-width: 110px;">
            <a href="#" class="nav-link">Holding Lists</a>
          </li>

          <li class="close-responsive-menu js-close-responsive-menu">
            <svg class="olymp-close-icon"><use xlink:href="icons/icons.svg#olymp-close-icon"></use></svg>
          </li>
        </ul>
        
      </div>
      
    </div>
    
    

    <div class="control-block " style="padding: 10px 30px;">
    
      <%--로그인중인지 아닌지 판별 --%>
      <c:choose>
        <%--로그인 아님 --%>
        <c:when test="${param.loginId eq null}">
          <a href="#" class="link-find-friend">Login</a>
          <a href="#" class="link-find-friend">Sign up</a>
        </c:when>
        <%--로그인 중 --%>
        <c:otherwise>
          <%-- 알림 시작 --%>
          <%-- SNS 알림 시작 --%>
          <div class="control-icon more has-items">
            <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
            <div class="label-avatar bg-blue">6</div>
    
            <div class="more-dropdown more-with-triangle triangle-top-center">
              <div class="ui-block-title ui-block-title-small">
                <h6 class="title">FRIEND REQUESTS</h6>
                <a href="#">Find Friends</a>
                <a href="#">Settings</a>
              </div>
    
              <div class="mCustomScrollbar" data-mcs-theme="dark">
                <ul class="notification-list friend-requests">
                  <li>
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar55-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <a href="#" class="h6 notification-friend">Tamara Romanoff</a>
                      <span class="chat-message-item">Mutual Friend: Sarah Hetfield</span>
                    </div>
                    <span class="notification-icon">
                      <a href="#" class="accept-request">
                        <span class="icon-add without-text">
                          <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                        </span>
                      </a>
    
                      <a href="#" class="accept-request request-del">
                        <span class="icon-minus">
                          <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                        </span>
                      </a>
    
                    </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                    </div>
                  </li>
    
                  <li>
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar56-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <a href="#" class="h6 notification-friend">Tony Stevens</a>
                      <span class="chat-message-item">4 Friends in Common</span>
                    </div>
                    <span class="notification-icon">
                      <a href="#" class="accept-request">
                        <span class="icon-add without-text">
                          <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                        </span>
                      </a>
    
                      <a href="#" class="accept-request request-del">
                        <span class="icon-minus">
                          <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                        </span>
                      </a>
    
                    </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                    </div>
                  </li>
    
                  <li class="accepted">
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar57-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      You and <a href="#" class="h6 notification-friend">Mary Jane Stark</a> just became friends. Write on <a href="#" class="notification-link">her wall</a>.
                    </div>
                    <span class="notification-icon">
                      <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                    </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                      <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
                    </div>
                  </li>
    
                  <li>
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar58-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <a href="#" class="h6 notification-friend">Stagg Clothing</a>
                      <span class="chat-message-item">9 Friends in Common</span>
                    </div>
                    <span class="notification-icon">
                      <a href="#" class="accept-request">
                        <span class="icon-add without-text">
                          <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                        </span>
                      </a>
    
                      <a href="#" class="accept-request request-del">
                        <span class="icon-minus">
                          <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                        </span>
                      </a>
    
                    </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                    </div>
                  </li>
    
                </ul>
              </div>
    
              <a href="#" class="view-all bg-blue">Check all your Events</a>
            </div>
          </div>
          <%-- SNS 알림 끝 --%>
          
          <%-- 채팅 메시지 알림.. 우리한테 필요 없음
          <div class="control-icon more has-items">
            <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
            <div class="label-avatar bg-purple">2</div>
    
            <div class="more-dropdown more-with-triangle triangle-top-center">
              <div class="ui-block-title ui-block-title-small">
                <h6 class="title">Chat / Messages</h6>
                <a href="#">Mark all as read</a>
                <a href="#">Settings</a>
              </div>
    
              <div class="mCustomScrollbar" data-mcs-theme="dark">
                <ul class="notification-list chat-message">
                  <li class="message-unread">
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar59-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <a href="#" class="h6 notification-friend">Diana Jameson</a>
                      <span class="chat-message-item">Hi James! It’s Diana, I just wanted to let you know that we have to reschedule...</span>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">4 hours ago</time></span>
                    </div>
                    <span class="notification-icon">
                      <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
                    </span>
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                    </div>
                  </li>
    
                  <li>
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar60-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <a href="#" class="h6 notification-friend">Jake Parker</a>
                      <span class="chat-message-item">Great, I’ll see you tomorrow!.</span>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">4 hours ago</time></span>
                    </div>
                    <span class="notification-icon">
                      <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
                    </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                    </div>
                  </li>
                  <li>
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar61-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <a href="#" class="h6 notification-friend">Elaine Dreyfuss</a>
                      <span class="chat-message-item">We’ll have to check that at the office and see if the client is on board with...</span>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">Yesterday at 9:56pm</time></span>
                    </div>
                      <span class="notification-icon">
                        <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
                      </span>
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                    </div>
                  </li>
    
                  <li class="chat-group">
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar11-sm.jpg" alt="author">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar12-sm.jpg" alt="author">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar13-sm.jpg" alt="author">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar10-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <a href="#" class="h6 notification-friend">You, Faye, Ed &amp; Jet +3</a>
                      <span class="last-message-author">Ed:</span>
                      <span class="chat-message-item">Yeah! Seems fine by me!</span>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">March 16th at 10:23am</time></span>
                    </div>
                      <span class="notification-icon">
                        <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
                      </span>
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                    </div>
                  </li>
                </ul>
              </div>
    
              <a href="#" class="view-all bg-purple">View All Messages</a>
            </div>
          </div>
          채팅 메시지 알림 끝 --%>
    
          <%-- 주식 알림 시작 --%>
          <div class="control-icon more has-items">
            <svg class="olymp-thunder-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-thunder-icon"></use></svg>
    
            <div class="label-avatar bg-primary">8</div>
    
            <div class="more-dropdown more-with-triangle triangle-top-center">
              <div class="ui-block-title ui-block-title-small">
                <h6 class="title">Notifications</h6>
                <a href="#">Mark all as read</a>
                <a href="#">Settings</a>
              </div>
              <div class="mCustomScrollbar" data-mcs-theme="dark">
                <ul class="notification-list">
                  <li>
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar62-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <div><a href="#" class="h6 notification-friend">Mathilda Brinker</a> commented on your new <a href="#" class="notification-link">profile status</a>.</div>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">4 hours ago</time></span>
                    </div>
                      <span class="notification-icon">
                        <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
                      </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                      <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
                    </div>
                  </li>
    
                  <li class="un-read">
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar63-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <div>You and <a href="#" class="h6 notification-friend">Nicholas Grissom</a> just became friends. Write on <a href="#" class="notification-link">his wall</a>.</div>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">9 hours ago</time></span>
                    </div>
                      <span class="notification-icon">
                        <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                      </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                      <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
                    </div>
                  </li>
    
                  <li class="with-comment-photo">
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar64-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <div><a href="#" class="h6 notification-friend">Sarah Hetfield</a> commented on your <a href="#" class="notification-link">photo</a>.</div>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">Yesterday at 5:32am</time></span>
                    </div>
                      <span class="notification-icon">
                        <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
                      </span>
    
                    <div class="comment-photo">
                      <img src="<%=application.getContextPath()%>/resources/img/comment-photo1.jpg" alt="photo">
                      <span>“She looks incredible in that outfit! We should see each...”</span>
                    </div>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                      <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
                    </div>
                  </li>
    
                  <li>
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar65-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <div><a href="#" class="h6 notification-friend">Green Goo Rock</a> invited you to attend to his event Goo in <a href="#" class="notification-link">Gotham Bar</a>.</div>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">March 5th at 6:43pm</time></span>
                    </div>
                      <span class="notification-icon">
                        <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                      </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                      <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
                    </div>
                  </li>
    
                  <li>
                    <div class="author-thumb">
                      <img src="<%=application.getContextPath()%>/resources/img/avatar66-sm.jpg" alt="author">
                    </div>
                    <div class="notification-event">
                      <div><a href="#" class="h6 notification-friend">James Summers</a> commented on your new <a href="#" class="notification-link">profile status</a>.</div>
                      <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">March 2nd at 8:29pm</time></span>
                    </div>
                      <span class="notification-icon">
                        <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
                      </span>
    
                    <div class="more">
                      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                      <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
                    </div>
                  </li>
                </ul>
              </div>
              <a href="#" class="view-all bg-primary">View All Notifications</a>
            </div>
          </div>
          <%-- 주식 알림 끝 --%>
          <!-- 개인정보 시작  -->
          <div class="author-page author vcard inline-items more">
            <div class="author-thumb">
              <img alt="author" src="<%=application.getContextPath()%>/resources/img/author-page.jpg" class="avatar">
              <span class="icon-status online"></span>
              <!-- 마우스 오버 -->
              <div class="more-dropdown more-with-triangle">
                <div class="mCustomScrollbar" data-mcs-theme="dark">
                  <%-- 계정 설정 시작 --%>
                  <div class="ui-block-title ui-block-title-small">
                    <h6 class="title">Your Account</h6>
                  </div>
    
                  <ul class="account-settings">
                    <li>
                      <a href="29-YourAccount-AccountSettings.html">
                        <svg class="olymp-menu-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-menu-icon"></use></svg>
                        <span>Profile Settings</span>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <svg class="olymp-logout-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-logout-icon"></use></svg>
                        <span>Log Out</span>
                      </a>
                    </li>
                  </ul>
                  <%-- 계정 설정 끝 --%>
                  
                  <%-- 상태명 시작 --%>
                  <div class="ui-block-title ui-block-title-small">
                    <h6 class="title">Custom Status</h6>
                  </div>
    
                  <form class="form-group with-button custom-status">
                    <input class="form-control" placeholder="" type="text" value="Space Cowboy">
    
                    <button class="bg-purple">
                      <svg class="olymp-check-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-check-icon"></use></svg>
                    </button>
                  </form>
                  <%-- 상태명 끝 --%>
                  
                  <%-- 기업정보 시작 --%>
                  <div class="ui-block-title ui-block-title-small">
                    <h6 class="title">About Olympus</h6>
                  </div>
                  <ul>
                    <li>
                      <a href="#">
                        <span>Terms and Conditions</span>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <span>FAQs</span>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <span>Careers</span>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <span>Contact</span>
                      </a>
                    </li>
                  </ul>
                  <%-- 기업정보 끝 --%>
                </div>
              </div>
              <!-- 마우스 오버 끝-->
            </div>
            <a href="02-ProfilePage.html" class="author-name fn">
              <div class="author-title">
                ${param.loginId }
                <svg class="olymp-dropdown-arrow-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-dropdown-arrow-icon"></use></svg>
              </div>
              <span class="author-subtitle">SPACE COWBOY</span>
            </a>
          </div>
          <!-- 개인정보 끝  -->
        </c:otherwise>
      </c:choose>


    </div>
  </div>

</header>
<!-- ... end Header -->









<!-- Responsive Header -->

<header class="header header-responsive" id="site-header-responsive">

  <div class="header-content-wrapper">
    <ul class="nav nav-tabs mobile-app-tabs" role="tablist">
      <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#request" role="tab">
          <div class="control-icon has-items">
            <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
            <div class="label-avatar bg-blue">6</div>
          </div>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#notification" role="tab">
          <div class="control-icon has-items">
            <svg class="olymp-thunder-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-thunder-icon"></use></svg>
            <div class="label-avatar bg-primary">8</div>
          </div>
        </a>
      </li>
    </ul>
  </div>

  <!-- Tab panes -->
  <div class="tab-content tab-content-responsive">

    <div class="tab-pane " id="request" role="tabpanel">

      <div class="mCustomScrollbar" data-mcs-theme="dark">
        <div class="ui-block-title ui-block-title-small">
          <h6 class="title">FRIEND REQUESTS</h6>
          <a href="#">Find Friends</a>
          <a href="#">Settings</a>
        </div>
        <ul class="notification-list friend-requests">
          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar55-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Tamara Romanoff</a>
              <span class="chat-message-item">Mutual Friend: Sarah Hetfield</span>
            </div>
                  <span class="notification-icon">
                    <a href="#" class="accept-request">
                      <span class="icon-add without-text">
                        <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                      </span>
                    </a>

                    <a href="#" class="accept-request request-del">
                      <span class="icon-minus">
                        <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                      </span>
                    </a>

                  </span>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
            </div>
          </li>
          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar56-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Tony Stevens</a>
              <span class="chat-message-item">4 Friends in Common</span>
            </div>
                  <span class="notification-icon">
                    <a href="#" class="accept-request">
                      <span class="icon-add without-text">
                        <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                      </span>
                    </a>

                    <a href="#" class="accept-request request-del">
                      <span class="icon-minus">
                        <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                      </span>
                    </a>

                  </span>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
            </div>
          </li>
          <li class="accepted">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar57-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              You and <a href="#" class="h6 notification-friend">Mary Jane Stark</a> just became friends. Write on <a href="#" class="notification-link">her wall</a>.
            </div>
                  <span class="notification-icon">
                    <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                  </span>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
              <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
            </div>
          </li>
          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar58-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Stagg Clothing</a>
              <span class="chat-message-item">9 Friends in Common</span>
            </div>
                  <span class="notification-icon">
                    <a href="#" class="accept-request">
                      <span class="icon-add without-text">
                        <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                      </span>
                    </a>

                    <a href="#" class="accept-request request-del">
                      <span class="icon-minus">
                        <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                      </span>
                    </a>

                  </span>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
            </div>
          </li>
        </ul>
        <a href="#" class="view-all bg-blue">Check all your Events</a>
      </div>

    </div>

    <div class="tab-pane " id="chat" role="tabpanel">

      <div class="mCustomScrollbar" data-mcs-theme="dark">
        <div class="ui-block-title ui-block-title-small">
          <h6 class="title">Chat / Messages</h6>
          <a href="#">Mark all as read</a>
          <a href="#">Settings</a>
        </div>

        <ul class="notification-list chat-message">
          <li class="message-unread">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar59-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Diana Jameson</a>
              <span class="chat-message-item">Hi James! It’s Diana, I just wanted to let you know that we have to reschedule...</span>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">4 hours ago</time></span>
            </div>
                  <span class="notification-icon">
                    <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
                  </span>
            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar60-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Jake Parker</a>
              <span class="chat-message-item">Great, I’ll see you tomorrow!.</span>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">4 hours ago</time></span>
            </div>
                  <span class="notification-icon">
                    <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
                  </span>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
            </div>
          </li>
          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar61-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Elaine Dreyfuss</a>
              <span class="chat-message-item">We’ll have to check that at the office and see if the client is on board with...</span>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">Yesterday at 9:56pm</time></span>
            </div>
                    <span class="notification-icon">
                      <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
                    </span>
            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
            </div>
          </li>

          <li class="chat-group">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar11-sm.jpg" alt="author">
              <img src="<%=application.getContextPath()%>/resources/img/avatar12-sm.jpg" alt="author">
              <img src="<%=application.getContextPath()%>/resources/img/avatar13-sm.jpg" alt="author">
              <img src="<%=application.getContextPath()%>/resources/img/avatar10-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">You, Faye, Ed &amp; Jet +3</a>
              <span class="last-message-author">Ed:</span>
              <span class="chat-message-item">Yeah! Seems fine by me!</span>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">March 16th at 10:23am</time></span>
            </div>
                    <span class="notification-icon">
                      <svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
                    </span>
            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
            </div>
          </li>
        </ul>

        <a href="#" class="view-all bg-purple">View All Messages</a>
      </div>

    </div>

    <div class="tab-pane " id="notification" role="tabpanel">

      <div class="mCustomScrollbar" data-mcs-theme="dark">
        <div class="ui-block-title ui-block-title-small">
          <h6 class="title">Notifications</h6>
          <a href="#">Mark all as read</a>
          <a href="#">Settings</a>
        </div>

        <ul class="notification-list">
          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar62-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <div><a href="#" class="h6 notification-friend">Mathilda Brinker</a> commented on your new <a href="#" class="notification-link">profile status</a>.</div>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">4 hours ago</time></span>
            </div>
                    <span class="notification-icon">
                      <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
                    </span>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
              <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
            </div>
          </li>

          <li class="un-read">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar63-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <div>You and <a href="#" class="h6 notification-friend">Nicholas Grissom</a> just became friends. Write on <a href="#" class="notification-link">his wall</a>.</div>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">9 hours ago</time></span>
            </div>
                    <span class="notification-icon">
                      <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                    </span>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
              <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
            </div>
          </li>

          <li class="with-comment-photo">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar64-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <div><a href="#" class="h6 notification-friend">Sarah Hetfield</a> commented on your <a href="#" class="notification-link">photo</a>.</div>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">Yesterday at 5:32am</time></span>
            </div>
                    <span class="notification-icon">
                      <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
                    </span>

            <div class="comment-photo">
              <img src="<%=application.getContextPath()%>/resources/img/comment-photo1.jpg" alt="photo">
              <span>“She looks incredible in that outfit! We should see each...”</span>
            </div>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
              <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar65-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <div><a href="#" class="h6 notification-friend">Green Goo Rock</a> invited you to attend to his event Goo in <a href="#" class="notification-link">Gotham Bar</a>.</div>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">March 5th at 6:43pm</time></span>
            </div>
                    <span class="notification-icon">
                      <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                    </span>

            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
              <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar66-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <div><a href="#" class="h6 notification-friend">James Summers</a> commented on your new <a href="#" class="notification-link">profile status</a>.</div>
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">March 2nd at 8:29pm</time></span>
            </div>
            <span class="notification-icon">
              <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
            </span>
            <div class="more">
              <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
              <svg class="olymp-little-delete"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
            </div>
          </li>
        </ul>

        <a href="#" class="view-all bg-primary">View All Notifications</a>
      </div>

    </div>
  </div>
  <!-- ... end  Tab panes -->

</header>

<!-- ... end Responsive Header -->