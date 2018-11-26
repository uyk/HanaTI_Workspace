<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSON 데이터 전송 및 수신</title>
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function() {
     $("input:button").click(function(event){
          // 테스트 데이터
          var employee = {employeeId:500, firstName:"기정", lastName:"김", email: "bangry@korea.com"};
          $.ajax({
               url : "echo",
               type: "post",
               data: JSON.stringify(employee),
               contentType: "application/json; charset=utf-8",
              success : function(result, status, xhr) {
                   displayEmployee(result);
              },
              error : function(xhr){
                   alert(xhr.status);
              }
          });
     });
     function displayEmployee(employee){
          var employeeInfo = "";
          employeeInfo += "<h2>"+employee.employeeId+"</h2>";
          employeeInfo += "<h2>"+employee.firstName+"</h2>";
          employeeInfo += "<h2>"+employee.lastName+"</h2>";
          employeeInfo += "<h2>"+employee.email+"</h2>";

          $("#message").html(employeeInfo);
          //$("").apppendTo();
     }
});
</script>
</head>
<body>
  <input type="button" value="JSON 데이터 전송 및 수신 테스트">
  <div id="message"></div>
</body>
</html>
