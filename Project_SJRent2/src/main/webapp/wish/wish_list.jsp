<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="../common/commoncss.jsp" />
   <jsp:include page="../common/commonjs.jsp" />
   <style type="text/css">
   
   .tg-cartproductdetail table tr{
      border-bottom: 1px solid #e6e6e6;
   }
   
   .tg-cartproductdetail table tr th:first-child, .tg-cartproductdetail table tr td:first-child{
         width:50%;
   }
   </style>
   
   <script type="text/javascript">
   
   $(document).ready(function(){
	   /* 전체선택 버튼 */
	   $("#selectall").click(function(){
		  $('input[type="checkbox"]').prop('checked', true); 
	   });
	   /* 전체해제 버튼 */
	   $("#disableall").click(function(){
		  $('input[type="checkbox"]').prop('checked', false); 
	   });
   });
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
<main id="tg-main" class="tg-main tg-haslayout tg-bglight">
   <div class="container">
      <div class="row">
         <div style="text-align: center; margin: 100px 0px"><h2>위시리스트</h2></div>
            <div id="tg-twocolumns" class="tg-twocolumns">
            	<div style="float: right; padding-right: 15px; padding-bottom: 20px" >
               		<button type="button" id= "selectall" class="user_option btn btn-primary">전체 선택</button>
               		<button type="button" id= "disableall" class="user_option btn btn-secondary">전체 해제</button>
               </div>
               <form id="form" class="tg-formtheme tg-formcart" action="<%=application.getContextPath() %>/rent/page.rent" method="get">
                 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="" >
                       <table class="table table-responsive">
                          <colgroup>
                             <col width="5%"/>
                             <col width="40%"/>
                             <col width="15%"/>
                             <col width="15%"/>
                             <col width="10%"/>
                          </colgroup>
                          <tr>
                             <th scope="col">선택</th>
                             <th scope="col">자동차</th>
                             <th scope="col">시작일</th>
                             <th scope="col">종료일</th>
                             <th scope="col">가격</th>
                          </tr>
                          <tbody>
                          <!--************************************
                                차 리스트 보여주기 (IE 10version not support)
                             *************************************-->
                             <% if (request.getAttribute("list") != null && (!((ArrayList)request.getAttribute("list")).isEmpty())){ %> 
	                              <c:forEach var="item" items="${list}" varStatus="status">
		                              <tr>
		                                 <td style="vertical-align: middle;">
		                                    <input type="checkbox" class="user_checked" name = "checked" value="${item.modelName}">
		                                 </td>
		                                 <td>
		                                    <div class="tg-tourname" style="border-bottom: none;" > 
		                                       <figure >
		                                       		<!-- 사진 필요 -->
		                                       		 <a><img src="<%=application.getContextPath() %>/images/cars/${item.type}/${item.picture}" style="width: 100px; height: 100px; margin-right: 15px" alt="${item.modelName}"></a>
		                                       </figure>
		                                       <input type="hidden" name="type" value="${item.type}">
		                                       <input type="hidden" name="picture" value="${item.picture}">
		                                       <div class="tg-populartourcontent">
		                                          <div class="tg-populartourtitle">
		                                             <h3 style="vertical-align: middle; text-align: left; margin-bottom: 10px"><a class="modelName" href="javascript:void(0);">${item.modelName}</a></h3>
		                                          		 <span style="text-align: left; ">연료 : ${item.fuelType }</span>
		                                          </div>
		                                       </div>
		                                    </div>
		                                 </td>
		                                 <td class="startDate" style="vertical-align: middle;"><span>${item.startDate}</span>
			                                 <input type="hidden" name="startDate" value="${item.startDate}">
		                                 </td>
		                                 <td class="endDate"   style="vertical-align: middle;"><span>${item.endDate}</span>
			                                 <input type="hidden" name="endDate" value="${item.endDate}">
		                                 </td>
		                                 <td class="amountMoney" style="vertical-align: middle;"><span>${item.amountMoney}</span>
			                                 <input type="hidden" name="amountMoney" value="${item.amountMoney}">
		                                 </td>
		                              </tr>
	                              </c:forEach>
                              <%}else{ %>
                              <tr>
                              	<td colspan="5" style="height: 100px; vertical-align: middle;">위시리스트가 존재하지 않습니다.</td>
                              </tr>
                              <%}%>
                             <!--************************************
                                차 리스트 종료
                             *************************************-->
                          </tbody>
                       </table>
                       <% if (request.getAttribute("list") != null && (!((ArrayList)request.getAttribute("list")).isEmpty())){ %> 
                      	 <fieldset style="border: none;">
                          	<input id="rentCarButton" type="submit" style="float: right" class="tg-btn" value="렌트하기">
                        </fieldset>	
                       <%} %> 
                    </div>
                 </div>
             </form>
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
</body>
</html>