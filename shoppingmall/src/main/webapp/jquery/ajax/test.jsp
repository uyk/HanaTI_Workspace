<%@page import="java.io.InputStream"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
System.out.println("요청수신");

// 서블릿 API를 이용한 업로드 파일 데이터 직접 수신
InputStream in = request.getInputStream();
byte[] buffer = new byte[1024];
int count = 0;
while((count=in.read(buffer)) != -1){
   System.out.println(new String(buffer, "utf-8"));
}
in.close();

out.println("ok!!!");

%>