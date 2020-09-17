package com.hospital.proyecto2.Objetos;


public class admin {
    private String codigo;
    private String dpi;
    private String nombre;
    private String password;
    /**
     * CONSTRUCTOR VACIO CLASE ADMIN
     */
    public admin(){

    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}