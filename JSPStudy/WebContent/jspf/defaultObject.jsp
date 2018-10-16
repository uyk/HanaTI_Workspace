<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>JSP가 제공하는 9개의 디폴트 객체들..</h2>
<%
String id = request.getParameter("id");
if(id.equals("gg")) response.sendRedirect("../hello.jsp");
out.println("dd");
%>

아이디 : <%=id %><br/>
WAS에 등록된 웹 애플리케이션 이름 : <%=application.getContextPath() %><br/>
요청 URI : <%= application.getServerInfo() %><br/>
location : <%= config.getInitParameter("location") %><br/>
현재 페이지 : <%=this %><br/>
현재 페이지 : <%=page %><br/>
<%--예외 : <%=exception %> --%>
</body>
</html>