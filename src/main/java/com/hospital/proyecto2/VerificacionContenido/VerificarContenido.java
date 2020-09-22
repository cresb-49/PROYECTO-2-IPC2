
package com.hospital.proyecto2.VerificacionContenido;

import com.hospital.proyecto2.Objetos.*;
import com.hospital.proyecto2.exepcionesDePrograma.*;
import java.io.File;

public class VerificarContenido {
    private static String Expnombre ="^[A-ZÀ-ÿ\\u00d1a-zÀ-ÿ\\u00f1]+([\\s][A-ZÀ-ÿ\\u00d1a-zÀ-ÿ\\u00f1]+){1,5}$";
    private static String Expcorreo = "^[a-zA-Z0-9_-]+@[a-zA-z]+\\.[a-z]+$";
    private static String Exptelefono="^[0-9]{8}$";
    private static String ExpnDpi= "^[0-9]{13}$";
    private static String ExpnumeroEntero = "^[0-9]+$";
    private static String ExpIntOrDouble ="^(([0-9]+\\.[0-9]+)|([0-9]+))$";
    private static String ExpNombre = "^[A-ZÀ-ÿ\\u00d1a-z\\u00f1]+$";
    private static String ExpCodigoMedico = "^[M][E][D][-][0-9]+$";
    private static String ExpCodigoLabora = "^[L][A][B][-][0-9]+$";
    private static String ExpCodigoAdmin = "^[A][D][M][I][N][0-9]+$";
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
    
    public void verificarDoctor(Doctor doctor) throws AtributosDeDoctorIncompletos{
        if(doctor.getCodigo()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no posee codigo de identificacion");
        }
        if(doctor.getCodigo().equals("")){
            throw new AtributosDeDoctorIncompletos("El doctor no posee codigo de identificaion");
        }
        if(doctor.getColegiado()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no posee numero de colegiado");
        }
        if(doctor.getColegiado().equals("")){
            throw new AtributosDeDoctorIncompletos("El doctor no posee numero de colegiado");
        }
        if(doctor.getCorreo()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no posee correo electronico");
        }
        if(doctor.getCorreo().equals("")){
            throw new AtributosDeDoctorIncompletos("El doctor no posee correo electronico");
        }
        if(doctor.getDPI()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no posee numero de DPI");
        }
        if(doctor.getDPI().equals("")){
            throw new AtributosDeDoctorIncompletos("El doctor no posee numero de DPI");
        }
        if(doctor.getEspecialidad()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no posee ninguna especialidad");
        }
        if(doctor.getEspecialidad().isEmpty()){
            throw new AtributosDeDoctorIncompletos("El doctor no posee ninguna especialidad");
        }
        if(doctor.getFin()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no tiene asignada una hora de fin de turno");
        }
        if(doctor.getInicio()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no tiene asignada una hora de inicio de turno");
        }
        if(doctor.getInicioTrabajo().equals("")){
            throw new AtributosDeDoctorIncompletos("El doctor no posee fecha de inicio de trabajo");
        }
        if(doctor.getNombre()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no posee nombre");
        }
        if(doctor.getNombre().equals("")){
            throw new AtributosDeDoctorIncompletos("El doctor no posee nombre");
        }
        if(doctor.getPassword()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no tiene asignado una contraseña de ingreso al sistema");
        }
        if(doctor.getPassword().equals("")){
            throw new AtributosDeDoctorIncompletos("El doctor no tiene asignado una contraseña de ingreso al sistema");
        }
        if(doctor.getTelefono()==null){
            throw new AtributosDeDoctorIncompletos("El doctor no tiene numero de telefono");
        }
        if(doctor.getTelefono().equals("")){
            throw new AtributosDeDoctorIncompletos("El doctor no tiene numero de telefono");
        }
    }
    
    private static boolean validarNombre(String nombre){
        return nombre.matches(Expnombre);
    }
    private static boolean validarCorreo(String correo){
        return correo.matches(Expcorreo);
    }
    private static boolean validarTelefono(String telefono){
        return telefono.matches(Exptelefono);
    }
    private static boolean validadDPI(String DPI){
        return DPI.matches(ExpnDpi);
    }
}
