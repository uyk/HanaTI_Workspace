<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Newsfeed</title>
  <jsp:include page="includes/head.jsp"></jsp:include> 
</head>
<body>

<%-- 우리한테 필요 없는 고정 양측 사이드바 --%>
<!-- Fixed Sidebar Left -->
<%-- <jsp:include page="includes/fixed-sidebar-left.jsp"></jsp:include> --%>
<!-- end Fixed Sidebar Left -->

<!-- Fixed Sidebar Right -->
<%-- <jsp:include page="includes/fixed-sidebar-right.jsp"></jsp:include> --%>
<!-- ... end Fixed Sidebar Right -->

<!-- Header -->
<%-- 테스트 로그인 ID로 Yegyeom Yu 보냄 --%>
<jsp:include page="includes/header.jsp">
  <jsp:param value="Yegyeom Yu" name="loginId"/>
</jsp:include>
<!-- ... end Header -->

<div class="header-spacer"></div>

<div class="container">
  <div class="row">

    <!-- Main Content -->

    <main class="col-xl-6 order-xl-2 col-lg-12 order-lg-1 col-md-12 col-sm-12 col-xs-12">
      <%-- 검색 시작 --%>
      <div class="ui-block">
        <form class="w-search" style="width: 100%;">
        	<div class="form-group with-button is-empty">
        		<input class="form-control" type="text" placeholder="Search Blog Posts...">
        		<button style="background-color: #3f4257;">
        			<svg class="olymp-magnifying-glass-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-magnifying-glass-icon"></use></svg>
        		</button>
        	<span class="material-input"></span></div>
        </form>
      </div>
      <%-- 검색 끝 --%>
      <%-- 글 작성 시작 --%>
      <div class="ui-block">
        <div class="news-feed-form">
          <!-- Nav tabs -->
          <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
              <a class="nav-link active inline-items" data-toggle="tab" href="#home-1" role="tab" aria-expanded="true">

                <svg class="olymp-status-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-status-icon"></use></svg>

                <span>Status</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link inline-items" data-toggle="tab" href="#profile-1" role="tab" aria-expanded="false">

                <svg class="olymp-multimedia-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-multimedia-icon"></use></svg>

                <span>Trading Lists</span>
              </a>
            </li>

            <li class="nav-item">
              <a class="nav-link inline-items" data-toggle="tab" href="#blog" role="tab" aria-expanded="false">
                <svg class="olymp-blog-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-blog-icon"></use></svg>

                <span>Holding Lists</span>
              </a>
            </li>
          </ul>

          <!-- Tab panes -->
          <div class="tab-content">
            <div class="tab-pane active" id="home-1" role="tabpanel" aria-expanded="true">
              <form>
                <div class="author-thumb">
                  <img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">
                </div>
                <div class="form-group with-icon label-floating is-empty">
                  <label class="control-label">Share what you are thinking here...</label>
                  <textarea class="form-control" placeholder=""></textarea>
                </div>
                <div class="add-options-message">
                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD PHOTOS">
                    <svg class="olymp-camera-icon" data-toggle="modal" data-target="#update-header-photo"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-camera-icon"></use></svg>
                  </a>
                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="TAG YOUR FRIENDS">
                    <svg class="olymp-computer-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-computer-icon"></use></svg>
                  </a>

                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD LOCATION">
                    <svg class="olymp-small-pin-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-small-pin-icon"></use></svg>
                  </a>

                  <button class="btn btn-primary btn-md-2">Post Status</button>
                  <button   class="btn btn-md-2 btn-border-think btn-transparent c-grey">Preview</button>

                </div>

              </form>
            </div>

            <div class="tab-pane" id="profile-1" role="tabpanel" aria-expanded="true">
              <form>
                <div class="author-thumb">
                  <img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">
                </div>
                <div class="form-group with-icon label-floating is-empty">
                  <label class="control-label">Share what you are thinking here...</label>
                  <textarea class="form-control" placeholder=""  ></textarea>
                </div>
                <div class="add-options-message">
                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD PHOTOS">
                    <svg class="olymp-camera-icon" data-toggle="modal" data-target="#update-header-photo"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-camera-icon"></use></svg>
                  </a>
                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="TAG YOUR FRIENDS">
                    <svg class="olymp-computer-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-computer-icon"></use></svg>
                  </a>

                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD LOCATION">
                    <svg class="olymp-small-pin-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-small-pin-icon"></use></svg>
                  </a>

                  <button class="btn btn-primary btn-md-2">Post Status</button>
                  <button   class="btn btn-md-2 btn-border-think btn-transparent c-grey">Preview</button>

                </div>

              </form>
            </div>

            <div class="tab-pane" id="blog" role="tabpanel" aria-expanded="true">
              <form>
                <div class="author-thumb">
                  <img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">
                </div>
                <div class="form-group with-icon label-floating is-empty">
                  <label class="control-label">Share what you are thinking here...</label>
                  <textarea class="form-control" placeholder=""  ></textarea>
                </div>
                <div class="add-options-message">
                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD PHOTOS">
                    <svg class="olymp-camera-icon" data-toggle="modal" data-target="#update-header-photo"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-camera-icon"></use></svg>
                  </a>
                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="TAG YOUR FRIENDS">
                    <svg class="olymp-computer-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-computer-icon"></use></svg>
                  </a>

                  <a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD LOCATION">
                    <svg class="olymp-small-pin-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-small-pin-icon"></use></svg>
                  </a>

                  <button class="btn btn-primary btn-md-2">Post Status</button>
                  <button   class="btn btn-md-2 btn-border-think btn-transparent c-grey">Preview</button>

                </div>

              </form>
            </div>
          </div>
        </div>
      </div>
      <%-- 글 작성 끝 --%>
      <%-- 피드 목록 시작--%>
      <div id="newsfeed-items-grid">

        <div class="ui-block">
          <article class="hentry post video">

            <div class="post__author author vcard inline-items">
              <img src="<%=application.getContextPath()%>/resources/img/avatar7-sm.jpg" alt="author">

              <div class="author-date">
                <a class="h6 post__author-name fn" href="#">Marina Valentine</a> shared a <a href="#">link</a>
                <div class="post__date">
                  <time class="published" datetime="2004-07-24T18:18">
                    March 4 at 2:05pm
                  </time>
                </div>
              </div>

              <div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                <ul class="more-dropdown">
                  <li>
                    <a href="#">Edit Post</a>
                  </li>
                  <li>
                    <a href="#">Delete Post</a>
                  </li>
                  <li>
                    <a href="#">Turn Off Notifications</a>
                  </li>
                  <li>
                    <a href="#">Select as Featured</a>
                  </li>
                </ul>
              </div>

            </div>

            <p>Hey <a href="#">Cindi</a>, you should really check out this new song by Iron Maid. The next time they come to the city we should totally go!</p>

            <div class="post-video">
              <div class="video-thumb">
                <img src="<%=application.getContextPath()%>/resources/img/video-youtube1.jpg" alt="photo">
                <a href="https://youtube.com/watch?v=excVFQ2TWig" class="play-video">
                  <svg class="olymp-play-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-play-icon"></use></svg>
                </a>
              </div>

              <div class="video-content">
                <a href="#" class="h4 title">Iron Maid - ChillGroves</a>
                <p>Lorem ipsum dolor sit amet, consectetur ipisicing elit, sed do eiusmod tempor incididunt
                  ut labore et dolore magna aliqua...
                </p>
                <a href="#" class="link-site">YOUTUBE.COM</a>
              </div>
            </div>

            <div class="post-additional-info inline-items">

              <a href="#" class="post-add-icon inline-items">
                <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
                <span>18</span>
              </a>

              <ul class="friends-harmonic">
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic9.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic10.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic7.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic8.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic11.jpg" alt="friend">
                  </a>
                </li>
              </ul>

              <div class="names-people-likes">
                <a href="#">Jenny</a>, <a href="#">Robert</a> and
                <br>18 more liked this
              </div>

              <div class="comments-shared">
                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-speech-balloon-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-speech-balloon-icon"></use></svg>

                  <span>0</span>
                </a>

                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>

                  <span>16</span>
                </a>
              </div>


            </div>

            <div class="control-block-button post-control-button">

              <a href="#" class="btn btn-control">
                <svg class="olymp-like-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-like-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
              </a>

            </div>

          </article>
        </div>

        <div class="ui-block">
          <article class="hentry post">

            <div class="post__author author vcard inline-items">
              <img src="<%=application.getContextPath()%>/resources/img/avatar10-sm.jpg" alt="author">

              <div class="author-date">
                <a class="h6 post__author-name fn" href="#">Elaine Dreyfuss</a>
                <div class="post__date">
                  <time class="published" datetime="2004-07-24T18:18">
                    9 hours ago
                  </time>
                </div>
              </div>

              <div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                <ul class="more-dropdown">
                  <li>
                    <a href="#">Edit Post</a>
                  </li>
                  <li>
                    <a href="#">Delete Post</a>
                  </li>
                  <li>
                    <a href="#">Turn Off Notifications</a>
                  </li>
                  <li>
                    <a href="#">Select as Featured</a>
                  </li>
                </ul>
              </div>

            </div>

            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempo incididunt ut
              labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris consequat.
            </p>

            <div class="post-additional-info inline-items">

              <a href="#" class="post-add-icon inline-items">
                <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
                <span>24</span>
              </a>

              <ul class="friends-harmonic">
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic7.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic8.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic9.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic10.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic11.jpg" alt="friend">
                  </a>
                </li>
              </ul>

              <div class="names-people-likes">
                <a href="#">You</a>, <a href="#">Elaine</a> and
                <br>22 more liked this
              </div>


              <div class="comments-shared">
                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-speech-balloon-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-speech-balloon-icon"></use></svg>
                  <span>17</span>
                </a>

                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
                  <span>24</span>
                </a>
              </div>


            </div>

            <div class="control-block-button post-control-button">

              <a href="#" class="btn btn-control">
                <svg class="olymp-like-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-like-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
              </a>

            </div>

          </article>

          <ul class="comments-list">
            <li>
              <div class="post__author author vcard inline-items">
                <img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">

                <div class="author-date">
                  <a class="h6 post__author-name fn" href="02-ProfilePage.html">James Spiegel</a>
                  <div class="post__date">
                    <time class="published" datetime="2004-07-24T18:18">
                      38 mins ago
                    </time>
                  </div>
                </div>

                <a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

              </div>

              <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium der doloremque laudantium.</p>

              <a href="#" class="post-add-icon inline-items">
                <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
                <span>3</span>
              </a>
              <a href="#" class="reply">Reply</a>
            </li>
            <li>
              <div class="post__author author vcard inline-items">
                <img src="<%=application.getContextPath()%>/resources/img/avatar1-sm.jpg" alt="author">

                <div class="author-date">
                  <a class="h6 post__author-name fn" href="#">Mathilda Brinker</a>
                  <div class="post__date">
                    <time class="published" datetime="2004-07-24T18:18">
                      1 hour ago
                    </time>
                  </div>
                </div>

                <a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

              </div>

              <p>Ratione voluptatem sequi en lod nesciunt. Neque porro quisquam est, quinder dolorem ipsum
                quia dolor sit amet, consectetur adipisci velit en lorem ipsum duis aute irure dolor in reprehenderit in voluptate velit esse cillum.
              </p>

              <a href="#" class="post-add-icon inline-items">
                <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
                <span>8</span>
              </a>
              <a href="#" class="reply">Reply</a>
            </li>
          </ul>

          <a href="#" class="more-comments">View more comments <span>+</span></a>

          <form class="comment-form inline-items">

            <div class="post__author author vcard inline-items">
              <img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">

              <div class="form-group with-icon-right ">
                <textarea class="form-control" placeholder=""  ></textarea>
                <div class="add-options-message">
                  <a href="#" class="options-message" data-toggle="modal" data-target="#update-header-photo">
                    <svg class="olymp-camera-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-camera-icon"></use></svg>
                  </a>
                </div>
              </div>
            </div>

          </form>

        </div>

        <div class="ui-block">
          <article class="hentry post has-post-thumbnail">

            <div class="post__author author vcard inline-items">
              <img src="<%=application.getContextPath()%>/resources/img/avatar5-sm.jpg" alt="author">

              <div class="author-date">
                <a class="h6 post__author-name fn" href="#">Green Goo Rock</a>
                <div class="post__date">
                  <time class="published" datetime="2004-07-24T18:18">
                    March 8 at 6:42pm
                  </time>
                </div>
              </div>

              <div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                <ul class="more-dropdown">
                  <li>
                    <a href="#">Edit Post</a>
                  </li>
                  <li>
                    <a href="#">Delete Post</a>
                  </li>
                  <li>
                    <a href="#">Turn Off Notifications</a>
                  </li>
                  <li>
                    <a href="#">Select as Featured</a>
                  </li>
                </ul>
              </div>

            </div>

            <p>Hey guys! We are gona be playing this Saturday of <a href="#">The Marina Bar</a> for their new Mystic Deer Party.
              If you wanna hang out and have a really good time, come and join us. We’l be waiting for you!
            </p>

            <div class="post-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/post__thumb1.jpg" alt="photo">
            </div>

            <div class="post-additional-info inline-items">

              <a href="#" class="post-add-icon inline-items">
                <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
                <span>49</span>
              </a>

              <ul class="friends-harmonic">
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic9.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic10.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic7.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic8.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic11.jpg" alt="friend">
                  </a>
                </li>
              </ul>

              <div class="names-people-likes">
                <a href="#">Jimmy</a>, <a href="#">Andrea</a> and
                <br>47 more liked this
              </div>


              <div class="comments-shared">
                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-speech-balloon-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-speech-balloon-icon"></use></svg>
                  <span>264</span>
                </a>

                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
                  <span>37</span>
                </a>
              </div>


            </div>

            <div class="control-block-button post-control-button">

              <a href="#" class="btn btn-control">
                <svg class="olymp-like-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-like-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
              </a>

            </div>

          </article>
        </div>

        <div class="ui-block">
          <article class="hentry post has-post-thumbnail">

            <div class="post__author author vcard inline-items">
              <img src="<%=application.getContextPath()%>/resources/img/avatar3-sm.jpg" alt="author">

              <div class="author-date">
                <a class="h6 post__author-name fn" href="#">Sarah Hetfield</a>
                <div class="post__date">
                  <time class="published" datetime="2004-07-24T18:18">
                    March 2 at 9:06am
                  </time>
                </div>
              </div>

              <div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                <ul class="more-dropdown">
                  <li>
                    <a href="#">Edit Post</a>
                  </li>
                  <li>
                    <a href="#">Delete Post</a>
                  </li>
                  <li>
                    <a href="#">Turn Off Notifications</a>
                  </li>
                  <li>
                    <a href="#">Select as Featured</a>
                  </li>
                </ul>
              </div>

            </div>

            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
              pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
              mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque.
            </p>

            <div class="post-additional-info inline-items">

              <a href="#" class="post-add-icon inline-items">
                <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
                <span>0 Likes</span>
              </a>

              <div class="comments-shared">
                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-speech-balloon-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-speech-balloon-icon"></use></svg>
                  <span>0 Comments</span>
                </a>

                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
                  <span>2 Shares</span>
                </a>
              </div>


            </div>

            <div class="control-block-button post-control-button">

              <a href="#" class="btn btn-control">
                <svg class="olymp-like-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-like-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
              </a>

            </div>

          </article>
        </div>

        <div class="ui-block">
          <article class="hentry post has-post-thumbnail">

            <div class="post__author author vcard inline-items">
              <img src="<%=application.getContextPath()%>/resources/img/avatar2-sm.jpg" alt="author">

              <div class="author-date">
                <a class="h6 post__author-name fn" href="#">Nicholas Grissom</a>
                <div class="post__date">
                  <time class="published" datetime="2004-07-24T18:18">
                    March 2 at 8:34am
                  </time>
                </div>
              </div>

              <div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
                <ul class="more-dropdown">
                  <li>
                    <a href="#">Edit Post</a>
                  </li>
                  <li>
                    <a href="#">Delete Post</a>
                  </li>
                  <li>
                    <a href="#">Turn Off Notifications</a>
                  </li>
                  <li>
                    <a href="#">Select as Featured</a>
                  </li>
                </ul>
              </div>

            </div>

            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
              pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
              mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem
              accusantium doloremque.
            </p>

            <div class="post-additional-info inline-items">

              <a href="#" class="post-add-icon inline-items">
                <svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
                <span>22</span>
              </a>

              <ul class="friends-harmonic">
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic9.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic10.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic7.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic8.jpg" alt="friend">
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="<%=application.getContextPath()%>/resources/img/friend-harmonic11.jpg" alt="friend">
                  </a>
                </li>
              </ul>

              <div class="names-people-likes">
                <a href="#">Jimmy</a>, <a href="#">Andrea</a> and
                <br>47 more liked this
              </div>


              <div class="comments-shared">
                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-speech-balloon-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-speech-balloon-icon"></use></svg>
                  <span>0</span>
                </a>

                <a href="#" class="post-add-icon inline-items">
                  <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
                  <span>2</span>
                </a>
              </div>


            </div>

            <div class="control-block-button post-control-button">

              <a href="#" class="btn btn-control">
                <svg class="olymp-like-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-like-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
              </a>

              <a href="#" class="btn btn-control">
                <svg class="olymp-share-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-share-icon"></use></svg>
              </a>

            </div>

          </article>
        </div>

      </div>
      <%-- 피드 목록 끝 --%>
      <%-- 더보기 버튼 --%>
      <a id="load-more-button" href="#" class="btn btn-control btn-more" data-load-link="items-to-load.html" data-container="newsfeed-items-grid"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>
    </main>

    <!-- ... end Main Content -->

    <!-- Left Sidebar -->
    <aside class="col-xl-3 order-xl-1 col-lg-6 order-lg-2 col-md-6 col-sm-12 col-xs-12">
      <%-- 내 정보 위젯 --%> 
      <jsp:include page="widgets/profile-info.jsp"></jsp:include>
      <%-- 내 주식정보 위젯 --%> 
      <jsp:include page="widgets/twitter-feed.jsp"></jsp:include> 
      <%-- 모의 투자 랭킹 위젯 --%> 
      <jsp:include page="widgets/ranking.jsp"></jsp:include>
    </aside>
    <!-- ... end Left Sidebar -->

    <!-- Right Sidebar -->
    <aside class="col-xl-3 order-xl-3 col-lg-6 order-lg-3 col-md-6 col-sm-12 col-xs-12">
      <%-- 관심 종목 위젯--%>
      <jsp:include page="widgets/activity-feed.jsp"></jsp:include>
      <%-- 팔로잉, 팔로워 --%>
      <jsp:include page="widgets/follow.jsp"></jsp:include>
      
      <%-- 추천 페이지 위젯인데 우리도 추천 계정 해주면 좋을듯.. --%> 
      <%-- <jsp:include page="widgets/recommend-page.jsp"></jsp:include> --%> 
      <%-- 추천 친구 위젯인데 이것도..? --%> 
      <%-- <jsp:include page="widgets/recommend-friend.jsp"></jsp:include> --%> 
    </aside>
    <!-- ... end Right Sidebar -->
  </div>
</div>


<!-- Window-popup Update Header Photo -->
<jsp:include page="popup/upload-photo.jsp"></jsp:include> 
<!-- ... end Window-popup Update Header Photo -->

<!-- Window-popup Choose from my Photo -->
<jsp:include page="popup/choose-from-my-photo.jsp"></jsp:include> 
<!-- ... end Window-popup Choose from my Photo -->

<!-- Window-popup-CHAT for responsive min-width: 768px -->
<jsp:include page="popup/popup-chat.jsp"></jsp:include> 
<!-- ... end Window-popup-CHAT for responsive min-width: 768px -->

<!-- Include js -->
<jsp:include page="includes/bottom.jsp"></jsp:include> 
<!-- End Include js -->

</body>
</html>