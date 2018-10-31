<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
String operator = request.getParameter("operator");
double result = 0.0;
switch(operator) {
case "+":
  result = num1 + num2;
  break;
case "-":
  result = num1 - num2;
  break;
case "*":
  result = num1 * num2;
  break;
case "/":
  result = num1 / num2;
  break;
}
response.sendRedirect("/calculator2.html?num1="+num1+"&num2="+num2+"&operator="+operator+"&result="+result);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

</body>
</html>