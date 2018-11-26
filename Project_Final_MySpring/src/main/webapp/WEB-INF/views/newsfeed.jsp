<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Newsfeed</title>
  <jsp:include page="includes/head.jsp"></jsp:include> 
</head>
<body>

<!-- Fixed Sidebar Left -->
<jsp:include page="includes/fixed-sidebar-left.jsp"></jsp:include>
<!-- end Fixed Sidebar Left -->

<!-- Fixed Sidebar Right -->
<jsp:include page="includes/fixed-sidebar-right.jsp"></jsp:include>
<!-- ... end Fixed Sidebar Right -->

<!-- Header -->
<jsp:include page="includes/header.jsp">
  <jsp:param value="Newsfeed" name="PageName"/>
</jsp:include>
<!-- ... end Header -->

<div class="header-spacer"></div>


<div class="container">
  <div class="row">

    <!-- Main Content -->

    <main class="col-xl-6 order-xl-2 col-lg-12 order-lg-1 col-md-12 col-sm-12 col-xs-12">

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

                <span>Multimedia</span>
              </a>
            </li>

            <li class="nav-item">
              <a class="nav-link inline-items" data-toggle="tab" href="#blog" role="tab" aria-expanded="false">
                <svg class="olymp-blog-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-blog-icon"></use></svg>

                <span>Blog Post</span>
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


      <a id="load-more-button" href="#" class="btn btn-control btn-more" data-load-link="items-to-load.html" data-container="newsfeed-items-grid"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>


    </main>

    <!-- ... end Main Content -->


    <!-- Left Sidebar -->

    <aside class="col-xl-3 order-xl-1 col-lg-6 order-lg-2 col-md-6 col-sm-12 col-xs-12">
      <div class="ui-block">
        <div class="widget w-wethear">
          <a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

          <div class="wethear-now inline-items">
            <div class="temperature-sensor">64°</div>
            <div class="max-min-temperature">
              <span>58°</span>
              <span>76°</span>
            </div>

            <svg class="olymp-weather-partly-sunny-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons-weather.svg#olymp-weather-partly-sunny-icon"></use></svg>
          </div>

          <div class="wethear-now-description">
            <div class="climate">Partly Sunny</div>
            <span>Real Feel: <span>67°</span></span>
            <span>Chance of Rain: <span>49%</span></span>
          </div>

          <ul class="weekly-forecast">

            <li>
              <div class="day">sun</div>
              <svg class="olymp-weather-sunny-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons-weather.svg#olymp-weather-sunny-icon"></use></svg>

              <div class="temperature-sensor-day">60°</div>
            </li>

            <li>
              <div class="day">mon</div>
              <svg class="olymp-weather-partly-sunny-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons-weather.svg#olymp-weather-partly-sunny-icon"></use></svg>
              <div class="temperature-sensor-day">58°</div>
            </li>

            <li>
              <div class="day">tue</div>
              <svg class="olymp-weather-cloudy-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons-weather.svg#olymp-weather-cloudy-icon"></use></svg>

              <div class="temperature-sensor-day">67°</div>
            </li>

            <li>
              <div class="day">wed</div>
              <svg class="olymp-weather-rain-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons-weather.svg#olymp-weather-rain-icon"></use></svg>

              <div class="temperature-sensor-day">70°</div>
            </li>

            <li>
              <div class="day">thu</div>
              <svg class="olymp-weather-storm-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons-weather.svg#olymp-weather-storm-icon"></use></svg>

              <div class="temperature-sensor-day">58°</div>
            </li>

            <li>
              <div class="day">fri</div>
              <svg class="olymp-weather-snow-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons-weather.svg#olymp-weather-snow-icon"></use></svg>

              <div class="temperature-sensor-day">68°</div>
            </li>

            <li>
              <div class="day">sat</div>

              <svg class="olymp-weather-wind-icon-header"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons-weather.svg#olymp-weather-wind-icon-header"></use></svg>

              <div class="temperature-sensor-day">65°</div>
            </li>

          </ul>

          <div class="date-and-place">
            <h5 class="date">Saturday, March 26th</h5>
            <div class="place">San Francisco, CA</div>
          </div>

        </div>
      </div>


      <div class="ui-block">
        <div class="ui-block-title">
          <h6 class="title">Pages You May Like</h6>
          <a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>
        </div>

        <ul class="widget w-friend-pages-added notification-list friend-requests">
          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar41-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">The Marina Bar</a>
              <span class="chat-message-item">Restaurant / Bar</span>
            </div>
            <span class="notification-icon" data-toggle="tooltip" data-placement="top" title="ADD TO YOUR FAVS">
              <a href="#">
                <svg class="olymp-star-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-star-icon"></use></svg>
              </a>
            </span>

          </li>

          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar42-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Tapronus Rock</a>
              <span class="chat-message-item">Rock Band</span>
            </div>
            <span class="notification-icon" data-toggle="tooltip" data-placement="top" title="ADD TO YOUR FAVS">
              <a href="#">
                <svg class="olymp-star-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-star-icon"></use></svg>
              </a>
            </span>
          </li>

          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar43-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Pixel Digital Design</a>
              <span class="chat-message-item">Company</span>
            </div>
            <span class="notification-icon" data-toggle="tooltip" data-placement="top" title="ADD TO YOUR FAVS">
              <a href="#">
                <svg class="olymp-star-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-star-icon"></use></svg>
              </a>
            </span>
          </li>

          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar44-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Thompson’s Custom Clothing Boutique</a>
              <span class="chat-message-item">Clothing Store</span>
            </div>
            <span class="notification-icon" data-toggle="tooltip" data-placement="top" title="ADD TO YOUR FAVS">
              <a href="#">
                <svg class="olymp-star-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-star-icon"></use></svg>
              </a>
            </span>
          </li>

          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar45-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Crimson Agency</a>
              <span class="chat-message-item">Company</span>
            </div>
            <span class="notification-icon" data-toggle="tooltip" data-placement="top" title="ADD TO YOUR FAVS">
              <a href="#">
                <svg class="olymp-star-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-star-icon"></use></svg>
              </a>
            </span>
          </li>

          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar46-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Mannequin Angel</a>
              <span class="chat-message-item">Clothing Store</span>
            </div>
            <span class="notification-icon" data-toggle="tooltip" data-placement="top" title="ADD TO YOUR FAVS">
              <a href="#">
                <svg class="olymp-star-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-star-icon"></use></svg>
              </a>
            </span>
          </li>

        </ul>

      </div>
    </aside>

    <!-- ... end Left Sidebar -->


    <!-- Right Sidebar -->

    <aside class="col-xl-3 order-xl-3 col-lg-6 order-lg-3 col-md-6 col-sm-12 col-xs-12">

      <div class="ui-block">
        <div class="widget w-birthday-alert">
          <div class="<%=application.getContextPath()%>/resources/icons-block">
            <svg class="olymp-cupcake-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-cupcake-icon"></use></svg>
            <a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>
          </div>

          <div class="content">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar48-sm.jpg" alt="author">
            </div>
            <span>Today is</span>
            <a href="#" class="h4 title">Marina Valentine’s Birthday!</a>
            <p>Leave her a message with your best wishes on her profile page!</p>
          </div>
        </div>
      </div>


      <div class="ui-block">
        <div class="ui-block-title">
          <h6 class="title">Friend Suggestions</h6>
          <a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>
        </div>

        <ul class="widget w-friend-pages-added notification-list friend-requests">
          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar38-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Francine Smith</a>
              <span class="chat-message-item">8 Friends in Common</span>
            </div>
            <span class="notification-icon">
              <a href="#" class="accept-request">
                <span class="icon-add without-text">
                  <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                </span>
              </a>
            </span>

          </li>

          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar39-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Hugh Wilson</a>
              <span class="chat-message-item">6 Friends in Common</span>
            </div>
            <span class="notification-icon">
              <a href="#" class="accept-request">
                <span class="icon-add without-text">
                  <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                </span>
              </a>
            </span>

          </li>

          <li class="inline-items">
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar40-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Karen Masters</a>
              <span class="chat-message-item">6 Friends in Common</span>
            </div>
            <span class="notification-icon">
              <a href="#" class="accept-request">
                <span class="icon-add without-text">
                  <svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
                </span>
              </a>
            </span>

          </li>

        </ul>

      </div>

      <div class="ui-block">

        <div class="ui-block-title">
          <h6 class="title">Activity Feed</h6>
          <a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>
        </div>

        <ul class="widget w-activity-feed notification-list">
          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar49-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Marina Polson</a> commented on Jason Mark’s <a href="#" class="notification-link">photo.</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">2 mins ago</time></span>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar9-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Jake Parker </a> liked Nicholas Grissom’s <a href="#" class="notification-link">status update.</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">5 mins ago</time></span>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar50-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Mary Jane Stark </a> added 20 new photos to her <a href="#" class="notification-link">gallery album.</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">12 mins ago</time></span>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar51-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Nicholas Grissom </a> updated his profile <a href="#" class="notification-link">photo</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">1 hour ago</time></span>
            </div>
          </li>
          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar48-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Marina Valentine </a> commented on Chris Greyson’s <a href="#" class="notification-link">status update</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">1 hour ago</time></span>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar52-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Green Goo Rock </a> posted a <a href="#" class="notification-link">status update</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">1 hour ago</time></span>
            </div>
          </li>
          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar10-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Elaine Dreyfuss  </a> liked your <a href="#" class="notification-link">blog post</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">2 hours ago</time></span>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar10-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Elaine Dreyfuss  </a> commented on your <a href="#" class="notification-link">blog post</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">2 hours ago</time></span>
            </div>
          </li>

          <li>
            <div class="author-thumb">
              <img src="<%=application.getContextPath()%>/resources/img/avatar53-sm.jpg" alt="author">
            </div>
            <div class="notification-event">
              <a href="#" class="h6 notification-friend">Bruce Peterson </a> changed his <a href="#" class="notification-link">profile picture</a>.
              <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">15 hours ago</time></span>
            </div>
          </li> 

        </ul>
      </div>


      <div class="ui-block">
        <div class="widget w-action">

          <img src="<%=application.getContextPath()%>/resources/img/logo.png" alt="Olympus">
          <div class="content">
            <h4 class="title">OLYMPUS</h4>
            <span>THE BEST SOCIAL NETWORK THEME IS HERE!</span>
            <a href="01-LandingPage.html" class="btn btn-bg-secondary btn-md">Register Now!</a>
          </div>
        </div>
      </div>

    </aside>

    <!-- ... end Right Sidebar -->

  </div>
