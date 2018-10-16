<%@ page contentType="text/html; charset=utf-8" %>
<% int age = 10; %>
<jsp:forward page="../hello.jsp">
  <jsp:param value="bangry" name="name" ></jsp:param>
  <jsp:param value="<%=age %>" name="age"/>
</jsp:forward>
<% 
request.setAttribute("name","bangry");
application.getRequestDispatcher("../hello.jsp").forward(request, response); 
//application.getRequestDispatcher("../hello.jsp?name=bangry").forward(request, response); 
%>