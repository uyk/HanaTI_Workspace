<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Profile Page</title>
  <jsp:include page="../includes/head.jsp"></jsp:include> 
</head>
<body class="mobile-app">

<!-- Fixed Sidebar Left -->

<div class="fixed-sidebar fixed-sidebar-responsive">

	<div class="fixed-sidebar-left sidebar--small" id="sidebar-left">
		<a href="#" class="logo js-sidebar-open">
			<img src="<%=application.getContextPath()%>/resources/img/logo.png" alt="Olympus">
		</a>

	</div>

	<div class="fixed-sidebar-left sidebar--large" id="sidebar-left-1">
		<a href="#" class="logo">
			<img src="<%=application.getContextPath()%>/resources/img/logo.png" alt="Olympus">
			<h6 class="logo-title">olympus</h6>
		</a>

		<div class="mCustomScrollbar" data-mcs-theme="dark">

			<div class="ui-block-title ui-block-title-small">
				<h6 class="title">MAIN SECTIONS</h6>
			</div>

			<ul class="left-menu">
				<li>
					<a href="#" class="js-sidebar-open">
						<svg class="olymp-close-icon left-menu-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-close-icon"></use></svg>
						<span class="left-menu-title">Collapse Menu</span>
					</a>
				</li>
				<li>
					<a href="mobile-index.html">
						<svg class="olymp-newsfeed-icon left-menu-icon" data-toggle="tooltip" data-placement="right"   data-original-title="NEWSFEED"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-newsfeed-icon"></use></svg>
						<span class="left-menu-title">Newsfeed</span>
					</a>
				</li>
				<li>
					<a href="Mobile-28-YourAccount-PersonalInformation.html">
						<svg class="olymp-star-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="FAV PAGE"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-star-icon"></use></svg>
						<span class="left-menu-title">Fav Pages Feed</span>
					</a>
				</li>
				<li>
					<a href="mobile-29-YourAccount-AccountSettings.html">
						<svg class="olymp-happy-faces-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="FRIEND GROUPS"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-faces-icon"></use></svg>
						<span class="left-menu-title">Friend Groups</span>
					</a>
				</li>
				<li>
					<a href="Mobile-30-YourAccount-ChangePassword.html">
						<svg class="olymp-headphones-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="MUSIC&PLAYLISTS"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-headphones-icon"></use></svg>
						<span class="left-menu-title">Music & Playlists</span>
					</a>
				</li>
				<li>
					<a href="Mobile-31-YourAccount-HobbiesAndInterests.html">
						<svg class="olymp-weather-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="WEATHER APP"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-weather-icon"></use></svg>
						<span class="left-menu-title">Weather App</span>
					</a>
				</li>
				<li>
					<a href="Mobile-32-YourAccount-EducationAndEmployement.html">
						<svg class="olymp-calendar-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="CALENDAR AND EVENTS"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-calendar-icon"></use></svg>
						<span class="left-menu-title">Calendar and Events</span>
					</a>
				</li>
				<li>
					<a href="Mobile-33-YourAccount-Notifications.html">
						<svg class="olymp-badge-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="Community Badges"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-badge-icon"></use></svg>
						<span class="left-menu-title">Community Badges</span>
					</a>
				</li>
				<li>
					<a href="Mobile-34-YourAccount-ChatMessages.html">
						<svg class="olymp-cupcake-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="Friends Birthdays"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-cupcake-icon"></use></svg>
						<span class="left-menu-title">Friends Birthdays</span>
					</a>
				</li>
				<li>
					<a href="Mobile-35-YourAccount-FriendsRequests.html">
						<svg class="olymp-stats-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="Account Stats"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-stats-icon"></use></svg>
						<span class="left-menu-title">Account Stats</span>
					</a>
				</li>
				<li>
					<a href="#">
						<svg class="olymp-manage-widgets-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="Manage Widgets"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-manage-widgets-icon"></use></svg>
						<span class="left-menu-title">Manage Widgets</span>
					</a>
				</li>
			</ul>

			<div class="ui-block-title ui-block-title-small">
				<h6 class="title">YOUR ACCOUNT</h6>
			</div>

			<ul class="account-settings">
				<li>
					<a href="#">

						<svg class="olymp-menu-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-menu-icon"></use></svg>

						<span>Profile Settings</span>
					</a>
				</li>
				<li>
					<a href="#">
						<svg class="olymp-star-icon left-menu-icon"  data-toggle="tooltip" data-placement="right"   data-original-title="FAV PAGE"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-star-icon"></use></svg>

						<span>Create Fav Page</span>
					</a>
				</li>
				<li>
					<a href="#">
						<svg class="olymp-logout-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-logout-icon"></use></svg>

						<span>Log Out</span>
					</a>
				</li>
			</ul>

			<div class="ui-block-title ui-block-title-small">
				<h6 class="title">About Olympus</h6>
			</div>

			<ul class="about-olympus">
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

		</div>
	</div>
