<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/commoncss.jsp" />
<jsp:include page="../common/commonjs.jsp" />
<style type="text/css">
   input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>
<script type="text/javascript">
   $(document).ready(function(){
     <%--  $("#rentCar").submit(function(e){
         e.preventDefault();
         $.ajax({
            type: "get",
            url : "<%=application.getContextPath()%>/rent/rent.rent",
            data:{
               'datas':[
                  {'insuranceNumber':'aaa', 'startDate':"bb","endDate":"zz","pickupPlace":"수령장소", "paidAmount":"차*날짜 가격", "paymentOption":"ee"}
               ]
            },
            dataType: "json",
            success:function(data){
               alert('성공');
            }
         });
      }); --%>
   });
</script>
</head>
<body>

   <!--************************************
         Mobile Menu Start
   *************************************-->
   <jsp:include page="../include/nav.jsp" />
   <!--************************************
         Mobile Menu End
   *************************************-->
   <!--************************************
         Wrapper Start
   *************************************-->
   <div id="tg-wrapper" class="tg-wrapper tg-haslayout">
      <!--************************************
               Header Start
      *************************************-->
      <jsp:include page="../include/header.jsp"></jsp:include>
      <!--************************************
               Header End
      *************************************-->
      <!--************************************
            Main Start
      *************************************-->
      <main id="tg-main" class="tg-main tg-haslayout">
         <div class="tg-sectionspace tg-haslayout">
            <div class="container">
               <div class="row">
                  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                     <div id="tg-content" class="tg-content">
                        <div class="tg-billingdetail">
                           <form id="rentCar" class="tg-formtheme tg-formbillingdetail"  action="<%=application.getContextPath()%>/rent/rent.rent" method="post">
                              <fieldset>
                                 <div class="tg-bookingdetail">
                                    <div class="tg-box">
                                       <div class="tg-heading">
                                          <h3>결제 정보</h3>
                                       </div>
                                       <div class="clearfix"></div>
                                       <input type="hidden" value = "" name="modelName">
                                       <div class="row">
                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                             <div class="form-group">
                                                <label>이름</label>
                                                <input type="text" value="호진" name="user_name" class="form-control" placeholder="" required readonly>
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                             <div class="form-group">
                                                <label>핸드폰</label>
                                                <input type="Number" name="user_cellphone" class="form-control" required readonly>
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding: 0">
                                             <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                                <div class="form-group">
                                                   <label>이메일 </label>
                                                   <input type="email" name="user_email" class="form-control"  required readonly>
                                                </div>
                                             </div>
                                             <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                                <div class="form-group">
                                                </div>
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                             <div class="form-group">
                                                <label>시작날짜</label>
                                                <input type="text" name="startDate" class="form-control" value="2018-11-10" readonly>
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                             <div class="form-group">
                                                <label>종료날짜 </label>
                                                <input type="text" name="endDate" class="form-control" readonly>
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                             <div class="form-group">
                                                <label>차량금액 </label>
                                                <input type="text" name="paidAmount" class="form-control" readonly="readonly">
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                             <div class="form-group">
                                                <label>수령장소 </label>
                                                <input type="text" name="pickupPlace" class="form-control" readonly="readonly" value="서울지점">
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                             <div class="form-group">
                                                <label>보험<sup>*</sup></label>
                                                <span>
                                                   <select name="insuranceNumber" class="ins_num" required>
                                                      <option value="">보험종류 선택</option>
                                                      <option value="0">완전자차--</option>
                                                      <option value="1">일반자차--</option>
                                                   </select>
                                                </span>
                                             </div>
                                          </div>
                                          
                                          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                             <div class="form-group">
                                                <label>결제정보 <sup>*</sup></label>
                                                <span class="tg-select">
                                                   <select name="paymentOption" class="rent_payment_option" required>
                                                      <option value="">결제방법 선택</option>
                                                      <option value="card">카드</option>
                                                      <option value="transfer">계좌이체</option>
                                                   </select>
                                                </span>
                                             </div>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                                 <div class="tg-bookingdetail">
                                    <div class="tg-box tg-addtionalinfo">
                                       <div class="tg-heading">
                                          <h3>추가 정보</h3>
                                       </div>
                                       <div class="form-group">
                                          <label>추가 정보 기입</label>
                                          <textarea placeholder="추가적으로 필요한 것을 적어주세요"></textarea>
                                       </div>
                                    </div>
                                    <div class="tg-box tg-yourorder">
                                       <div class="tg-heading">
                                          <h3>결제 정보</h3>
                                       </div>
                                       <div class="tg-widgetpersonprice">
                                          <div class="tg-widgetcontent">
                                             <ul>
                                                <li class="tg-personprice"><div class="tg-perperson"><span>차량 금액  (3 x 100,000￦)</span><em>300,000￦</em></div></li>
                                                <li><span>보험비</span><em>30,000￦</em></li>
                                                <li><span>총 일수</span><em>3일</em></li>
                                                <li class="tg-totalprice"><div class="tg-totalpayment"><span>총 금액</span><em>390,000￦</em></div></li>
                                             </ul>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </fieldset>
                              <fieldset>
                                    <button id="rentCarButton" type="submit" style="float: right" class="tg-btn">결제하기</button>
                              </fieldset>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </main>
      <!--************************************
            Main End
      *************************************-->
   </div>
</body>
</html>