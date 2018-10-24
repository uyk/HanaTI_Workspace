<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<c:redirect url="https://www.daum.net"></c:redirect> --%>
<%--
<c:redirect url="https://www.daum.net">
  <c:param name="name" value="bangry"></c:param>
</c:redirect>
 --%>
 <c:url value="/index.jsp" context="/" var="url"></c:url>
<c:redirect url="/index.jsp" context="/"></c:redirect>
<c:redirect url="${url }"></c:redirect>