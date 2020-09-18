
package com.hospital.proyecto2.ConvercionesDeTiempo;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author benjamin
 */
public class ConvercionesFechaTiempo {
    
    public ConvercionesFechaTiempo(){
        
    }
    /**
     * Parcea una cadena String a Time con formato HH:mm
     * Si la cadena es valida devolvera un valor diferente de NULL
     * @param cadena
     * @return 
     */
    public Time stringToTime(String cadena){
        Time resultado=null;
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
        try {
            resultado = new Time(formatoHora.parse(cadena).getTime());
        } catch (Exception e) {
        }
        return resultado;
    }
    /**
     * Parcea una cadena String a Date con formato yyyy-MM-dd
     * Si la cadena es valida devolvera un valor diferende de NULL
     * @param cadena
     * @return 
     */
    public java.sql.Date stringToDate(String cadena){
        java.sql.Date resultado =null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            resultado= new java.sql.Date(formatoFecha.parse(cadena).getTime());
        } catch (Exception e) {
        }
        return resultado;
    }
}

