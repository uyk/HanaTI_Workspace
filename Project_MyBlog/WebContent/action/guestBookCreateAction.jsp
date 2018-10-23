<%-- create 메소드를 호출해 방명록을 작성하는 jsp파일 --%>
<%@page import="kr.or.kosta.blog.guest.dao.GuestNoteDao"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="guestNote" class="kr.or.kosta.blog.guest.domain.GuestNote"></jsp:useBean>
<jsp:setProperty property="*" name="guestNote"></jsp:setProperty>
<%
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
GuestNoteDao dao = factory.getGuestNoteDao();
String message = "";
// 방명록 작성 실패
if(guestNote.getUserId() == null || guestNote.getContents() == null) {
  message = "fail";     // 실패 메시지를 띄우기 위한 플래그
} 
// 방명록 작성 성공
else { 
  dao.create(guestNote);
  message = "sucess";
}
response.sendRedirect("/guestBook.jsp?message=" + message);
%>  