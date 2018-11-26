<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h1>/sample/Login Admin Page</h1>
<a href="${pageContext.request.contextPath}/customLogout">Logout</a>

<%-- 관리자 정보 출력 --%>
<p>principal : <sec:authentication property="principal"/></p>
<p>Member : <sec:authentication property="principal.member"/></p>
<p>관리자 이름 : <sec:authentication property="principal.member.userName"/></p>

<p>관리자 아이디 : <sec:authentication property="principal.member.userId"/></p>
<p>관리자 권한 목록 : <sec:authentication property="principal.member.authList"/></p>
</body>
</html>