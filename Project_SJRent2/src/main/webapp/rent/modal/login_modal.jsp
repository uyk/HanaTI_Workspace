<%@ page contentType="text/html; charset=utf-8" %>
<%
  String id = null;
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("saveId")) {//아이디 저장 클릭한 경우 아이디 저장하기 위해 
        id = cookie.getValue();
      }
    }
  }
    // 초기화면 아이디 null시
    if(id == null){
      id = "";
    }
%>
<!DOCTYPE html>
<html>
<div class="row">
	<div class="tg-homeslider tg-homeslidervtwo tg-haslayout" >
			<h2 style="text-align: center; margin-bottom: 50px">로그인</h2>
			<div class="tg-themetabs" style="padding: 0px 150px">
				<ul class="tg-navtbs" role="tablist">
					<li role="presentation" class="active"><a href="#user" data-toggle="tab">회원</a></li>
					<li role="presentation"><a href="#new" data-toggle="tab">비회원</a></li>
				</ul>
				<div class="tg-tabcontent tab-content">
					<!--************************************
							회원 로그인 시작 
					*************************************-->
					<div role="tabpanel" class="tab-pane active fade in" id="user" >
          
						<form class="tg-formtheme tg-formlogin" action="/sjrent/user/login.rent" method="post">
							<fieldset>
								<div class="form-group">
									<label>아이디 <sup>*</sup></label>
									<input type="text" name="id" class="form-control" placeholder="" maxlength="10" style="text-transform:  none;" required value=<%=id %> >
								</div>
								<div class="form-group">
									<label>비밀번호 <sup>*</sup></label>
					                <input type="password" name="pw" class="form-control" placeholder="" maxlength="10"  style="text-transform:  none;" required>
								</div>
								<div class="form-group">
										<input type="checkbox" name="remember" id="rememberpass" style="display: inline-block; "><label for="rememberpass" style="display: inline-block; ">아이디 저장</label>
								</div>
								<button type="submit" class="tg-btn tg-btn-lg"><span>로그인</span></button>
							</fieldset>
						</form>
					</div>
					<!--************************************
							회원 로그인 종료 
					*************************************-->
					<!--************************************
							비회원 로그인 시작
					*************************************-->
					<div role="tabpanel" class="tab-pane fade" id="new">
						<form class="tg-formtheme tg-formlogin" action="/sjrent/user/signup.rent">
							<fieldset>
								<div class="form-group">
									<label>이름 <sup>*</sup></label>
									<input type="text" name="name_non" class="form-control" placeholder="" maxlength="10" style="text-transform: lowercase;" required>
								</div>
								<div class="form-group">
									<label>이메일 <sup>*</sup></label>
									<input type="text" name="email_non" class="form-control" placeholder="e.g. happy@gmail.com" maxlength="30" style="text-transform: lowercase;" required>
									<!--************************************
												예비용 시작
										*************************************-->
									<!-- <input type="text" name="email" maxlength="15" size="16" style="margin: 0px 8px"> @ 
									<input type="text" name="email" maxlength="10" size="16"  style="margin: 0px 8px">  
									<select style="width: 150px; margin: 0px 8px">
										<option>직접입력
										<option>naver.com
										<option>gmail.com
										<option>daum.net
										<option>hotmail.com
									</select> -->	
									<!--************************************
												예비용 종료
										*************************************-->
										
								</div>
								
								
								<div class="form-group">
									<label>핸드폰번호 <sup>*</sup></label>
									<input type="text" name="cellphone_non" class="form-control" placeholder="e.g. 010-1234-5678" maxlength="13" style="text-transform: lowercase;" required>
                  
									<!--************************************
												예비용 시작
										*************************************-->
									<!-- <div style="display: inline-block;">
										<select style="width: 110px">
											<option> 0 1 0 
											<option> 0 1 1
											<option> 0 1 7
											<option> 0 1 8
											<option> 0 1 9
										</select>  -
										<input type="text" size="11" maxlength="4">  -  
										<input type="text" size="11" maxlength="4">
									</div> -->
									<!--************************************
												예비용 종료
										*************************************-->
								</div>
								
                                       <div style="margin-top: 20px">
                                        <a href="<%=application.getContextPath()%>/user/regist.jsp" style="color: grey; float: right; ">아직 회원이 아니신가요?</a>   
                                       </div>
                
								
								 <button type="submit" class="tg-btn tg-btn-lg" style="display: inline-block;  vertical-align: middle; margin-top: 40px"><span>로그인</span></button>
									
							</fieldset>
						</form>
					</div>
					<!--************************************
							비회원 로그인 종료
					*************************************-->
			</div>
		</div>
	</div>
</div>
</html>