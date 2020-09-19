package com.hospital.proyecto2.DBManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultasDB {
    Connection conexion;
    public ConsultasDB(Connection conexion){
        this.conexion=conexion;
    }
    public ConsultasDB(){
        
    }
    public boolean comprobarInformacion(){
        boolean resultado= false;
        String consulta = "SELECT * FROM USUARIO LIMIT 2";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                resultado=true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    /**
     * DEVULEVE EL ROL DEL USUARIO Y CONTRASENA INTRODUCIDOS
     * @param usuario
     * @param password
     * @return 
     */
    public String accesoUsuario(String usuario, String password){
        String respuesta= null;
        String consulta = "SELECT rol FROM USUARIO WHERE usuario = ? AND password = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, usuario);
            preSt.setString(2, password);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                    respuesta=result.getString(1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
}
