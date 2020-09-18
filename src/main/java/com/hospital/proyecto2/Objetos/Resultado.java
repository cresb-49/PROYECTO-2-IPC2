
package com.hospital.proyecto2.Objetos;

import java.sql.Date;
import java.sql.Time;

public class Resultado {
    
    private Long codigo;
    private Long codigoPaciente;
    private Long codigoExamen;
    private String codigoLaboratorista;
    private String orden;
    private String informe;
    private Date fecha;
    private Time hora;
    
    public Resultado(){
        
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Long codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public Long getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(Long codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
    }

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Resultado{" + "codigo=" + codigo + ", codigoPaciente=" + codigoPaciente + ", codigoExamen=" + codigoExamen + ", codigoLaboratorista=" + codigoLaboratorista + ", orden=" + orden + ", informe=" + informe + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
}
