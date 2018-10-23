<%-- 방명록 목록을 출력하는 jsp파일 --%>

<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.guest.dao.GuestNoteDao"%>
<%@page import="kr.or.kosta.blog.guest.domain.GuestNote"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
GuestNoteDao dao = factory.getGuestNoteDao();
List<GuestNote> list = dao.listAll();
%>

<%-- 방명록 리스트 시작 --%>
<div class="row mb-5 mt-5">
  <div class="col-md-12">
    <%
    for(int i=0; i<list.size(); i++){
      GuestNote guestNote = list.get(i);
    %>
      <div class="post-entry-horzontal">
        <a style="width: -webkit-fill-available;">
        
          <span class="text">
            <div class="post-meta">
              <span class="category"><%=guestNote.getUserId()%></span>
              <span class="mr-2"><%=guestNote.getRegdate() %></span> &bullet;
            </div>
            <h2><%=guestNote.getContents() %></h2>
          </span>
        </a>
      </div>
    <%
    }
    %>
  </div>
</div>
<%-- 방명록 리스트 끝 --%>