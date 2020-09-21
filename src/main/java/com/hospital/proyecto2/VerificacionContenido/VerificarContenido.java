
package com.hospital.proyecto2.VerificacionContenido;

import com.hospital.proyecto2.exepcionesDePrograma.FormatoArchivoIncorrecto;
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
}
