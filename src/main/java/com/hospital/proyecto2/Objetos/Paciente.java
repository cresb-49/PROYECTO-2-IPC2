package com.hospital.proyecto2.Objetos;

import java.sql.Date;

public class Paciente extends Persona{
    private String sexo;
    private Date cumple;
    private Double peso;
    private String sangre;
    /**
     * CONSTRUCTOR DE LA CLASE PACIETNE
     */
    public Paciente(){
        
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
        return "Paciente{" + "codigo=" + this.getCodigo() + ", DPI=" + this.getDPI() + ", nombre=" + this.getNombre() + ", password=" + this.getPassword() + "sexo=" + sexo + ", cumple=" + cumple + ", peso=" + peso + ", sangre=" + sangre + '}';
    }
    
}
