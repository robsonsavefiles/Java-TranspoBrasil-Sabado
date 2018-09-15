<%@page import="GestionBD.GestionBD"%>
<%
GestionBD og=new GestionBD();
og.conectar();
String id=request.getParameter("txtcodigo");



String sql="delete from  productos where idProducto='"+id+"'";

og.Actualizar(sql);
og.CerrarConex(sql);
response.sendRedirect("productos.jsp");
%>