</div>


<!-- Window-popup Update Header Photo -->

<div class="modal fade" id="update-header-photo">
  <div class="modal-dialog ui-block window-popup update-header-photo">
    <a href="#" class="close icon-close" data-dismiss="modal" aria-label="Close">
      <svg class="olymp-close-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-close-icon"></use></svg>
    </a>

    <div class="ui-block-title">
      <h6 class="title">Update Header Photo</h6>
    </div>

    <a href="#" class="upload-photo-item">
      <svg class="olymp-computer-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-computer-icon"></use></svg>

      <h6>Upload Photo</h6>
      <span>Browse your computer.</span>
    </a>

    <a href="#" class="upload-photo-item" data-toggle="modal" data-target="#choose-from-my-photo">

      <svg class="olymp-photos-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-photos-icon"></use></svg>

      <h6>Choose from My Photos</h6>
      <span>Choose from your uploaded photos</span>
    </a>
  </div>
</div>


<!-- ... end Window-popup Update Header Photo -->


<!-- Window-popup Choose from my Photo -->
<div class="modal fade" id="choose-from-my-photo">
  <div class="modal-dialog ui-block window-popup choose-from-my-photo">
    <a href="#" class="close icon-close" data-dismiss="modal" aria-label="Close">
      <svg class="olymp-close-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-close-icon"></use></svg>
    </a>

    <div class="ui-block-title">
      <h6 class="title">Choose from My Photos</h6>

      <!-- Nav tabs -->
      <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
          <a class="nav-link active" data-toggle="tab" href="#home" role="tab" aria-expanded="true">
            <svg class="olymp-photos-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-photos-icon"></use></svg>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="tab" href="#profile" role="tab" aria-expanded="false">
            <svg class="olymp-albums-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-albums-icon"></use></svg>
          </a>
        </li>
      </ul>
    </div>


    <div class="ui-block-content">
      <!-- Tab panes -->
      <div class="tab-content">
        <div class="tab-pane active" id="home" role="tabpanel" aria-expanded="true">

          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo1.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo2.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo3.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>

          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo4.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo5.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo6.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>

          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo7.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo8.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <div class="radio">
              <label class="custom-radio">
                <img src="<%=application.getContextPath()%>/resources/img/choose-photo9.jpg" alt="photo">
                <input type="radio" name="optionsRadios">
              </label>
            </div>
          </div>


          <a href="#" class="btn btn-secondary btn-lg btn--half-width">Cancel</a>
          <a href="#" class="btn btn-primary btn-lg btn--half-width">Confirm Photo</a>

        </div>
        <div class="tab-pane" id="profile" role="tabpanel" aria-expanded="false">

          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo10.jpg" alt="photo">
              <figcaption>
                <a href="#">South America Vacations</a>
                <span>Last Added: 2 hours ago</span>
              </figcaption>
            </figure>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo11.jpg" alt="photo">
              <figcaption>
                <a href="#">Photoshoot Summer 2016</a>
                <span>Last Added: 5 weeks ago</span>
              </figcaption>
            </figure>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo12.jpg" alt="photo">
              <figcaption>
                <a href="#">Amazing Street Food</a>
                <span>Last Added: 6 mins ago</span>
              </figcaption>
            </figure>
          </div>

          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo13.jpg" alt="photo">
              <figcaption>
                <a href="#">Graffity & Street Art</a>
                <span>Last Added: 16 hours ago</span>
              </figcaption>
            </figure>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo14.jpg" alt="photo">
              <figcaption>
                <a href="#">Amazing Landscapes</a>
                <span>Last Added: 13 mins ago</span>
              </figcaption>
            </figure>
          </div>
          <div class="choose-photo-item" data-mh="choose-item">
            <figure>
              <img src="<%=application.getContextPath()%>/resources/img/choose-photo15.jpg" alt="photo">
              <figcaption>
                <a href="#">The Majestic Canyon</a>
                <span>Last Added: 57 mins ago</span>
              </figcaption>
            </figure>
          </div>


          <a href="#" class="btn btn-secondary btn-lg btn--half-width">Cancel</a>
          <a href="#" class="btn btn-primary btn-lg disabled btn--half-width">Confirm Photo</a>
        </div>
      </div>
    </div>

  </div>
