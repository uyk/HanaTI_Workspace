<%@page import="kr.or.kosta.blog.guest.dao.GuestNoteDao"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="kr.or.kosta.blog.common.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="guestNote" class="kr.or.kosta.blog.guest.domain.GuestNote"></jsp:useBean>
<jsp:setProperty property="*" name="guestNote"></jsp:setProperty>
<%
DaoFactory factory = new JdbcDaoFactory();
GuestNoteDao dao = factory.getGuestNoteDao();
String message = "";
if(guestNote.getUserId() == null || guestNote.getContents() == null) {
  message = "fail";
} 
else { 
  dao.create(guestNote);
  message = "sucess";
}
response.sendRedirect("/guestBook.jsp?message=" + message);
%>  