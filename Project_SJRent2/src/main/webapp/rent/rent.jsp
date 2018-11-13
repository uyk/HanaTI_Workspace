<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

var mapInsurance;
var price = [];
var date= [];
$(document).ready(function(){
	/* 동적 맵 생성  */
	Map = function(){
		 this.map = new Object();
		};   
		Map.prototype = {   
		    put : function(key, value){   
		        this.map[key] = value;
		    },   
		    get : function(key){   
		        return this.map[key];
		    },
		    containsKey : function(key){    
		     return key in this.map;
		    },
		    containsValue : function(value){    
		     for(var prop in this.map){
		      if(this.map[prop] == value) return true;
		     }
		     return false;
		    },
		    isEmpty : function(key){    
		     return (this.size() == 0);
		    },
		    clear : function(){   
		     for(var prop in this.map){
		      delete this.map[prop];
		     }
		    },
		    remove : function(key){    
		     delete this.map[key];
		    },
		    keys : function(){   
		        var keys = new Array();   
		        for(var prop in this.map){   
		            keys.push(prop);
		        }   
		        return keys;
		    },
		    values : function(){   
		     var values = new Array();   
		        for(var prop in this.map){   
		         values.push(this.map[prop]);
		        }   
		        return values;
		    },
		    size : function(){
		      var count = 0;
		      for (var prop in this.map) {
		        count++;
		      }
		      return count;
		    }
		};

	
	/* 보험 array 저장 */
	var insurance = '<%=request.getAttribute("insuranceList")%>';
	insurance = insurance.trim();
	insurance = insurance.substring(1, insurance.length-1);
	
	/* console.log(insurance); */
	var insurances = insurance.split('Insurance').map(function(item){
		return item.trim();
	});
	
	mapInsurance = new Map();
	for ( var i =1; i< insurances.length; i++) {
		if(insurances[i].substring(insurances[i].length-1, insurances[i].length) == ','){
			insurances[i] = insurances[i].substring(1, insurances[i].length-2);
		}else{
			insurances[i] = insurances[i].substring(1, insurances[i].length-1);
		}
		var temp = new Map();
		/* console.log(insurances[i]); */
		var insurArray = insurances[i].split(',');
		for (var j = 0; j < insurArray.length; j++) {
			var key_value = insurArray[j].split('=');
			temp.put(key_value[0].trim(), key_value[1].trim());
			/* console.log(key_value[0].trim()+":"+ key_value[1].trim()); */
		}
		/* console.log(temp); */
		mapInsurance.put(i, temp);
	}
	
	/* console.log(insurances[0]);
	console.log(insurances[1]);
	console.log(insurances[2]);
	console.log(insurances[3]);
	console.log(insurances[4]); */
	
	/* console.log(mapInsurance.get(1).get('name'));  */
	
	
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
                                       <input type="hidden" value = "K5" name="modelName">
                                       <div class="row">
                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                             <div class="form-group">
                                                <label>이름</label>
                                                <input type="text" value="${userName}" name="user_name" class="form-control" style="text-transform:  none;" required readonly>
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                             <div class="form-group">
                                                <label>핸드폰</label>
                                                <input type="text" value="${userCellphone}" name="user_cellphone" class="form-control"  required readonly>
                                             </div>
                                          </div>
                                          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding: 0">
                                             <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                                <div class="form-group">
                                                   <label>이메일 </label>
                                                   <input type="email" value="${userEmail}"  name="user_email" class="form-control" style="text-transform:  none;" required readonly>
                                                </div>
                                             </div>
                                             <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                                <div class="form-group">
                                                </div>
                                             </div>
                                          </div>
                                          <c:forEach var="item" items="${resultMap}" varStatus="status">
	                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
	                                             <div class="form-group">
	                                                <label>시작날짜</label>
	                                                <input type="text" id="startdate${status.count}" name="startDate" class="form-control" value="${item.startDate}" readonly>
	                                             </div>
	                                          </div>
	                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
	                                             <div class="form-group">
	                                                <label>종료날짜 </label>
	                                                <input type="text" id="enddate${status.count}" name="endDate" class="form-control" value="${item.endDate}" readonly>
	                                             </div>
	                                          </div>
	                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
	                                             <div class="form-group">
	                                                <label>차량금액 </label>
	                                                <input type="number" id="carAmount${status.count}" class="form-control carAmount" value="${item.amountMoney}" readonly="readonly">
	                                             	<input type="hidden" id="amount${status.count}" name="paidAmount" class="paidAmount" value="">
	                                             </div>
	                                          </div>
	                                          <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
	                                             <div class="form-group">
	                                                <label>수령장소 </label>
	                                                <input type="text" name="pickupPlace" class="form-control" value="${item.pickupPlace}" readonly="readonly" value="서울지점">
	                                             </div>
	                                          </div>
	                                          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	                                             <div class="form-group">
	                                                <label>보험<sup>*</sup></label>
	                                                <span>
	                                                   <select name="insuranceNumber" class="ins_num${status.count}" onchange="changeSelect(${status.count});" required>
		                                                    <option value="">보험종류 선택</option>
	                                                   		<c:forEach var="insur" items="${insuranceList}" varStatus="num">
		                                                      <option value="${insur.number}">${insur.name}</option>
	                                                      </c:forEach>
	                                                   </select>
	                                                </span>
	                                             </div>
	                                          </div>
                                          </c:forEach>
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
                                          <textarea placeholder="추가적으로 필요한 것을 적어주세요" style="text-transform:  none;"></textarea>
                                       </div>
                                    </div>
                                    <div class="tg-box tg-yourorder">
                                       <div class="tg-heading">
                                          <h3>결제 정보</h3>
                                       </div>
                                       <div class="tg-widgetpersonprice">
                                          <div class="tg-widgetcontent">
                                             <ul>
	                                             <li class="tg-personprice" style="padding-top: 20px; padding-bottom: 10px;">
	                                             <c:forEach var="item" items="${resultMap}" varStatus="status">
	                                                <div class="tg-perperson" style="padding-bottom: 10px;"><span>차량 금액(${fn:split(item.picture,'.')[0]})</span><em>${item.amountMoney}￦</em><br></div>
	                                              </c:forEach>
	                                              </li>
	                                              <c:forEach var="item" items="${resultMap}" varStatus="status">
	                                                <li><span>보험비(${fn:split(item.picture,'.')[0]})</span><div id="insur${status.count}"></div></li>
	                                                <li><span>총 일수</span><div id="day${status.count}"></div></li>
	                                             	<%-- <%totalmoney += Integer.parseInt(item.type); %> --%>
	                                             </c:forEach>
	                                                <li class="tg-totalprice"><div class="tg-totalpayment"><span>총 금액</span><div id="totalMoney"></div></div></li>
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
<script type="text/javascript">
/* 보험비 계산 */
function changeSelect(num){
	/* 차 금액 계산 */
	var car_price = mapInsurance.get($('.ins_num'+num+' option:selected').val()).get('price');
	document.getElementById('insur'+num).innerHTML = "<em>￦"+car_price+"</em>";
	price[num-1] = car_price;
	
	/* 날짜계산 */
	var dayDiv ='.day'+num;
	var enddate = new Date(document.getElementById('enddate'+num).value);
	var startdate = new Date(document.getElementById('startdate'+num).value);
	var car_date = ( enddate - startdate ) / (1000* 60 * 60 * 24)+1;
	document.getElementById('day'+num).innerHTML = "<em>"+ car_date +"일</em>";
	date[num-1] = car_date;
	document.getElementById('amount'+num).value = parseInt(document.getElementById('carAmount'+num).value) + parseInt(car_price*car_date);
	
	/* 총 금액 */
	var total = 0;
	var amountCar = document.getElementsByClassName('carAmount');
	
	for (var i = 0; i < amountCar.length; i++) {
		if(Number.isInteger(parseInt(price[i]))){
			total += parseInt(amountCar[i].value);
			total += parseInt(price[i])*parseInt(date[i]);
		}
	}
	document.getElementById('totalMoney').innerHTML = "<em>￦"+total+"</em>";
	/* console.log(document.getElementById('amount'+num).value); */
}

</script>
</body>
</html>