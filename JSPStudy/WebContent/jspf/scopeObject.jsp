<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>JSP가 제공하는 4개의 스코프(컨텍스트) 객체들..</h2>
<%
pageContext.setAttribute("message", "pageContext 스코프객체입니다"); // 현재 페이지에 정보 저장

request.setAttribute("message", "request 스코프객체입니다");         // 다른 페이지로 정보 전달
//application.getRequestDispatcher("/jspf/scopeObject2.jsp").forward(request, response);

session.setAttribute("message", "session 스코프객체입니다.");        // 세션에 데이터 저장

application.setAttribute("message", "accplication 스코프객체입니다."); // 범위가 가장 넓지만 거의 사용하지 않음
%>
현재 페이지 메시지 : <%=pageContext.getAttribute("message") %>

</body>
</html>