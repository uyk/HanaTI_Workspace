<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="../common/commoncss.jsp" />
   
   <style type="text/css">
   
   .tg-cartproductdetail table tr{
      border-bottom: 1px solid #e6e6e6;
   }
   
   .tg-cartproductdetail table tr th:first-child, .tg-cartproductdetail table tr td:first-child{
         width:50%;
   }
   </style>
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
         <div style="text-align: center; margin: 50px 0px"><h2>위시리스트</h2></div>
            <div id="tg-twocolumns" class="tg-twocolumns">
               <form class="tg-formtheme tg-formcart">
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
                                 첫 번째 행 시작
                              *************************************-->
                              <tr>
                                 <td style="vertical-align: middle;">
                                    <input type="checkbox" >
                                 </td>
                                 <td>
                                    <div class="tg-tourname" style="border-bottom: none;" > 
                                       <figure >
                                          <a href="javascript:void(0);"><img src="../images/cars/대형/2017GRANDEUR.jpg" style="width: 100px; height: 100px; margin-right: 15px" alt="image 2017GRANDEUR"></a>
                                       </figure>
                                       <div class="tg-populartourcontent">
                                          <div class="tg-populartourtitle">
                                             <h3 style="vertical-align: middle; text-align: left; margin-bottom: 10px"><a href="javascript:void(0);">2017 그렌저</a></h3>
                                             <span style="text-align: left; ">네비게이션, 흡연, 전방카메라</span>
                                          </div>
                                       </div>
                                    </div>
                                 </td>
                                 <td  style="vertical-align: middle;"><span>2012-12-31</span></td>
                                 <td  style="vertical-align: middle;"><span>2014-09-30</span></td>
                                 <td style="vertical-align: middle;">30,000</td>
                              </tr>
                              <!--************************************
                                 첫 번째 행 종료
                              *************************************-->
                              <!--************************************
                                 두 번째 행 시작
                              *************************************-->
                              <tr>
                                 <td style="vertical-align: middle;">
                                    <input type="checkbox" >
                                 </td>
                                 <td>
                                    <div class="tg-tourname" style="border-bottom: none;" > 
                                       <figure >
                                          <a href="javascript:void(0);"><img src="../images/cars/대형/2017GRANDEUR.jpg" style="width: 100px; height: 100px; margin-right: 15px" alt="image 2017GRANDEUR"></a>
                                       </figure>
                                       <div class="tg-populartourcontent">
                                          <div class="tg-populartourtitle">
                                             <h3 style="vertical-align: middle; text-align: left; margin-bottom: 10px"><a href="javascript:void(0);">2017 그렌저</a></h3>
                                             <span style="text-align: left; ">네비게이션, 흡연, 전방카메라</span>
                                          </div>
                                       </div>
                                    </div>
                                 </td>
                                 <td  style="vertical-align: middle;"><span>2012-12-31</span></td>
                                 <td  style="vertical-align: middle;"><span>2014-09-30</span></td>
                                 <td style="vertical-align: middle;">30,000</td>
                              </tr>
                              <!--************************************
                                 두 번째 행 종료
                              *************************************-->
                           </tbody>
                        </table>
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

   
   
   <jsp:include page="../common/commonjs.jsp" />
</body>
</html>