/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.proyecto2.DBManage;

import com.hospital.proyecto2.Objetos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author benjamin
 */
public class RegistroDB {
    Connection conexion;
    public RegistroDB(Connection conexion) {
        this.conexion=conexion;
    }
    
    public boolean registroPaciente(Paciente paciente){
        boolean respuesta=false;
        String query ="INSERT INTO PACIENTE (nombre,dpi,telefono,email,sexo,peso,tipo_sangre,fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?)";
        //Asignacion de los datos de la variables
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
            preSt.setString(1, paciente.getNombre());
            preSt.setString(2, paciente.getDPI());
            preSt.setString(3, paciente.getTelefono());
            preSt.setString(4, paciente.getCorreo());
            preSt.setString(5, paciente.getSexo());
            preSt.setDouble(6, paciente.getPeso());
            preSt.setString(7, paciente.getSangre());
            preSt.setDate(8, paciente.getCumple());
            //
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            respuesta=false;
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    /**
     * REALIZA EL REGISTRO DE USUARIOS PARA EL INGRESO AL SISTEMA
     * @param usuario
     * @return 
     */
    public boolean registroUsuario(Object usuario){
        boolean respuesta=false;
        String query ="INSERT INTO USUARIO (usuario,password,rol) VALUES (?,?,?)";
        if((usuario instanceof Trabajador)||(usuario instanceof Paciente)){
            
            String user=null;
            String password=null;
            String rol=null;
            
            if(usuario instanceof Paciente){
                user=((Paciente) usuario).getCorreo();
                password = ((Paciente) usuario).getPassword();
                rol="paciente";
            }
            if(usuario instanceof Trabajador){
                if(usuario instanceof Admin){
                    user=((Admin) usuario).getCodigo();
                }else{
                    user=((Trabajador) usuario).getCorreo();
                }
                password=((Trabajador) usuario).getPassword();
                rol=((Trabajador) usuario).getRol();
            }
            try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            //ASIGNACION DE VALORES PARA REALIZAR EL REGISTRO
                preSt.setString(1, user);
                preSt.setString(2, password);
                preSt.setString(3, rol);
                //
                preSt.executeUpdate();
                preSt.close();
            } catch (Exception e) {
                respuesta=false;
            }
        }
        return respuesta;
    }
}
