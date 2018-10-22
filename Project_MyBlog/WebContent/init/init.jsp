<%@page import="kr.or.kosta.blog.common.JdbcDaoFactory2"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%!
public void jspInit() {
   DaoFactory factory = new JdbcDaoFactory2();
   getServletContext().setAttribute("factory", factory);
}
%>