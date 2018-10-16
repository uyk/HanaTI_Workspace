<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>JSP가 제공하는 4개의 스코프(컨텍스트) 객체들..</h2>

현재 페이지 메시지 : <%=pageContext.getAttribute("message") %> <br/>
리퀘스트 메시지 : <%=request.getAttribute("message") %> <br/>
세션 메시지 : <%=session.getAttribute("message") %> <br/>
애플리케이션 메시지 : <%=application  .getAttribute("message") %> <br/>

</body>
</html>