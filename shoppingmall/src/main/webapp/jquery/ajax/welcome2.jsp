<%@ page contentType="text/plain; charset=utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
%>
<%=id %>, <%=name %>님 환영합니다.