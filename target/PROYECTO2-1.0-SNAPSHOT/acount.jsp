<%@page import="java.sql.*"%>
<%@page import="DBManage.*" %>
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
            Connection cnx=null;
            try {
                ConnectionDB conec = new ConnectionDB();
                cnx=conec.getConexion();
                
            } catch (Exception e) {
                mensaje=e.getClass().toString();
            }
        %>
        Usuario: <%=user%><br>
        Password: <%=pass%><br>
        Connexion: <%=mensaje%>
        <a href="index.jsp">Volver a pagina principal</a>
    </body>
</html>
