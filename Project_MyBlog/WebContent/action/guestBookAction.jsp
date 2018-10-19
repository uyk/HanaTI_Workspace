<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.guest.dao.GuestNoteDao"%>
<%@page import="kr.or.kosta.blog.guest.domain.GuestNote"%>
<%@page import="kr.or.kosta.blog.common.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");
DaoFactory factory = new JdbcDaoFactory();
GuestNoteDao dao = factory.getGuestNoteDao();
List<GuestNote> list = dao.listAll();
%>

<!-- 포스트 리스트 시작 -->
<div class="row mb-5 mt-5">
  <div class="col-md-12">
    <%
    for(int i=0; i<list.size(); i++){
      GuestNote guestNote = list.get(i);
    %>
      <div class="post-entry-horzontal">
        <a style="width: -webkit-fill-available;">
        
          <!-- <div class="image element-animate" data-animate-effect="fadeIn" style="background-image: url(/images/img_10.jpg);"></div> -->
          <span class="text">
            <div class="post-meta">
              <span class="category"><%=guestNote.getUserId()%></span>
              <span class="mr-2"><%=guestNote.getRegdate() %></span> &bullet;
              <!-- <span class="ml-2"><span class="fa fa-comments"></span> 3</span> -->
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
<!-- 포스트 리스트 끝 -->