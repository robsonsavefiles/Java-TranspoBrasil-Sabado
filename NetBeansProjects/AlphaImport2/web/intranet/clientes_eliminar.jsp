<%@page import="GestionBD.GestionBD"%>
<%
GestionBD og=new GestionBD();
og.conectar();
String id=request.getParameter("txtcodigo");



String sql="delete from  clientes where idCliente='"+id+"'";

og.Actualizar(sql);
og.CerrarConex(sql);
response.sendRedirect("clientes.jsp");
%>