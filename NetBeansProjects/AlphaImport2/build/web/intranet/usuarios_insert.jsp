<%@page import="GestionBD.GestionBD"%>
<%
GestionBD og=new GestionBD();
og.conectar();
String id=request.getParameter("txt1");
String no=request.getParameter("txt2");
String al=request.getParameter("txt3");
String pw=request.getParameter("txt4");
String pf=request.getParameter("cboPerfil");
String sql="insert usuarios values('"+id+"','"+no+"','"+al+"','"+pw+"','"+pf+"')";
og.Actualizar(sql);
og.CerrarConex(sql);
response.sendRedirect("index.jsp");
%>
