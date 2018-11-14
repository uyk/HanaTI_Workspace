<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <%-- <jsp:include page="common/commoncss.jsp"/> 
  <jsp:include page="common/commonjs.jsp"/> --%> 
  
<style type="text/css">

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}
</style>
<script>
$(document).ready(function(){
  $.ajax({
      type: "POST",
      url: "<%=application.getContextPath()%>/qna/qnaIndex.rent",
      //data: modelParams,
      dataType: "json",
      success: function(data) {
          setModelList(data);
      }
  });
});
function setModelList(list) {
	
	for ( var i in list) {
		console.log("제목:"+list[i].title +" 내용:"+ list[i].content +" 작성자:"+ list[i].userId + " 날짜:"+list[i].date);
		//$("#carListRow").append(model);
	}	//for 끝

}
</script>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>Hoverable Table</h2>
<p>Move the mouse over the table rows to see the effect.</p>

<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Points</th>
  </tr>
  <tr>
    <td>Peter</td>
    <td>Griffin</td>
    <td>$100</td>
  </tr>
  <tr>
    <td>Lois</td>
    <td>Griffin</td>
    <td>$150</td>
  </tr>
  <tr>
    <td>Joe</td>
    <td>Swanson</td>
    <td>$300</td>
  </tr>
  <tr>
    <td>Cleveland</td>
    <td>Brown</td>
    <td>$250</td>
  </tr>
</table>
</body>
</html>