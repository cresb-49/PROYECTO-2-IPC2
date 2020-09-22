
package com.hospital.proyecto2.VerificacionContenido;

import com.hospital.proyecto2.exepcionesDePrograma.FormatoArchivoIncorrecto;
import com.hospital.proyecto2.exepcionesDePrograma.tipoDeSangreIncorrecto;
import java.io.File;

public class VerificarContenido {
    public VerificarContenido(){
        
    }
    public boolean verificarTipoInforme(String cadena){
        boolean respuesta=false;
        
        return respuesta;
    }
    
    public void archivoXML(File archivo)throws FormatoArchivoIncorrecto{
        if(!(archivo.getName().endsWith(".xml"))){
            throw new FormatoArchivoIncorrecto("El archivo de entrada no es .XML");
        }
    }
    public void tipoSangre(String tipoSangre) throws tipoDeSangreIncorrecto{
        switch(tipoSangre){
            case "A":
            case "A+":
            case "A-":
            case "B":
            case "B+":
            case "B-":
            case "AB":
            case "AB+":
            case "AB-":
            case "O":
            case "O+":
            case "O-":
                break;
            default :
                throw new tipoDeSangreIncorrecto("El tipo de sangre no es correcto");
        }
    }
}