</div>

<!-- ... end Fixed Sidebar Left -->


<!-- Fixed Sidebar Right -->

<div class="fixed-sidebar right fixed-sidebar-responsive">

	<div class="fixed-sidebar-right sidebar--small" id="sidebar-right">

		<a href="#" class="olympus-chat inline-items js-sidebar-open">
			<svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
		</a>

	</div>


	<div class="fixed-sidebar-right sidebar--large" id="sidebar-right-1">

		<a href="#" class="olympus-chat inline-items">
			<h6 class="olympus-chat-title">OLYMPUS CHAT</h6>
			<svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
		</a>

		<div class="search-friend inline-items">
			<form class="form-group">
				<input class="form-control" placeholder="Search Friends..." value="" type="text">
			</form>

			<a href="#" class="settings">
				<svg class="olymp-settings-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-settings-icon"></use></svg>
			</a>

			<a href="#" class="js-sidebar-open">
				<svg class="olymp-close-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-close-icon"></use></svg>
			</a>
		</div>
		<div class="mCustomScrollbar" data-mcs-theme="dark">

			<div class="ui-block-title ui-block-title-small">
				<h6 class="title">Chat Settings</h6>
			</div>

			<ul class="chat-settings">
				<li>
					<a href="#">
						<span class="icon-status online"></span>
						<span>Online</span>
					</a>
				</li>
				<li>
					<a href="#">
						<span class="icon-status away"></span>
						<span>Away</span>
					</a>
				</li>
				<li>
					<a href="#">
						<span class="icon-status disconected"></span>
						<span>Disconnected</span>
					</a>
				</li>

				<li>
					<a href="#">
						<span class="icon-status status-invisible"></span>
						<span>Invisible</span>
					</a>
				</li>
			</ul>

			<div class="ui-block-title ui-block-title-small">
				<h6 class="title">Custom Status</h6>
			</div>

			<form class="form-group with-button custom-status">
				<input class="form-control" placeholder="" value="Space Cowboy" type="text">

				<button class="bg-purple">
					<svg class="olymp-check-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-check-icon"></use></svg>
				</button>

			</form>



			<div class="ui-block-title ui-block-title-small">
				<a href="#" class="title">Close Friends</a>
				<a href="#">Settings</a>
			</div>

			<ul class="chat-users">
				<li class="inline-items">

					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar67-sm.jpg" class="avatar">
						<span class="icon-status online"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Carol Summers</a>
						<span class="status">ONLINE</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>

				</li>
				<li class="inline-items">

					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar62-sm.jpg" class="avatar">
						<span class="icon-status online"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Mathilda Brinker</a>
						<span class="status">AT WORK!</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>

				</li>

				<li class="inline-items">


					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar68-sm.jpg" class="avatar">
						<span class="icon-status online"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Carol Summers</a>
						<span class="status">ONLINE</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>


				</li>

				<li class="inline-items">


					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar69-sm.jpg" class="avatar">
						<span class="icon-status away"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Michael Maximoff</a>
						<span class="status">AWAY</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>


				</li>

				<li class="inline-items">


					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar70-sm.jpg" class="avatar">
						<span class="icon-status disconected"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Rachel Howlett</a>
						<span class="status">OFFLINE</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>


				</li>
			</ul>


			<div class="ui-block-title ui-block-title-small">
				<a href="#" class="title">MY FAMILY</a>
				<a href="#">Settings</a>
			</div>

			<ul class="chat-users">
				<li class="inline-items">

					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar64-sm.jpg" class="avatar">
						<span class="icon-status online"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Sarah Hetfield</a>
						<span class="status">ONLINE</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>
				</li>
			</ul>


			<div class="ui-block-title ui-block-title-small">
				<a href="#" class="title">UNCATEGORIZED</a>
				<a href="#">Settings</a>
			</div>

			<ul class="chat-users">
				<li class="inline-items">

					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar71-sm.jpg" class="avatar">
						<span class="icon-status online"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Bruce Peterson</a>
						<span class="status">ONLINE</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>


				</li>
				<li class="inline-items">

					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar72-sm.jpg" class="avatar">
						<span class="icon-status away"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Chris Greyson</a>
						<span class="status">AWAY</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>

				</li>
				<li class="inline-items">

					<div class="author-thumb">
						<img alt="author" src="<%=application.getContextPath()%>/resources/img/avatar63-sm.jpg" class="avatar">
						<span class="icon-status status-invisible"></span>
					</div>

					<div class="author-status">
						<a href="#" class="h6 author-name">Nicholas Grisom</a>
						<span class="status">INVISIBLE</span>
					</div>

					<div class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg>

						<ul class="more-icons">
							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="START CONVERSATION" class="olymp-comments-post-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-comments-post-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="ADD TO CONVERSATION" class="olymp-add-to-conversation-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-add-to-conversation-icon"></use></svg>
							</li>

							<li>
								<svg data-toggle="tooltip" data-placement="top" data-original-title="BLOCK FROM CHAT" class="olymp-block-from-chat-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-block-from-chat-icon"></use></svg>
							</li>
						</ul>

					</div>
				</li>
			</ul>

		</div>


	</div>

