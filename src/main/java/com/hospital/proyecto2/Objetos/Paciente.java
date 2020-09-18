package com.hospital.proyecto2.Objetos;

import java.sql.Date;

public class Paciente{
    
    private Long codigo;
    private String nombre;
    private String DPI;
    private String password;
    private String telefono;
    private String correo;
    
    private String sexo;
    private Date cumple;
    private Double peso;
    private String sangre;
    /**
     * CONSTRUCTOR DE LA CLASE PACIETNE
     */
    public Paciente(){
        
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Retorna el sexo del paciente
     * @return 
     */
    public String getSexo() {
        return sexo;
    }
    /**
     * Asigna el sexo del paciente
     * @param sexo 
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    /**
     * Retorna la fecha de cumpleaños del paciente
     * @return 
     */
    public Date getCumple() {
        return cumple;
    }
    /**
     * Asigna la fecha de cumpleaños del paciente
     * @param cumple 
     */
    public void setCumple(Date cumple) {
        this.cumple = cumple;
    }
    /**
     * Retorna el peso del paciente
     * @return 
     */
    public Double getPeso() {
        return peso;
    }
    /**
     * Asigna el peso del paciente
     * @param peso 
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    /**
     * Retorna el tipo de sangre del paciente
     * @return 
     */
    public String getSangre() {
        return sangre;
    }
    /**
     * Asigna el tipo de sangre del paciente
     * @param sangre 
     */
    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    @Override
    public String toString() {
        return "Paciente{" + "codigo=" + codigo + ", nombre=" + nombre + ", DPI=" + DPI + ", password=" + password + ", telefono=" + telefono + ", correo=" + correo + ", sexo=" + sexo + ", cumple=" + cumple + ", peso=" + peso + ", sangre=" + sangre + '}';
    }
}
