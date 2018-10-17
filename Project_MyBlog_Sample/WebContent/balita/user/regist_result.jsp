<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>회원가입 결과 화면</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">

  <!-- Page content -->
  <div class="w3-content" style="max-width: 500px;">
    <div
      class="w3-container w3-padding-32 w3-black w3-opacity w3-card-2 w3-hover-opacity-off"
      style="margin: 32px 0;">
      <h2>쌩유! 좋은 시간 보내~~~</h2>
      <h4>가입하시 정보는 아래와 같습니다.</h4>

      <button type="button" class="w3-button w3-red w3-margin-top" onclick="location.href='<%= application.getContextPath()%>/index.jsp'">홈으로</button>
    </div>
   </div>
</body>
</html>