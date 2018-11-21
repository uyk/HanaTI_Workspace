<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>Not Found :: KOSTA</title>
<style type="text/css">
* {margin:0;padding:0;}
#error_content {margin:0; padding:0;}
#error_content *{margin:0; padding:0; color:#444; list-style:none; font-size:12px; line-height:normal; font-family:돋움, Dotum, 굴림, Gulim, Helvetica, Sans-serif;}
#error_content img{border:none;}
#error_content a{text-decoration:none; color:#444;}
#error_content a:visited{text-decoration:none; color:#666;}
#error_content a:hover{text-decoration:underline;}
#error_content {width:294px; _width /**/:510px; height:206px; _height:208px; margin:0 auto; margin-top:50px; padding:0 0 0 214px; border:1px solid #e5e5e5; background:#FFF url(http://static.naver.com/common/error/bg_error_s.gif) no-repeat 32px 48px; text-align:left;}
#error_content h2 {margin:48px 0 14px 0; padding:0;}
#error_content p {margin:0; padding:0; color:#888; font:12px/1.5em 돋움,Dotum,Helvetica,sans-serif;}
#error_content p.btn {padding:15px 0 0 1px; font-size:0;}
#error_content p.btn img {margin-right:1px; *margin-right:1px;}
</style>
</head>
<body>
<div id="error_content">
	<h2>접근이 허가되지 않은 페이지입니다.</h2>
	<div>
		<p style="color:blue">${msg}</p>
	</div>
	<p class="btn">
	<input type="submit" value="이전 페이지" style="padding: 3px; color: #333333; border: 1px solid #ddd; margin: 5px 5px" onclick="history.back();"/>
	<input type="button" value="홈 페이지" style="padding: 3px; color: #333333; border: 1px solid #ddd;" onclick="location.href='/index.jsp'"/>
	</p>
</div>
</body>
</html>
