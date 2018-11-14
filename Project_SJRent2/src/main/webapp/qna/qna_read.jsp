<%@page import="kr.or.kosta.sjrent.qna.domain.QnA"%>
<%@page import="kr.or.kosta.sjrent.qna.controller.QnAListController"%>
<%@page import="kr.or.kosta.sjrent.common.controller.Controller"%>
<%@page import="kr.or.kosta.sjrent.common.params.Params"%>
<%@page import="kr.or.kosta.sjrent.common.params.PageBuilder"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/css/basic.css">
<c:set var="context" value="${pageContext.request.contextPath}" />
<%
//페이지당 보여지는 페이지수 설정


// 페이징 정렬 
//List<Article> list = dao.listByPage(params);

// 페이징 처리에 필요한 검색 개수 DB조회
//int rowCount = dao.countBySearch(params);

// PageBuilder를 이용하여 페이징 계산
//PageBuilder pageBuilder = new PageBuilder(params, rowCount);
//pageBuilder.build();


//넘버링하기
/* int count = (int)request.getAttribute("count"); 
//int listSize = 10;
int pageNum = 1;
String pageS = request.getParameter("page");
if(pageS!=null){
	pageNum = Integer.parseInt(pageS);
}
int listSize = 10;
int startNum = count -(listSize*(pageNum-1)); */
%>
<!DOCTYPE html>
<html>
<head>
<!-- 스타일 시작 -->
   <jsp:include page="../common/commoncss.jsp" />
   <jsp:include page="../common/commonjs.jsp" />
<style type="text/css">
table{
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color:#f5f5f5;
	color: black;
	}

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

.tabcontent {
    color: black;
    display: none;
    /* padding: 100px 20px; */
    height: 100%;
}

#QnA { background-color: #fafafa; 
/* background-color: orange; */}
#FAQ {background-color: #fafafa;}
#공지사항 {background-color: #fafafa;}

</style>
<!-- 스타일 종료 -->
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
<main id="tg-main" class="tg-main tg-haslayout tg-bglight">
   <div class="container">
      <div class="row">
         <div style="text-align: center; margin: 100px 0px 30px"><h2>커뮤니티</h2></div>
         <div style="text-align: center;  margin: 10px 0px 20px">
			<button class="tablink" onclick="openPage('QnA', this, '#446600')" id="defaultOpen">QnA</button>   
			<button class="tablink" onclick="openPage('FAQ', this, '#800060')"  >FAQ</button>
			<button class="tablink" onclick="openPage('공지사항', this, '#006699')"  >공지사항</button>
		</div>
		
		<!-- QnA -->
		<div id="QnA" class="tabcontent" >
		
										
		<form action="<%=application.getContextPath() %>/article/regist_action.jsp">
			   <div class="dottedOutline">
			        
			        <%
			        QnA qna = (QnA)request.getAttribute("QnA");
			        //System.out.println(qna);
			        
			        String title = qna.getTitle();
			        String content = qna.getContent();
			        int qna_seq = qna.getNumber(); 
			        //System.out.println("타이틀: " + title);
			        
			        %>   
			        
			        
			        <div style="vertical-align: middle;">
			             <label class="createPostButton" style="background-color: #446600;" >글제목</label> 
			             <input type="text" class="grayBox" required id="title" name="title" maxlength="15" style="width: 1040px; text-align: left; " readonly value="<%=title %>" >
			             <!-- <label class="createPostButton" style="background-color: #446600; margin-left: 570px">작성자</label> 
			             <input type="text" class="grayBox" readonly value='' id="writer" name="writer"> -->
			        	 <%-- <input type="hidden" name="qna_seq" value="<%=qna_seq %>" > --%>
			        </div>
			        
			        <%--<input type="text" class="createPostBox" placeholder="게시글을 작성해주세요 (1000자 이내)" required id="content" name="content" maxlength="1000"> --%>    
			        <textarea class="createPostBox" name="content" id="content" maxlength="1000" readonly ><%=content %></textarea>
			    </div> 
			    
			    <div style="text-align:right">
		              <input type="button" class="newButton" value='목록' style="margin-top:20px; display:inline-block; background-color: #006699 " onclick="location.href='<%=application.getContextPath()%>/qna/qnaIndex.rent'">      
		              <%-- <input type="button" class="newButton" value='수정' style="margin-top:20px; display:inline-block; background-color: #006699 " onclick="location.href='<%=application.getContextPath()%>/qna/qna_update.jsp?qna_seq=<%=qna_seq %>&title=<%=title %>&content=<%=content%>'">  --%>     
		              <input type="button" class="newButton" value='삭제' style="margin-top:20px; display:inline-block; background-color: #006699 " onclick="location.href='<%=application.getContextPath()%>/qna/qnaDelete.rent?qna_seq=<%=qna_seq %>'">      
		        </div>
			    
			</form>		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
	        
		</div>
		
		<!-- FAQ -->
		<div id="FAQ" class="tabcontent">
			<h3>FAQ</h3>
			<!-- FAQ 내용 시작 -->
			<div style="padding-left: 15px; margin-bottom: 180px">
				<%
				for(int i=1; i<6; i++){
				%>
				<h5># 내용 <%=i %></h5>
				<%
				}
				%>
			</div>
			<!-- FAQ 내용 종료 -->
			
		</div>
		
		<!-- Notice -->
		<div id="공지사항" class="tabcontent">
			<h3>공지사항</h3>
			<!-- Notice 내용 시작 -->
			<div style="padding-left: 15px; margin-bottom: 180px">
				<%
				for(int i=1; i<6; i++){
				%>
				<h5># 내용 <%=i %></h5>
				<%
				}
				%>
			</div>
			<!-- Notice 내용 종료 -->
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