<%@page import="GestionBD.GestionBD"%>
<%
GestionBD og=new GestionBD();
og.conectar();
String id=request.getParameter("txt1");
String nom=request.getParameter("txt2");
String dir=request.getParameter("txt3");
String tel=request.getParameter("txt4");
String ruc=request.getParameter("txt5");
String img=request.getParameter("txt6");


String sql="insert clientes values('"+id+"','"+nom+"','"+dir+"','"+tel+"','"+ruc+"','clientes/"+img+"')";

og.Actualizar(sql);
og.CerrarConex(sql);
response.sendRedirect("clientes.jsp");
%>