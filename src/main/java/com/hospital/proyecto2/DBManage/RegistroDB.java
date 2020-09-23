/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.proyecto2.DBManage;

import com.hospital.proyecto2.Objetos.*;
import com.hospital.proyecto2.VerificacionContenido.VerificarContenido;
import com.hospital.proyecto2.exepcionesDePrograma.AtributosIncompletos;
import com.hospital.proyecto2.exepcionesDePrograma.RegistroDuplicado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author benjamin
 */
public class RegistroDB {
    private Connection conexion;
    private VerificarContenido verificacion = new VerificarContenido();
    private ConsultasDB consulta;
    public RegistroDB(Connection conexion) {
        this.conexion=conexion;
        consulta= new ConsultasDB(conexion);
    }
    public String registroPaciente(Paciente paciente,String tipo){
        String respuesta="";
        String query ="";
        if(tipo.equals("exportado")){
            query ="INSERT INTO PACIENTE (codigo,nombre,dpi,telefono,email,sexo,peso,tipo_sangre,fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?,?)";
        }
        if(tipo.equals("nuevo")){
            query ="INSERT INTO PACIENTE (nombre,dpi,telefono,email,sexo,peso,tipo_sangre,fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?)";
        }
        //Asignacion de los datos de la variables
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            if(tipo.equals("exportado")){
                //Verifica los datos de entrada
                this.verificacion.verificarPacienteExportado(paciente);
                preSt.setLong(1, paciente.getCodigo());
                preSt.setString(2, paciente.getNombre());
                preSt.setString(3, paciente.getDPI());
                preSt.setString(4, paciente.getTelefono());
                preSt.setString(5, paciente.getCorreo());
                preSt.setString(6, paciente.getSexo());
                preSt.setDouble(7, paciente.getPeso());
                preSt.setString(8, paciente.getSangre());
                preSt.setDate(9, paciente.getCumple());
            }
            if(tipo.equals("nuevo")){
                //Verifica los datos de entrada
                this.verificacion.verificarPacienteCreado(paciente);
                preSt.setString(1, paciente.getNombre());
                preSt.setString(2, paciente.getDPI());
                preSt.setString(3, paciente.getTelefono());
                preSt.setString(4, paciente.getCorreo());
                preSt.setString(5, paciente.getSexo());
                preSt.setDouble(6, paciente.getPeso());
                preSt.setString(7, paciente.getSangre());
                preSt.setDate(8, paciente.getCumple());
            }
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta="Paciente: "+paciente.getCodigo()+" "+e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    /**
     * REALIZA EL REGISTRO DE USUARIOS PARA EL INGRESO AL SISTEMA
     * @param usuario
     * @param tipo
     * @return 
     */
    public String registroUsuario(Object usuario,String tipo){
        String respuesta="";
        String user="";
        String password="";
        String rol="";
        String query ="INSERT INTO USUARIO (usuario,password,rol) VALUES (?,?,?)";
        if((usuario instanceof Trabajador)||(usuario instanceof Paciente)){
            try {
                if(usuario instanceof Paciente){
                    user=((Paciente) usuario).getCorreo();
                    password = ((Paciente) usuario).getPassword();
                    rol="paciente";
                    if(tipo.equals("exportado")){
                        this.verificacion.verificarPacienteExportado((Paciente) usuario);
                    }
                    if(tipo.equals("nuevo")){
                        this.verificacion.verificarPacienteCreado((Paciente) usuario);
                    }
                    
                }
                if(usuario instanceof Trabajador){
                    if(usuario instanceof Admin){
                        user=((Admin) usuario).getCodigo();
                        this.verificacion.verificarAdmin((Admin) usuario);
                    }else{
                        user=((Trabajador) usuario).getCorreo();
                        if(usuario instanceof Laboratorista){
                            this.verificacion.verificarLaboratorista((Laboratorista) usuario);
                        }
                        if(usuario instanceof Doctor){
                            this.verificacion.verificarDoctor((Doctor)usuario);
                        }
                    }
                    password=((Trabajador) usuario).getPassword();
                    rol=((Trabajador) usuario).getRol();
                }
                if(!consulta.existenciaDeRegistroUsuario(user)){
                    try(PreparedStatement preSt = conexion.prepareStatement(query)) {
                        //Verificacion de los valores de usuario
                        this.verificacion.verificarUsuario(user, password, rol);
                        password = DigestUtils.md5Hex(password);
                        //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                        preSt.setString(1, user);
                        preSt.setString(2, password);
                        preSt.setString(3, rol);
                        //
                        preSt.executeUpdate();
                        preSt.close();
                    } catch (Exception e) {
                        respuesta="-Usuario: "+user+" rol: "+rol+" "+e.getMessage();
                        System.out.println(respuesta);
                    }
                }else{
                    respuesta="Usuario: "+user+" rol: "+rol+" el registro ya existe en la base de datos";
                }
                
            } catch (Exception e) {
                respuesta="Usuario: "+user+" rol: "+rol+" "+e.getMessage();
                System.out.println(respuesta);
            }
            
        }else{
            return "El objeto que esta registrado no es un usuario";
        }
        return respuesta;
    }
    public String registroDoctor(Doctor doctor){
        String respuesta="";
        String query ="INSERT INTO MEDICO(codigo,dpi,email,fin_horario,inicio_horario,inicio_labores,nombre,numero_colegiado,telefono)values(?,?,?,?,?,?,?,?,?)";
        //Asignacion de los datos de la variables
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            //Verificacion de la informacion de entrada
            this.verificacion.verificarDoctor(doctor);
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            preSt.setString(1,doctor.getCodigo());
            preSt.setString(2,doctor.getDPI());
            preSt.setString(3,doctor.getCorreo());
            preSt.setTime(4,doctor.getFin());
            preSt.setTime(5,doctor.getInicio());
            preSt.setDate(6,doctor.getInicioTrabajo());
            preSt.setString(7,doctor.getNombre());
            preSt.setString(8,doctor.getColegiado());
            preSt.setString(9,doctor.getTelefono());
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta="Medico: "+doctor.getNombre()+" codigo: "+doctor.getCodigo()+" "+e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    
    public String registroAdmin(Admin admin){
        String respuesta="";
        String query ="INSERT INTO ADMINISTRADOR (codigo,dpi,nombre) VALUES (?,?,?)";
        //Asignacion de los datos de la variables
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            //VERIFICACION DE LA INFORMACION DE ENTRADA
            this.verificacion.verificarAdmin(admin);
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            preSt.setString(1,admin.getCodigo());
            preSt.setString(2,admin.getDPI());
            preSt.setString(3,admin.getNombre());
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta="Admin: "+admin.getNombre()+" codigo: "+admin.getCodigo()+e.getMessage();
            System.out.println(e.getMessage());
        }
        return respuesta;
    } 
    public String registroLaboratorista(Laboratorista laboratorista){
        String respuesta="";
        String query ="INSERT INTO LABORATORISTA (codigo, dpi, email, inicio_labores, nombre, numero_registro, telefono, tipo_examen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        //Asignacion de los datos de la variables
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            //Verificacion de la informacion de entrada
            this.verificacion.verificarLaboratorista(laboratorista);
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            preSt.setString(1,laboratorista.getCodigo());
            preSt.setString(2,laboratorista.getDPI());
            preSt.setString(3,laboratorista.getCorreo());
            preSt.setDate(4,laboratorista.getInicioTrabajo());
            preSt.setString(5,laboratorista.getNombre());
            preSt.setString(6,laboratorista.getRegistro());
            preSt.setString(7,laboratorista.getTelefono());
            preSt.setString(8,laboratorista.getExamen());
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta="Laboratorista: "+laboratorista.getNombre()+" codigo: "+laboratorista.getCodigo()+" "+e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    public ArrayList<String> trasladarDatosHospital(Hospital hospital){
        ///Buffer de resultados de cada registro
        String resultado="";
        ArrayList<String> errores = new ArrayList<>();
        for (Admin admin:hospital.getAdmins()){
            resultado = registroUsuario(admin,"exportado");
            if(!resultado.equals("")){
                errores.add(resultado);
            }else{
                resultado = registroAdmin(admin);
                if(!resultado.equals("")){
                    errores.add(resultado);
                }
            }
        }
        for(Paciente paciente:hospital.getPacientes()){
            resultado=registroUsuario(paciente, "exportado");
            if(!resultado.equals("")){
                errores.add(resultado);
            }else{
                resultado = registroPaciente(paciente,"exportado");
                if(!resultado.equals("")){
                    errores.add(resultado);
                }
            }
        }
        for(Doctor doctor:hospital.getDoctores()){
            resultado=registroUsuario(doctor, "exportado");
            if(!resultado.equals("")){
                errores.add(resultado);
            }else{
                resultado=registroDoctor(doctor);
                if(!resultado.equals("")){
                    errores.add(resultado);
                }
            }
        }
        for(Laboratorista lab :hospital.getLaboratoristas()){
            resultado=registroUsuario(lab, "exportado");
            if(!resultado.equals("")){
                errores.add(resultado);
            }else{
                resultado=registroLaboratorista(lab);
                if(!resultado.equals("")){
                    errores.add(resultado);
                }
            }
        }
        System.out.println(errores.toString());
        return errores;
    }
}
