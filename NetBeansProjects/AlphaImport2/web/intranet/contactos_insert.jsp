<%@page import="GestionBD.GestionBD"%>
<%
GestionBD og=new GestionBD();
og.conectar();
String id=request.getParameter("txt1");
String nom=request.getParameter("txt2");
String tel=request.getParameter("txt3");
String ema=request.getParameter("txt4");
String com=request.getParameter("txt5");
String fe=request.getParameter("txt6");


String sql="insert contactos values('"+id+"','"+nom+"','"+tel+"','"+ema+"','"+com+"','"+fe+"')";

og.Actualizar(sql);
og.CerrarConex(sql);
response.sendRedirect("contactos.jsp");
%>