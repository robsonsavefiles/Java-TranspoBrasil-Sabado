<%@page import="GestionBD.GestionBD"%>
<%
    HttpSession sesion = request.getSession(true);
    try{
    //recepcionamos datos del form
    String ip=request.getParameter("id");
    String pr=request.getParameter("pp");
    String cant=request.getParameter("txtcantidad");
    String idcli="00001";
    
    //instanciamos la clase
    GestionBD og=new GestionBD();
    og.conectar();
    
    //crar la cadena sql de  insercion
    String sql="insert carrito values('"+sesion.getAttribute("s_id")+"',"+cant+","+sesion.getAttribute("s_pp")+",'"+idcli+"')";
    
    //ehjecutando actualizacion
    og.Actualizar(sql);
    og.CerrarConex(sql);
    
    //redireccionando a la pagina de confirmaciion
    response.sendRedirect("carrito.jsp");
    }catch(Exception e){
        out.println("<center><h1>LA CONEXION SE JODIO TODITA</h1></center>"+e.getMessage());
    }
%>