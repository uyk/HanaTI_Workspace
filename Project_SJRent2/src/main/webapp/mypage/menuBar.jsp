<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<!-- <div class="tg-tabcontent tab-content" style="padding-left: 50px"> -->
	 <!-- <div class="w3-bar w3-light-grey" style="width: 100%; text-align: center;">
		<a href="#" class="w3-bar-item w3-button" style="background-color: black; color: white;">예약리스트보기</a> 	
		<a href="#" class="w3-bar-item w3-button" style="background-color: black; color: white;">마이리뷰보기 </a> 
		<a href="#" class="w3-bar-item w3-button" style="background-color: black; color: white;" >회원정보수정 </a> 
		<a href="dropUser.jsp"class="w3-bar-item w3-button" style="background-color: black; color: white;">회원탈퇴 </a>
	</div>  -->
	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="height:33%; ">
	   <h3 class="w3-bar-item" style="padding-left: 30px; vertical-align: middle;">메뉴</h3>
	  <a href="#" class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px ">예약리스트보기</a>
	  <a href="#" class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">리뷰보기</a>
	  <a href="/sjrent/user/read.rent"  class="w3-bar-item w3-button" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">회원정보수정</a>
	  <a data-toggle="modal" class="w3-bar-item w3-button" data-target="#dropModal" style="font-size:14pt; background-color: black; color: white; padding-left: 30px">회원탈퇴</a>
	</div>
	
	
	
 <div class="modal" tabindex="-1" role="dialog" id="dropModal">
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
        <button type="button" class="btn btn-secondary" >예</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal">아니오</button>
      </div>
    </div>
  </div>
</div>  
<!-- </div> -->
</body>
</html>