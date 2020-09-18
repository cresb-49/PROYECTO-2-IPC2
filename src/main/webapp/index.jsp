<%@page import="com.hospital.proyecto2.LecturaXML.lecturaXML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <title>Hospital</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
        <%
            lecturaXML xml = new lecturaXML();
            try {
                xml.leer();
            } catch (Exception e) {
                out.write(e.getMessage());
            }
        %>
        <div class="container">
            <h1>HOSPITAL</h1>
            <p>
                
            </p>
        </div>
        <form action="acount.jsp" method="post">
            Usuario: <input type="text" name="usuario"><br>
            Password:<input type="password" name="password"><br>
            <input type="submit" name="enviar" value="Ingresar">
        </form>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
