<%@page import="com.hospital.proyecto2.VerificacionContenido.VerificarContenido"%>
<%@page import="com.hospital.proyecto2.LecturaXML.lecturaXML"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carga de Archivos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <h1>HOSPITAL</h1>
            </div>
        </header>
        <%
            //Path principal de guardado de archivos
            String srcGuardado="/home/benjamin/Documentos/IPC 2/PROYECTO 2/Almacenamiento/tmp";
            //Generacion de la escritura del archivo
            DiskFileItemFactory itemFactory =  new DiskFileItemFactory();
            //Tamaño maximo de archivos de recepcion
            itemFactory.setSizeThreshold(1024);
            //Asignacion del repositorio de escritura del archivo xml
            itemFactory.setRepository(new File(srcGuardado));
            //Asignacion de carga del archivo xml
            ServletFileUpload upload = new ServletFileUpload(itemFactory);
            //Partes del archivo
            List<FileItem> partes = upload.parseRequest(request);
            
            try {
                
                for(FileItem items: partes){
                    File file = new File(srcGuardado, items.getName());
                    VerificarContenido verificacion = new VerificarContenido();
                    verificacion.archivoXML(file);
                    items.write(file);
                }
                %>
                <div class="container">
                    <h1>EL ARCHIVO SE A SUBIDO CORRECTAMENTE</h1>
                    <div class="container alert alert-success" role="alert">Datos trasladados al 100% puede regresar al inicio</div>
                    <a class="btn btn-success" href="../index.jsp">Regresar al inicio</a>
                </div>
                <%
                File doc = new File(srcGuardado+"/"+partes.get(0).getName());
                lecturaXML lectura  = new lecturaXML();
                lectura.leer(doc);
            } catch (Exception e) {
                %>
                <div class="container">
                    <h1>ERROR EN LA CARGA DE ARCHIVO</h1>
                    <div class="container alert alert-danger" role="alert"><%out.write(e.getMessage());%></div>
                    <a class="btn btn-danger" href="../index.jsp">Regresar al inicio</a>
                </div>
                <%
            }
        %>
        <br>
        <footer>
            <div class="container">
                <h3>© HOSPITAL 2020</h3>
            </div>
        </footer>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