</div>

<!-- ... end Fixed Sidebar Right -->


<!-- Header -->

<header class="header header-responsive" id="site-header">

	<div class="header-content-wrapper">
		<form class="search-bar w-search notification-list friend-requests">
			<div class="form-group with-button">
				<input class="form-control js-user-search" placeholder="Search..." type="text">
				<button>
					<svg class="olymp-magnifying-glass-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-magnifying-glass-icon"></use></svg>
				</button>
			</div>
		</form>
	</div>

</header>

<!-- ... end Header -->


<div class="header-spacer header-spacer-small"></div>


<!-- Tabs App Mobile -->

<ul class="nav nav-tabs mobile-app-tabs" role="tablist">
	<li class="nav-item">
		<a class="nav-link active" data-toggle="tab" href="#profile-author" role="tab">
			<div class="author-thumb">
				<img alt="author" src="<%=application.getContextPath()%>/resources/img/author-page.jpg" class="avatar">
				<span class="icon-status online"></span>
			</div>
		</a>
	</li>

	<li class="nav-item">
		<a class="nav-link" data-toggle="tab" href="#newsfeed" role="tab">
			<svg class="olymp-newsfeed-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-newsfeed-icon"></use></svg>
		</a>
	</li>

	<li class="nav-item">
		<a class="nav-link" data-toggle="tab" href="#request" role="tab">
			<div class="control-icon has-items">
				<svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
				<div class="label-avatar bg-blue">6</div>
			</div>
		</a>
	</li>

	<li class="nav-item">
		<a class="nav-link" data-toggle="tab" href="#chat" role="tab">
			<div class="control-icon has-items">
				<svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
				<div class="label-avatar bg-purple">2</div>
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

<!-- ... end Tabs App Mobile -->


