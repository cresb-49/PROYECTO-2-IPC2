
<%@page import="com.hospital.proyecto2.Objetos.hospital"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hospital.proyecto2.Objetos.admin"%>
<%@page import="com.hospital.proyecto2.LecturaXML.*"%>
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
            hospital hos=new hospital();
            try {
                lecturaXML leer = new lecturaXML();
                hos=leer.leerXML();
            } catch (Exception e) {
                out.write(e.getMessage());
            }
            out.write(hos.getAdmins().size());
            
        %>
        <form action="acount.jsp" method="post">
            Usuario: <input type="text" name="usuario"><br>
            Password:<input type="password" name="password"><br>
            <input type="submit" name="enviar" value="Ingresar">
        </form>
        
    </body>
</html>
