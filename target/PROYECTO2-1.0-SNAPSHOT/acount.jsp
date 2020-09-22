<%@page import="java.sql.*"%>
<%@page import="com.hospital.proyecto2.DBManage.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
        <title>User</title>
    </head>
    <body>
        
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
            </div>
        </header>
        
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
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
