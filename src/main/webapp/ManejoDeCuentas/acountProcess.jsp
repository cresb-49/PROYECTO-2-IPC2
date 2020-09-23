<%-- 
    Document   : acountProcess
    Created on : 18/09/2020, 21:20:14
    Author     : benjamin
--%>

<%@page import="com.hospital.proyecto2.Objetos.*"%>
<%@page import="com.hospital.proyecto2.DBManage.*"%>
<%@page import="com.hospital.proyecto2.Converciones.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/estilos.css"/>
    </head>
    <body>
        <%
            String user = request.getParameter("usuario");
            String pass = request.getParameter("password");
            String token = request.getParameter("resgistrar");
            String acction = request.getParameter("token");
            
            if(acction==null){
                acction="";
            }
            if(acction.equals("registarUsuario")){
                try 
                {
                    ConvercionesVariables conv= new ConvercionesVariables();
                    //GENERACION DEL OBJETO PACIENTE PARA LUEGO HACER SU REGISTRO
                    
                    Paciente nuevoPaciente = new Paciente(request.getParameter("nombrePaciente")
                            , request.getParameter("DPIPaciente"),request.getParameter("passPaciente")
                            , request.getParameter("telefonoPaciente")
                            , request.getParameter("correoPaciente")
                            , request.getParameter("sexoPaciente")
                            , conv.stringToDate(request.getParameter("fechaNacimiento"))
                            , conv.stringToDouble(request.getParameter("pesoPaciente"))
                            , request.getParameter("tipoSangre"));
                    ConnectionDB cnx = new ConnectionDB();
                    RegistroDB registro = new RegistroDB(cnx.getConexion());
                    ConsultasDB consultas = new ConsultasDB(cnx.getConexion());
                    String resultado="";
                    if(!consultas.existenciaDeRegistroUsuario(nuevoPaciente.getCorreo())){
                            resultado=consultas.existenciaDePaciente(nuevoPaciente.getCodigo(), nuevoPaciente.getDPI(), nuevoPaciente.getCorreo(), nuevoPaciente.getTelefono());
                        if(resultado.equals("")){
                            registro.registroPaciente(nuevoPaciente,"nuevo");
                            registro.registroUsuario(nuevoPaciente, "nuevo");
                            response.sendRedirect("/PROYECTO2/index.jsp");
                        }
                        else{
                            request.setAttribute("nuevoPaciente",nuevoPaciente);
                            request.getRequestDispatcher("registrarUsuario.jsp?error="+resultado).forward(request, response);
                        }
                    }else{
                        resultado="El correo ya esta registrado";
                        System.out.println(resultado);
                        request.setAttribute("nuevoPaciente",nuevoPaciente);
                        request.getRequestDispatcher("registrarUsuario.jsp?error="+resultado).forward(request, response);
                    }
                    cnx.cerrarConexion();
                } catch (Exception e) {
                }
            }
            else{
                try
                {
                    ConnectionDB cnx = new ConnectionDB();
                    ConsultasDB consultas = new ConsultasDB(cnx.getConexion());
                    String resultado=consultas.accesoUsuario(user,pass);
                    if(resultado.equals("admin")){
                        request.getRequestDispatcher("/usuarios/perfilAdmin.jsp?usuario="+user).forward(request, response);
                    }
                    if(resultado.equals("doctor")){
                        request.getRequestDispatcher("/usuarios/perfilDoctor.jsp?usuario="+user).forward(request, response);
                    }
                    if(resultado.equals("paciente")){
                        request.getRequestDispatcher("/usuarios/perfilPaciente.jsp?usuario="+user).forward(request, response);
                    }
                    if(resultado.equals("laboratorista")){
                        request.getRequestDispatcher("/usuarios/perfilLaboratorista.jsp?usuario="+user).forward(request, response);
                    }
                    cnx.cerrarConexion();
                } catch (Exception e) {
                    response.sendRedirect("/PROYECTO2/index.jsp");
                }
            }
        %>
        <script src="../js/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>
