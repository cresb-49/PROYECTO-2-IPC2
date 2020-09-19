<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DOCTOR </title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <%
            String usuario = request.getParameter("usuario");
            System.out.println("Usuario: "+usuario);
        %>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
                <h2>Perfil Doctor</h2>
            </div>
        </header>
        
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
