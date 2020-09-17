<%@page import="java.sql.*"%>
<%@page import="com.hospital.proyecto2.DBManage.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
            
            String user = request.getParameter("usuario");
            String pass = request.getParameter("password");
            String mensaje="";
            try {
                ConnectionDB cnx = new ConnectionDB();
                mensaje="La conexion fue un exito";
                
            } catch (Exception e) {
                mensaje=e.getClass().toString();
            }
        %>
        Usuario: <%=user%><br>
        Password: <%=pass%><br>
        Connexion: <%=mensaje%><br>
        <a href="index.jsp">Volver a pagina principal</a>
    </body>
</html>