<!-- Tab panes -->
<div class="tab-content">
	<div class="tab-pane active" id="profile-author" role="tabpanel">
		<!-- Top Header -->


		<div class="ui-block">
			<div class="top-header">
				<div class="top-header-thumb">
					<img src="<%=application.getContextPath()%>/resources/img/top-header1.jpg" alt="nature">
				</div>
				<div class="profile-section">
					<div class="top-header-author">
						<a href="#" class="author-thumb">
							<img src="<%=application.getContextPath()%>/resources/img/author-main1.jpg" alt="author">
						</a>
						<div class="author-content">
							<a href="#" class="h4 author-name">James Spiegel</a>
							<div class="country">San Francisco, CA</div>
						</div>
					</div>

					<div class="control-block-button">
						<a href="#" class="btn btn-control bg-blue">
							<svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
						</a>
						<a href="#" class="btn btn-control bg-purple">
							<svg class="olymp-chat---messages-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-chat---messages-icon"></use></svg>
						</a>
						<div class="btn btn-control bg-primary more">
							<svg class="olymp-settings-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-settings-icon"></use></svg>
							<ul class="more-dropdown more-with-triangle triangle-bottom-right">
								<li>
									<a href="#" data-toggle="modal" data-target="#update-header-photo">Update Profile Photo</a>
								</li>
								<li>
									<a href="#" data-toggle="modal" data-target="#update-header-photo">Update Header Photo</a>
								</li>
								<li>
									<a href="#">Account Settings</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- ... end Top Header -->

		<div class="ui-block align-center">
			<div class="ui-block-title">
				<div class="h6 title">Timeline</div>
				<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>
			</div>
		</div>

		<div class="ui-block mobile-margin-25">
			<div class="ui-block-title">
				<h6 class="title">Last Photos</h6>
			</div>
			<div class="ui-block-content">
				<ul class="widget w-last-photo js-zoom-gallery">
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-photo10-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-photo10-large.jpg" alt="photo">
						</a>
					</li>
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-phot11-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-phot11-large.jpg" alt="photo">
						</a>
					</li>
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-phot12-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-phot12-large.jpg" alt="photo">
						</a>
					</li>
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-phot13-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-phot13-large.jpg" alt="photo">
						</a>
					</li>
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-phot14-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-phot14-large.jpg" alt="photo">
						</a>
					</li>
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-phot15-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-phot15-large.jpg" alt="photo">
						</a>
					</li>
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-phot16-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-phot16-large.jpg" alt="photo">
						</a>
					</li>
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-phot17-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-phot17-large.jpg" alt="photo">
						</a>
					</li>
					<li>
						<a href="<%=application.getContextPath()%>/resources/img/last-phot18-large.jpg">
							<img src="<%=application.getContextPath()%>/resources/img/last-phot18-large.jpg" alt="photo">
						</a>
					</li>
				</ul>
			</div>
		</div>

		<div id="newsfeed-items-grid">
			<div class="ui-block">
				<article class="hentry post">

					<div class="post__author author vcard inline-items">
						<img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">

						<div class="author-date">
							<a class="h6 post__author-name fn" href="#">James Spiegel</a>
							<div class="post__date">
								<time class="published" datetime="2017-03-24T18:18">
									19 hours ago
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
							<span>8</span>
						</a>

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

						<a href="#" class="btn btn-control featured-post">
							<svg class="olymp-trophy-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-trophy-icon"></use></svg>
						</a>

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
				<article class="hentry post video">

					<div class="post__author author vcard inline-items">
						<img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">

						<div class="author-date">
							<a class="h6 post__author-name fn" href="#">James Spiegel</a> shared a <a href="#">link</a>
							<div class="post__date">
								<time class="published" datetime="2017-03-24T18:18">
									7 hours ago
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

					<p>If someone missed it, check out the new song by System of a Revenge! I thinks they are going back to their roots...</p>

					<div class="post-video">
						<div class="video-thumb">
							<img src="<%=application.getContextPath()%>/resources/img/video5-m.jpg" alt="photo">
							<a href="https://youtube.com/watch?v=excVFQ2TWig" class="play-video play-video--mobile">
								<svg class="olymp-play-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-play-icon"></use></svg>
							</a>
						</div>

						<div class="video-content">
							<a href="#" class="h5 title">System of a Revenge - Nothing Else Matters... </a>
							<a href="#" class="link-site">YOUTUBE.COM</a>
						</div>
					</div>

					<div class="post-additional-info inline-items">

						<a href="#" class="post-add-icon inline-items">
							<svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
							<span>15</span>
						</a>

						<div class="comments-shared">
							<a href="#" class="post-add-icon inline-items">
								<svg class="olymp-speech-balloon-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-speech-balloon-icon"></use></svg>
								<span>1</span>
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

				<ul class="comments-list">
					<li>
						<div class="post__author author vcard inline-items">
							<img src="<%=application.getContextPath()%>/resources/img/avatar10-sm.jpg" alt="author">

							<div class="author-date">
								<a class="h6 post__author-name fn" href="#">Elaine Dreyfuss</a>
								<div class="post__date">
									<time class="published" datetime="2017-03-24T18:18">
										5 mins ago
									</time>
								</div>
							</div>

							<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

						</div>

						<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium der doloremque laudantium.</p>

						<a href="#" class="post-add-icon inline-items">
							<svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
							<span>8</span>
						</a>
						<a href="#" class="reply">Reply</a>
					</li>
					<li class="has-children">
						<div class="post__author author vcard inline-items">
							<img src="<%=application.getContextPath()%>/resources/img/avatar5-sm.jpg" alt="author">

							<div class="author-date">
								<a class="h6 post__author-name fn" href="#">Green Goo Rock</a>
								<div class="post__date">
									<time class="published" datetime="2017-03-24T18:18">
										1 hour ago
									</time>
								</div>
							</div>

							<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

						</div>

						<p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugiten, sed quia
							consequuntur magni dolores eos qui ratione voluptatem sequi en lod nesciunt. Neque porro
							quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur adipisci velit en lorem ipsum der.
						</p>

						<a href="#" class="post-add-icon inline-items">
							<svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
							<span>5</span>
						</a>
						<a href="#" class="reply">Reply</a>

						<ul class="children">
							<li>
								<div class="post__author author vcard inline-items">
									<img src="<%=application.getContextPath()%>/resources/img/avatar8-sm.jpg" alt="author">

									<div class="author-date">
										<a class="h6 post__author-name fn" href="#">Diana Jameson</a>
										<div class="post__date">
											<time class="published" datetime="2017-03-24T18:18">
												39 mins ago
											</time>
										</div>
									</div>

									<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

								</div>

								<p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>

								<a href="#" class="post-add-icon inline-items">
									<svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
									<span>2</span>
								</a>
								<a href="#" class="reply">Reply</a>
							</li>
							<li>
								<div class="post__author author vcard inline-items">
									<img src="<%=application.getContextPath()%>/resources/img/avatar2-sm.jpg" alt="author">

									<div class="author-date">
										<a class="h6 post__author-name fn" href="#">Nicholas Grisom</a>
										<div class="post__date">
											<time class="published" datetime="2017-03-24T18:18">
												24 mins ago
											</time>
										</div>
									</div>

									<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

								</div>

								<p>Excepteur sint occaecat cupidatat non proident.</p>

								<a href="#" class="post-add-icon inline-items">
									<svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
									<span>0</span>
								</a>
								<a href="#" class="reply">Reply</a>

							</li>
						</ul>

					</li>



					<li>
						<div class="post__author author vcard inline-items">
							<img src="<%=application.getContextPath()%>/resources/img/avatar4-sm.jpg" alt="author">

							<div class="author-date">
								<a class="h6 post__author-name fn" href="#">Chris Greyson</a>
								<div class="post__date">
									<time class="published" datetime="2017-03-24T18:18">
										1 hour ago
									</time>
								</div>
							</div>

							<a href="#" class="more"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

						</div>

						<p>Dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit.</p>

						<a href="#" class="post-add-icon inline-items">
							<svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
							<span>7</span>
						</a>
						<a href="#" class="reply">Reply</a>

					</li>
				</ul>

				<a href="#" class="more-comments">View more comments <span>+</span></a>

				<form class="comment-form inline-items">

					<div class="post__author author vcard inline-items">
						<img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">
						<div class="form-group with-icon-right ">
							<textarea class="form-control" placeholder=""></textarea>
							<div class="add-options-message">
								<a href="#" class="options-message" data-toggle="modal" data-target="#update-header-photo">
									<svg class="olymp-camera-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-camera-icon"></use></svg>
								</a>
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>

		<a id="load-more-button" href="#" class="btn btn-control btn-more" data-load-link="items-to-load.html" data-container="newsfeed-items-grid"><svg class="olymp-three-dots-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-three-dots-icon"></use></svg></a>

	</div>

	<div class="tab-pane " id="newsfeed" role="tabpanel">
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
						</a>
					</li>

					<li class="nav-item">
						<a class="nav-link inline-items" data-toggle="tab" href="#blog" role="tab" aria-expanded="false">
							<svg class="olymp-blog-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-blog-icon"></use></svg>
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
									<svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
								</a>

								<a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD LOCATION">
									<svg class="olymp-small-pin-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-small-pin-icon"></use></svg>
								</a>

								<button class="btn btn-primary btn-md-2">Post Status</button>

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
									<svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
								</a>

								<a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD LOCATION">
									<svg class="olymp-small-pin-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-small-pin-icon"></use></svg>
								</a>

								<button class="btn btn-primary btn-md-2">Post Status</button>

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
									<svg class="olymp-happy-face-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-happy-face-icon"></use></svg>
								</a>

								<a href="#" class="options-message" data-toggle="tooltip" data-placement="top"   data-original-title="ADD LOCATION">
									<svg class="olymp-small-pin-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-small-pin-icon"></use></svg>
								</a>

								<button class="btn btn-primary btn-md-2">Post Status</button>

							</div>

						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="ui-block">
			<article class="hentry post video">

				<div class="post__author author vcard inline-items">
					<img src="<%=application.getContextPath()%>/resources/img/author-page.jpg" alt="author">

					<div class="author-date">
						<a class="h6 post__author-name fn" href="#">James Spiegel </a> shared a <a href="#">link</a>
						<div class="post__date">
							<time class="published" datetime="2017-03-24T18:18">
								7 hours ago
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

				<p>Hey <a href="#">Chris</a>! here’s the new article I was talking you about. Check it out!</p>

				<div class="post-video">
					<div class="video-thumb f-none">
						<img src="<%=application.getContextPath()%>/resources/img/post-video.jpg" alt="photo">
						<a href="https://youtube.com/watch?v=excVFQ2TWig" class="play-video">
							<svg class="olymp-play-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-play-icon"></use></svg>
						</a>
					</div>

					<div class="video-content">
						<a href="#" class="h4 title">The Secrets of the Auroris Movie Effects</a>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempo incididunt ut
							labore et dolore magna aliqua. Ut enim ad minim veniam, quis...
						</p>
						<a href="#" class="link-site">MOVIEMAG.COM</a>
					</div>
				</div>

				<div class="post-additional-info inline-items">

					<a href="#" class="post-add-icon inline-items">
						<svg class="olymp-heart-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-heart-icon"></use></svg>
						<span>15</span>
					</a>

					<div class="comments-shared">
						<a href="#" class="post-add-icon inline-items">
							<svg class="olymp-speech-balloon-icon"><use xlink:href="<%=application.getContextPath()%>/resources/icons/icons.svg#olymp-speech-balloon-icon"></use></svg>
							<span>1</span>
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
	</div>

	<div class="tab-pane " id="request" role="tabpanel">

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

	<div class="tab-pane " id="chat" role="tabpanel">

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

	<div class="tab-pane " id="notification" role="tabpanel">

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
<!-- ... end  Tab panes -->


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




<!-- Include js -->
<jsp:include page="../includes/bottom.jsp"></jsp:include> 
<!-- End Include js -->

</body>
</html>

