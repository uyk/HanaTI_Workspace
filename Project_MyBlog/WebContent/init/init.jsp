<%@page import="kr.or.kosta.blog.common.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.common.DaoFactory"%>
<%!
public void jspInit() {
   DaoFactory factory = new JdbcDaoFactory();
   getServletContext().setAttribute("factory", factory);
}
%>