<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<form class="tg-formtheme tg-formlogin" action="/sjrent/mypage/login.rent" method="post">
		<fieldset style="padding: 20px 350px;">
			<p style="text-align: center;">
			고객님의 안전한 회원정보를 위해<br> 
			다시 한 번 로그인 해주시기 바랍니다.
			</p>																								
			<div class="form-group">
				<h6>
					아이디<sup>*</sup>
				</h6>
				<input type="text" name="id" class="form-control" placeholder=""
					maxlength="10" required style="text-transform: none">
			</div>
			<div class="form-group">
				<h6>
					비밀번호<sup>*</sup>
				</h6>
				<input type="password" name="pw" class="form-control" placeholder=""
					maxlength="10" required style="text-transform: none">
			</div>
			<div class="form-group">
				<div>
					<input type="checkbox" style="display: inline;">
					<h6 style="display: inline;">아이디저장</h6>
				</div>
			</div>
			<input id="loginB" type="submit" class="tg-btn tg-btn-lg"
				style="font-size: 12pt" value="로그인">
		</fieldset>
	</form>

</body>
</html>