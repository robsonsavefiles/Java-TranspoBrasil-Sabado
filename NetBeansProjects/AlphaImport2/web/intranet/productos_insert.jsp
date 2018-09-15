<%@page import="GestionBD.GestionBD"%>
<%
GestionBD og=new GestionBD();
og.conectar();
String id=request.getParameter("txt1");
String des=request.getParameter("txt2");
String mar=request.getParameter("txt3");
String pr=request.getParameter("txt4");
String st=request.getParameter("txt5");
String img=request.getParameter("txt6");

//int pr=Integer.parseInt(request.getParameter("txt4"));
//int st=Integer.parseInt(request.getParameter("txt5"));

String idc=request.getParameter("cboCat");
//int idc=Integer.parseInt(request.getParameter("cboCate"));

String sql="insert productos values('"+id+"','"+des+"','"+mar+"','"+pr+"','"+st+"','"+idc+"','images/"+img+"')";

og.Actualizar(sql);
og.CerrarConex(sql);
response.sendRedirect("productos.jsp");
%>