<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL default object 11</title>
</head>
<body>
${pageContext.request.method}<hr>
쿠키 이름: ${cookie.loginId.name}<hr>
쿠키 값: ${cookie.loginId.value}<hr>
${param["name"]}<hr>
${param.name   }<hr>
-${param.a }-<hr>
-${paramValues.hobby }-<hr>
-${paramValues.hobby[0] }-<hr>
-${paramValues.hobby[1] }-<hr>
-${header['user-agent'] }-<hr>
-${headerValues['user-agent'] }-<hr>
-${headerValues['xxx'] }-<hr>
${ pageScope } <hr>
${ requestSropce } <hr/>
${sessionScope } <hr/>
${applicationScope} <hr/>

</body>
</html>