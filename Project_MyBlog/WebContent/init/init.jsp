<%-- 애플리케이션이 초기화 될 때 실행되어 Factory를 애플리케이션 영역에 저장하는 jsp파일 --%>
<%@page import="kr.or.kosta.blog.common.JdbcDaoFactory2"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%!
public void jspInit() {
   DaoFactory factory = new JdbcDaoFactory2();
   getServletContext().setAttribute("factory", factory);
}
%>