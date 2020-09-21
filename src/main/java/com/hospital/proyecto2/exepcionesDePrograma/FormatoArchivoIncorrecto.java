package com.hospital.proyecto2.exepcionesDePrograma;

public class FormatoArchivoIncorrecto extends Exception{
    public FormatoArchivoIncorrecto(){
        
    }
    public FormatoArchivoIncorrecto(String msj){
        super(msj);
    }
}
