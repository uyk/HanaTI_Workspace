<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/basic.css">
<jsp:include page="../common/commoncss.jsp" />

<%
	String id = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("loginId")) {
				id = cookie.getValue();
			}
		}
	}
	// 초기화면 아이디 null시
	if (id == null) {
		id = "";
	}
%>

<script type="text/javascript">


// 로그인시 아이디 존재하지 않으면 글씨띄우기 다른 3곳도 동일




</script>


</head>
<body class="tg-home tg-homevone">

<!--************************************
      Nav 시작
*************************************-->
   <jsp:include page="../include/nav.jsp"/>
<!--************************************
      Nav 종료
*************************************-->

<!--************************************
      Wrapper 시작
*************************************-->
   <div id="tg-wrapper" class="tg-wrapper tg-haslayout">

<!--************************************
      Header 시작
*************************************-->
   <jsp:include page="../include/header.jsp"/>
<!--************************************
      Header 종료
*************************************-->
   
<!--************************************
		Main 시작
	*************************************-->
<main id="tg-main" class="tg-main tg-sectionspace tg-haslayout tg-bglight">
	<div class="container">
		<div class="row">
			<div class="tg-homebannerslider tg-homebannerslider tg-haslayout">
				<div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
					<div class="container">
						<div class="tg-tabcontent tab-content" style="padding: 0px">
							<div role="tabpanel" class="tab-pane active fade in" id="home">
								<div style="text-align: center; margin: 0px 0px; padding: 0px" >
									<h2>QnA</h2>
									
									<!-- 글작성 시작 -->
									<div class="outline">
								<form action="/sjrent/qna/qnaCreate.rent" method="post">
								   <%
								    if(id != null){//로그인 
								   %>
								   <div class="dottedOutline">
								   
								           
								        <div style="float: left;">
								             <label class="createPostButton" style="background-color: orange; font-size:14pt">글제목</label> 
								             <input type="text" class="grayBox" required id="title" name="title" maxlength="15" style="text-transform:none; text-align: left">
								        </div>
								          
								        <div>
								             <label class="createPostButton" style="background-color: orange; font-size:14pt">작성자</label> 
								             <input type="text" class="grayBox" readonly value='<%=id %>' id="writer" name="writer" style="text-transform:none">
								        </div>
								        
								        <%--<input type="text" class="createPostBox" placeholder="게시글을 작성해주세요 (1000자 이내)" required id="content" name="content" maxlength="1000"> --%>    
								        <textarea class="createPostBox" name="content" id="content" placeholder="게시글을 작성해주세요 (1000자 이내)"  maxlength="1000" style="height: 100px; text-transform:none" required></textarea>
								    </div> 
								    
								        <div style="text-align:right">
								              <input type="submit" class="newButton" value='등록하기' style="margin-top:20px; display:inline-block; background-color: #d64161; font-size:14pt ">      
								        </div>
								    
								</form>
								    <%  
								    }else{//로그인x
								    %>
								    
								    <div class="dottedOutline">
								        <div class="caution">
								             <label>※ 비밀번호는 글 수정, 삭제시 필요합니다.</label>
								        </div>
								           
								        <div>
								             <label class="createPostButton">글제목</label> 
								             <input type="text" class="grayBox" readonly>
								        </div>
								          
								        <div>
								             <label class="createPostButton">작성자</label> 
								             <input type="text" class="grayBox" disabled>
								             <div class="right"><label class="createPostButton">비밀번호</label> 
								             <input type="password" class="grayBox" disabled></div>
								        </div>
								        
								        <input type="text" class="createPostBox" placeholder="로그인 후 이용 가능합니다" disabled> 
								    </div>
								   
								    <div style="text-align:right">
								      <input type="submit" class="createPostButton"  value='등록하기' style="margin-top:20px; display:inline-block; background-color: orange; " disabled>      
								    </div>
								    <%
								    }
								    %>
								   
								     
								   
								   
								  </div> 
									
									
									
									
										
									<!-- 글작성 종료 -->	
		
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
<!--************************************
		Main 종료
*************************************-->

<!--************************************
         Wrapper 종료
*************************************-->
   </div> 
    <jsp:include page="../common/commonjs.jsp" />
</body>
</html>