package com.hospital.proyecto2.DBManage;

import com.hospital.proyecto2.exepcionesDePrograma.RegistroDuplicado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.commons.codec.digest.DigestUtils;

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
            password = DigestUtils.md5Hex(password);
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
    /**
     * VERIFICA SI EXISTE UN YA EXISTE UN USUARIO EN LA BASE DE DATOS
     * ,true = si existe,
     * false = no existe
     * @param usuario
     * @return 
     */
    public boolean existenciaDeRegistroUsuario(String usuario){
        boolean respuesta= false;
        String consulta = "SELECT rol FROM USUARIO WHERE usuario = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, usuario);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                    respuesta=true;
                }
            } catch (Exception e) {
            }
        }catch(Exception e){
        }
        return respuesta;
    }
    /**
     * VERIFICA SI EXISTE UN YA EXISTE UN USUARIO EN LA BASE DE DATOS
     * ,true = si existe,
     * false = no existe
     * @param usuario
     * @return 
     */
    public boolean existenciaDePaciente(String dpi){
        boolean respuesta= false;
        String consulta = "SELECT codigo FROM PACIENTE WHERE dpi = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, dpi);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                    respuesta=true;
                }
            } catch (Exception e) {
            }
        }catch(Exception e){
        }
        return respuesta;
    }
}
