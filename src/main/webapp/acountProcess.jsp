<%-- 
    Document   : acountProcess
    Created on : 18/09/2020, 21:20:14
    Author     : benjamin
--%>

<%@page import="com.hospital.proyecto2.DBManage.ConsultasDB"%>
<%@page import="com.hospital.proyecto2.DBManage.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String user = request.getParameter("usuario");
            String pass = request.getParameter("password");
            System.out.println("Usuario: "+user+" Password: "+pass);
            try {
                ConnectionDB cnx = new ConnectionDB();
                ConsultasDB consultas = new ConsultasDB(cnx.getConexion());
                String resultado=consultas.accesoUsuario(user,pass);
                if(resultado.equals("admin")){
                    request.getRequestDispatcher("usuarios/perfilAdmin.jsp?usuario="+user).forward(request, response);
                }
                if(resultado.equals("doctor")){
                    request.getRequestDispatcher("usuarios/perfilDoctor.jsp?usuario="+user).forward(request, response);
                }
                
            } catch (Exception e) {
                //System.out.println(e.getMessage());
            }
        %>
    </body>
</html>
