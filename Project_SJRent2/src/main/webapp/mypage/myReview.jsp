<%@page import="kr.or.kosta.sjrent.review.domain.Review"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
/**
 * 리뷰리스트를 받아오기위한 페이지
 */
 
String loginId = (String)request.getAttribute("loginId");
List<Review> reviewList = (List)request.getAttribute("reviewList");
%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />

<script type="text/javascript">

/**
 *  체크박스 다중 선택 방지를 위한 메소드
 */
function oneCheckbox(a){

    var obj = document.getElementsByName("reviewSeq");

    for(var i=0; i<obj.length; i++){

        if(obj[i] != a){

            obj[i].checked = false;
        }
    }
}



</script>

</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
           <div class="tg-homebannerslider" class="tg-homebannerslider tg-haslayout">
              <div class="tg-homeslider tg-homeslidervtwo tg-haslayout">
                 <div class="container"> 
                  <div class="tg-tabcontent tab-content" style="padding: 0px 350px;">
                     <div role="tabpanel" class="tab-pane active fade in" id="home">
                        <!--************************************
                                    Title 시작
                           *************************************-->
                         <div style="text-align: center; "><h2>MyReview</h2></div>
                        <!--************************************
                                    Title 종료
                           *************************************-->   
                           
                     </div>
                  </div>

							<!--************************************
                                    Content 시작 
                              *************************************-->
						<div>
                               <p style="text-align: center; ">
                              <%=loginId%>님 환영합니다. 
                              </p> 
                      	</div>
						<!--************************************
                                    MenuBar 시작 
                              *************************************-->
						<jsp:include page="menuBar.jsp" />
						<!--************************************
                                    MenuBar 종료 
                              *************************************-->
						
						


<!--***********     리뷰 리스트 시작      ****************-->

              <form action="/sjrent/review/delete.rent" method="get">
                <table role="tabpanel" class="tab-pane active fade in"
                  id="reviewList" style="width: 70%; margin-left: 250px">


                  <tr>
                    <th></th>
                    <th>번호</th>
                    <th>모델명</th>
                    <th>제목</th>
                  </tr>

                  <%
                  	for (int i = 0; i < reviewList.size(); i++) {
                  %>
                  <tr>
                    <!-- checkbox에 해당된 리뷰 삭제  -->
                    <td><input type="checkbox" name="reviewSeq" onclick="oneCheckbox(this)" value="<%=reviewList.get(i).getNumber()%>"></td>
                    <td><%=reviewList.get(i).getNumber()%></td>
                    <td><%=reviewList.get(i).getModelName()%></td>
                    <td><a href="#"><%=reviewList.get(i).getTitle()%></a></td>
                  </tr>
                  <%
                  	}
                  %>


                </table>

                <div style="text-align: center;">
                  <div
                    style="display: inline-block; vertical-align: middle; padding: 0px 10px; margin: 30px 0px 50px 0px;">
                    <button type="submit" class="tg-btn tg-btn-lg">
                      <span style="font-size: 14pt; width: 50%">삭제</span>
                    </button>
                  </div>
                </div>
              </form>


<!--***********     리뷰 리스트 종료      ****************-->
						

							<!--************************************
                                 Content 종료
                           *************************************-->

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