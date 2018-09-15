<%@page import="GestionBD.GestionBD"%>
<%
GestionBD og=new GestionBD();
og.conectar();
String id=request.getParameter("txtcodigo");
String nom=request.getParameter("txt2");
String dir=request.getParameter("txt3");
String tel=request.getParameter("txt4");
String ruc=request.getParameter("txt5");
String img=request.getParameter("txt6");


String sql="update clientes set Nombres_RS='"+nom+"', Direccion='"+dir+"', Telefono='"+tel+"', RUC_DNI='"+ruc+"', image='clientes/"+img+"' where idCliente='"+id+"'";

og.Actualizar(sql);
og.CerrarConex(sql);
response.sendRedirect("clientes.jsp");
%>