</div>

<!-- ... end Window-popup Choose from my Photo -->

<!-- Window-popup-CHAT for responsive min-width: 768px -->

<div class="ui-block popup-chat popup-chat-responsive">
  <div class="ui-block-title">
    <span class="icon-status online"></span>
    <h6 class="title" >Chat</h6>
    <div class="more">
      <svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>
      <svg class="olymp-little-delete js-chat-open"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-little-delete"></use></svg>
    </div>
  </div>
  <div class="mCustomScrollbar">
    <ul class="notification-list chat-message chat-message-field">
      <li>
        <div class="author-thumb">
          <img src="<%=application.getContextPath()%>/resources/img/avatar14-sm.jpg" alt="author" class="mCS_img_loaded">
        </div>
        <div class="notification-event">
          <span class="chat-message-item">Hi James! Please remember to buy the food for tomorrow! I’m gonna be handling the gifts and Jake’s gonna get the drinks</span>
          <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">Yesterday at 8:10pm</time></span>
        </div>
      </li>

      <li>
        <div class="author-thumb">
          <img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author" class="mCS_img_loaded">
        </div>
        <div class="notification-event">
          <span class="chat-message-item">Don’t worry Mathilda!</span>
          <span class="chat-message-item">I already bought everything</span>
          <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">Yesterday at 8:29pm</time></span>
        </div>
      </li>

      <li>
        <div class="author-thumb">
          <img src="<%=application.getContextPath()%>/resources/img/avatar14-sm.jpg" alt="author" class="mCS_img_loaded">
        </div>
        <div class="notification-event">
          <span class="chat-message-item">Hi James! Please remember to buy the food for tomorrow! I’m gonna be handling the gifts and Jake’s gonna get the drinks</span>
          <span class="notification-date"><time class="entry-date updated" datetime="2004-07-24T18:18">Yesterday at 8:10pm</time></span>
        </div>
      </li>
    </ul>
  </div>

  <form>

    <div class="form-group label-floating is-empty">
      <label class="control-label">Press enter to post...</label>
      <textarea class="form-control" placeholder=""></textarea>
      <div class="add-options-message">
        <a href="#" class="options-message">
          <svg class="olymp-computer-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-computer-icon"></use></svg>
        </a>
        <div class="options-message smile-block">

          <svg class="olymp-happy-sticker-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-sticker-icon"></use></svg>

          <ul class="more-dropdown more-with-triangle triangle-bottom-right">
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat1.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat2.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat3.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat4.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat5.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat6.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat7.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat8.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat9.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat10.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat11.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat12.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat13.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat14.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat15.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat16.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat17.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat18.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat19.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat20.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat21.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat22.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat23.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat24.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat25.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat26.png" alt="icon">
              </a>
            </li>
            <li>
              <a href="#">
                <img src="<%=application.getContextPath()%>/resources/img/icon-chat27.png" alt="icon">
              </a>
            </li>
          </ul>
        </div>
      </div>
       </div>

  </form>


