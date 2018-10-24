<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL 연습</title>
</head>
<body>
${ "김기정" }
${ '김기정' }
${10}
${null}
${true}
${false} <br/>
${ 10+20 } <br/>
<%= 10+ "20" %> <br/>
${ 10 / 20 } <br/>
${ true && false } <br/>
${ true and false } <br/>
${empty null} <br/>
${empty ""} <br/>
</body>
</html>