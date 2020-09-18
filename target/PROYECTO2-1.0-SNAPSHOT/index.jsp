<%@page import="com.hospital.proyecto2.LecturaXML.lecturaXML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <title>Hospital</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
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
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
            </div>
        </header>
        
        <div class="container">
            <section class="main row">
                <article class="col-md-4">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                    </p>
                </article>
                <div class="container col-md-4">
                    <form  action="acount.jsp" method="post">
                        <h2>Inicio sesion</h2>
                        <div class="form-group">
                            <label for="usuario">Usuario:</label>
                            <input class="form-control" id="usuario" type="text" name="usuario">
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input class="form-control" id="password" type="password" name="password">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary" type="submit" name="enviar" value="Ingresar">Ingresar</button>
                        </div>
                    </form>
                </div>
                
            </section>
        </div>
        
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
