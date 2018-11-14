<%@ page contentType="text/html; charset=UTF-8"%>
<%
String loginId = (String)request.getAttribute("loginId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">


<title>MYPAGE</title>
</head>
<body>

	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="height:33%; ">
	   <h3 class="w3-bar-item" style="padding-left: 30px; vertical-align: middle;">Menu</h3>
	  <a href="/sjrent/rent/list.rent" class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px ">나의예약확인</a>
	  <a href="/sjrent/review/list2.rent" class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">나의리뷰</a>
	  <a href="/sjrent/user/read.rent"  class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">회원정보수정</a>
      <a href="/sjrent/mypage/deleteUser.jsp" class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">회원탈퇴</a>
	  <!-- <a data-toggle="modal" class="w3-bar-item w3-button" data-target="#dropModal" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">회원탈퇴</a> -->
	</div>
	
	
<!-- modal로 하려면 시작 -->
<!--  <div class="modal" tabindex="-1" role="dialog" id="dropModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">회원 탈퇴</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>정말 탈퇴 하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" onclick="deleteUser()">예</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">아니오</button>
      </div>
    </div>
  </div>
</div>  --> 
<!-- modal 종료 -->



</body>
</html>