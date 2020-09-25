<%@page import="com.hospital.proyecto2.Objetos.Archivo"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.hospital.proyecto2.DBManage.RegistroDB"%>
<%@page import="com.hospital.proyecto2.DBManage.ConnectionDB"%>
<%@page import="com.hospital.proyecto2.Objetos.Hospital"%>
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
            //Directorio linux
            String srcGuardado="/home/benjamin/Documentos/IPC 2/PROYECTO 2/Almacenamiento/tmp";
            //Directorio windows
            //String srcGuardado="D:/Escritorio/Temporal Proyecto 2/tmp";
            //Generacion de la escritura del archivo
            DiskFileItemFactory itemFactory =  new DiskFileItemFactory();
            //Tamaño maximo de archivos de recepcion
            itemFactory.setSizeThreshold(1024);
            //Asignacion del repositorio de escritura del archivo xml
            //itemFactory.setRepository(new File(srcGuardado));
            //Asignacion de carga del archivo xml
            ServletFileUpload upload = new ServletFileUpload(itemFactory);
            //Partes del archivo
            List<FileItem> partes = upload.parseRequest(request);
            ArrayList<Archivo> archivos = new ArrayList<Archivo>();
            try {
                //Escritura de todos los archivos en la entrada de la pagina WEB
                for(FileItem items: partes){
                    System.out.println(items.getName());
                    archivos.add(new Archivo(items.getName(),items.getInputStream()));
                    //File file = new File(srcGuardado, items.getName());
                    
                    //items.write(file);
                }                
                for(Archivo arch : archivos){
                    System.out.println(arch.toString());
                }
                //Lista de errores al moemnto de la carga del archivo
                ArrayList<String> errores = new ArrayList<>();
                //Manejo de la conexion de la base de datos
                ConnectionDB conexion = new ConnectionDB();
                //Parte de registro para la base de datos
                RegistroDB registro = new RegistroDB(conexion.getConexion());
                //Generacion del objeto hospital
                Hospital hospital=null;
                
                
                if(!archivos.isEmpty()){
                    for(Archivo arch: archivos){
                        if(arch.getNombre().endsWith(".xml")){
                            lecturaXML lectura = new lecturaXML();
                            hospital=lectura.leer(arch.getDatos());
                            errores=registro.trasladarDatosHospital(hospital,archivos);
                        }
                    }
                }
                
                /*
                //Directorio nonde se guardan los archivos que recibio la pagina web
                File directorio = new File(srcGuardado);
                
                //Comprobacion si el direcorio existe
                if(directorio.exists()){
                    //Cargamos los archivos en el programa
                    File[] ficheros = directorio.listFiles();
                    for(File f:ficheros){
                        if(f.getName().endsWith(".xml")){
                            lecturaXML lectura = new lecturaXML();
                            hospital=lectura.leer(f);
                            errores=registro.trasladarDatosHospital(hospital,ficheros);
                        }
                    }
                    //Eliminacion de los datos temporales
                    for(File f:ficheros){
                        f.delete();
                    }
                }
                */
                
                if(!errores.isEmpty()){
                %>
                <div class="container">
                    <h1>ERROR EN LA CARGA DE DATOS EN LA BASE DE DATOS</h1>
                    <div class="container alert alert-danger" role="alert">
                        <%
                            for(String error :errores){
                        %>
                        <p><%out.write(error); %></p>
                        <%
                            }
                        %>
                        
                    </div>
                    <a class="btn btn-danger" href="../index.jsp">Regresar al inicio</a>
                </div>
                <%
                    
                }else{
                %>
                <div class="container">
                    <h1>EL ARCHIVO SE A SUBIDO CORRECTAMENTE</h1>
                    <div class="container alert alert-success" role="alert">Datos trasladados al 100% puede regresar al inicio</div>
                    <a class="btn btn-success" href="../index.jsp">Regresar al inicio</a>
                </div>
                <%
                }
            } catch (Exception e) {
                %>
                <div class="container">
                    <h1>ERROR EN LA CARGA DE DATOS EN LA BASE DE DATOS</h1>
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
