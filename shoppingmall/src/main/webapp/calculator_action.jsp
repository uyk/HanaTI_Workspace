<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
String num1 = request.getParameter("num1");
if(num1 == null)  num1 = "0";
String num2 = request.getParameter("num2");
if(num2 == null)  num2 = "0";

int op1 = Integer.parseInt(num1);
int op2 = Integer.parseInt(num2);
String operator = request.getParameter("operator");

int result = 0;
switch(operator){
  //case "+" : result = op1 + op2; break;
  case "-" : result = op1 - op2; break;
  case "*" : result = op1 * op2; break;
  case "/" : result = op1 / op2; break;
  default  : result = op1 + op2; break;
}
out.println(result);
%>
