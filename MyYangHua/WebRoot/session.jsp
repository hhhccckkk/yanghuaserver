
<%@page import="com.hck.yanghua.bean.Admin"%>
<%
Admin admin=null;
admin=(Admin)session.getAttribute("admin");
if(admin==null)
{
	response.sendRedirect("login.jsp");
}
%>
