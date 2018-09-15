<%@page import="GestionBD.GestionBD"%>
<%
    try{
    //recepcionamos datos del form
    String n=request.getParameter("txtNombre");
    String t=request.getParameter("txtTelf");
    String e=request.getParameter("txtEmail");
    String c=request.getParameter("txtComentario");
    
    //instanciamos la clase
    GestionBD og=new GestionBD();
    og.conectar();
    
    //crar la cadena sql de  insercion
    String sql="insert contactos(nombres,telefono,email,comentario,fecha)"+"values('"+n+"','"+t+"','"+e+"','"+c+"',CURDATE())";
    
    //ehjecutando actualizacion
    og.Actualizar(sql);
    og.CerrarConex(sql);
    
    //redireccionando a la pagina de confirmaciion
    response.sendRedirect("../index.jsp");
    }catch(Exception e){
        out.println("<center><h1>LA CONEXION SE JODIO TODITA</h1></center>"+e.getMessage());
    }
%>