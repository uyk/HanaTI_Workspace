<%@page import="kr.or.kosta.jsp.Account"%>
<%@ page contentType="text/html; charset=utf-8" %>
<% 
//Account account = new Account("1111-2222", "유예겸", 1111, 10000);
//Class.forName("kr.or.kosta.jsp.Account").newInstance();
%>
<jsp:useBean id="account" class="kr.or.kosta.jsp.Account" scope="session"></jsp:useBean>
<jsp:setProperty property="accountNum" name="account" value="1111-2222"></jsp:setProperty>
<jsp:setProperty property="accountOwner" name="account" value="유예겸"></jsp:setProperty>
<jsp:setProperty property="passwd" name="account" value="1234"></jsp:setProperty>
<jsp:setProperty property="restMoney" name="account" value="100000"></jsp:setProperty>

<%--<jsp:forward page="userBeanExample2.jsp"> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
계좌번호 : <%=account.getAccountNum() %> <br/>
예금주명 : <%=account.getAccountOwner() %> <br/>
비밀번호 : <%=account.getPasswd() %> <br/>
잔액 : <%=account.getRestMoney() %> <br/>
---------------------------------------------------<br/>
계좌번호 : <jsp:getProperty property="accountNum" name="account"/> <br/>
예금주명 : <jsp:getProperty property="accountOwner" name="account"/> <br/>
비밀번호 : <jsp:getProperty property="passwd" name="account"/> <br/>
잔액 : <jsp:getProperty property="restMoney" name="account"/> <br/>
</body>
</html>