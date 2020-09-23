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
    </head>
    <body>
        <%
            String user = request.getParameter("usuario");
            String pass = request.getParameter("password");
            String token = request.getParameter("resgistrar");
            String acction = request.getParameter("token");
            System.out.println("Token: "+token);
            System.out.println("Acction: "+acction);
            System.out.println("Usuario: "+user+" Password: "+pass);
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
                    System.out.println(nuevoPaciente.toString());
                    ConnectionDB cnx = new ConnectionDB();
                    RegistroDB registro = new RegistroDB(cnx.getConexion());
                    ConsultasDB consultas = new ConsultasDB(cnx.getConexion());
                    
                    if(!consultas.existenciaDeRegistroUsuario(nuevoPaciente.getCorreo())){
                        if(!consultas.existenciaDePaciente(nuevoPaciente.getDPI())){
                            registro.registroPaciente(nuevoPaciente,"nuevo");
                            registro.registroUsuario(nuevoPaciente, "nuevo");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                        else{
                            request.getRequestDispatcher("registarUsuario.jsp"+
                                "?existsR=2").forward(request, response);
                        }
                    }else{
                        request.getRequestDispatcher("registarUsuario.jsp"+
                                "?Rnombre="+nuevoPaciente.getNombre()+
                                "?Rfecha="+nuevoPaciente.getCumple()+
                                "&RDPI="+nuevoPaciente.getDPI()+
                                "&Rtelefono="+nuevoPaciente.getTelefono()+
                                "&Rpeso="+nuevoPaciente.getPeso()+
                                "&Rsexo="+nuevoPaciente.getSexo()+
                                "&Rsangre=\""+nuevoPaciente.getSangre()+"\""+
                                "existsR=1").forward(request, response);
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
                        request.getRequestDispatcher("usuarios/perfilAdmin.jsp?usuario="+user).forward(request, response);
                    }
                    if(resultado.equals("doctor")){
                        request.getRequestDispatcher("usuarios/perfilDoctor.jsp?usuario="+user).forward(request, response);
                    }
                    if(resultado.equals("paciente")){
                        request.getRequestDispatcher("usuarios/perfilPaciente.jsp?usuario="+user).forward(request, response);
                    }
                    if(resultado.equals("laboratorista")){
                        request.getRequestDispatcher("usuarios/perfilLaboratorista.jsp?usuario="+user).forward(request, response);
                    }
                    cnx.cerrarConexion();
                } catch (Exception e) {
                }
            }
        %>
    </body>
</html>
