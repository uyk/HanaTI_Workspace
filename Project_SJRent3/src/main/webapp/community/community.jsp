<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <jsp:include page="../common/commoncss.jsp" />
<style type="text/css">
/* Style tab links */
.tablink {
    background-color: #555;
    color: white;
    float: inherit;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 18px;
    width: 33%;
}

.tablink:hover {
    background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
    color: white;
    display: none;
    padding: 100px 20px;
    height: 100%;
}

#QnA {background-color: #446600;}
#FAQ {background-color: #800060;}
#공지사항 {background-color: #006699;}

</style>
</head>

<!--************************************
			Nav 시작
	*************************************-->
<jsp:include page="../include/nav.jsp" />
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
<jsp:include page="../include/header.jsp" />
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
									<h2>커뮤니티</h2>
									<div style="text-align: center; margin: 30px 0px 15px ">
									<button class="tablink" onclick="openPage('QnA', this, '#446600')" id="defaultOpen">QnA</button>
									<button class="tablink" onclick="openPage('FAQ', this, '#800060')"  >FAQ</button>
									<button class="tablink" onclick="openPage('공지사항', this, '#006699')"  >공지사항</button>
								</div>
								<div id="QnA" class="tabcontent">
									<h3>QnA</h3>
									<p>QnA 내용 보여주기</p>
								</div>
		
								<div id="FAQ" class="tabcontent">
									<h3>FAQ</h3>
									<p>FAQ 내용 보여주기</p>
								</div>
		
								<div id="공지사항" class="tabcontent">
									<h3>공지사항</h3>
									<p>공지사항 내용 보여주기</p>
								</div>
							</div>
								<form class="tg-formtheme tg-formlogin"> 
									<div style="display:inline-block; float: right; margin-top: 30px">
										<button class="tg-btn tg-btn-lg" style=" padding: 0px 30px; float: right;"><span style="font-size: 14pt; width:30%">글쓰기</span></button>
									</div>
								</form>
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

<body class="tg-home tg-homevone">

	<script>
		function openPage(pageName, elmnt, color) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].style.backgroundColor = "";
			}
			document.getElementById(pageName).style.display = "block";
			elmnt.style.backgroundColor = color;

		}
		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>

   <jsp:include page="../common/commonjs.jsp" />
</body>
</html>