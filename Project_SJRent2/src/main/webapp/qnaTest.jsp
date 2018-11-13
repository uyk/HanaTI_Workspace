<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>

  <jsp:include page="common/commoncss.jsp"/> 
  <jsp:include page="common/commonjs.jsp"/> 
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
		console.log(list[i].title);
		//$("#carListRow").append(model);
	}	//for 끝

}
</script>
<meta charset="utf-8">
<title></title>
</head>
<body>

</body>
</html>