</div>

<!-- ... end Window-popup-CHAT for responsive min-width: 768px -->

<!-- jQuery first, then Other JS. -->
<script src="<%=application.getContextPath()%>/resources/js/jquery-3.2.0.min.js"></script>


<!-- Js effects for material design. + Tooltips -->
<script src="<%=application.getContextPath()%>/resources/js/material.min.js"></script>

<!-- Helper scripts (Tabs, Equal height, Scrollbar, etc) -->
<script src="<%=application.getContextPath()%>/resources/js/theme-plugins.js"></script>

<!-- Init functions -->
<script src="<%=application.getContextPath()%>/resources/js/main.js"></script>

<!-- Load more news AJAX script -->
<script src="<%=application.getContextPath()%>/resources/js/ajax-pagination.js"></script>

<!-- Select / Sorting script -->
<script src="<%=application.getContextPath()%>/resources/js/selectize.min.js"></script>

<!-- Datepicker input field script-->
<script src="<%=application.getContextPath()%>/resources/js/moment.min.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/daterangepicker.min.js"></script>

<!-- Widget with events script-->
<script src="<%=application.getContextPath()%>/resources/js/simplecalendar.js"></script>

<!-- Lightbox plugin script-->
<script src="<%=application.getContextPath()%>/resources/js/jquery.magnific-popup.min.js"></script>


<script src="<%=application.getContextPath()%>/resources/js/mediaelement-and-player.min.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/mediaelement-playlist-plugin.min.js"></script>

</body>
</html>