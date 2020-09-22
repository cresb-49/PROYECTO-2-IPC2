
package com.hospital.proyecto2.VerificacionContenido;

import com.hospital.proyecto2.Objetos.*;
import com.hospital.proyecto2.exepcionesDePrograma.*;
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
    public void verificarDoctor(Doctor doctor) throws AtributosIncompletos{
        if(!(this.validarCodigoDoctor(doctor.getCodigo()))){
            throw new AtributosIncompletos("El doctor no posee codigo de identificaion valido");
        }
        if(!(this.validarColegiado(doctor.getColegiado()))){
            throw new AtributosIncompletos("El doctor no posee numero de colegiado valido");
        }
        if(!(this.validarCorreo(doctor.getCorreo()))){
            throw new AtributosIncompletos("El doctor no posee un correo electronico valido");
        }
        if(!(this.validarDPI(doctor.getDPI()))){
            throw new AtributosIncompletos("El doctor no posee numero de DPI valido");
        }
        if(doctor.getEspecialidad()==null){
            throw new AtributosIncompletos("El doctor no posee ninguna especialidad");
        }
        if(doctor.getEspecialidad().isEmpty()){
            throw new AtributosIncompletos("El doctor no posee ninguna especialidad");
        }
        if(!doctor.getEspecialidad().isEmpty()){
            for(String especialidad:doctor.getEspecialidad()){
                if(!(this.validarTexto(especialidad))){
                    throw new AtributosIncompletos("La especialidad del doctor no tiene nombre valido");
                }
            }
        }
        if(doctor.getFin()==null){
            throw new AtributosIncompletos("El doctor no tiene asignada una hora de fin de turno");
        }
        if(doctor.getInicio()==null){
            throw new AtributosIncompletos("El doctor no tiene asignada una hora de inicio de turno");
        }
        if(doctor.getInicioTrabajo()==null){
            throw new AtributosIncompletos("El doctor no posee fecha de inicio de trabajo");
        }
        if(!(this.validarNombre(doctor.getNombre()))){
            throw new AtributosIncompletos("El doctor no posee un nombre valido debe ser de la forma Juan Perez");
        }
        if(doctor.getPassword()==null){
            throw new AtributosIncompletos("El doctor no tiene asignado una contraseña de ingreso al sistema");
        }
        if(!(this.verificarPassword(doctor.getPassword()))){
            throw new AtributosIncompletos("El doctor no tiene un contraseña para ingresar al sistema");
        }
    }
    
    public void verificarPacienteExportado(Paciente paciente)throws AtributosIncompletos{
        if(!(this.validarCodigoPaciente(paciente.getCodigo()))){
            throw new AtributosIncompletos("el paciente no tiene un codigo valido solo deben ser numeros");
        }
        if(!(this.validarNombre(paciente.getNombre()))){
            throw new AtributosIncompletos("El paciente no tiene un nombre valido debe ser de la forma Juan Perez");
        }
        if(!(this.validarSexo(paciente.getSexo()))){
            throw new AtributosIncompletos("El paciente no tiene un sexo valido");
        }
        if(paciente.getCumple()==null){
            throw new AtributosIncompletos("El paciente no tiene una fecha de cumpleaños valida");
        }
        if(!(this.validarDPI(paciente.getDPI()))){
            throw new AtributosIncompletos("El paciente no tiene numero de DPI valido");
        }
        if(!(this.validarTelefono(paciente.getTelefono()))){
            throw new AtributosIncompletos("El paciente no tiene numero de telefono valido");
        }
        if(!(this.validarPeso(paciente.getPeso()))){
            throw new AtributosIncompletos("");
        }
        if(!(this.validarTipoSangre(paciente.getSangre()))){
            throw new AtributosIncompletos("El paciente no tiene un tipo de sangre valido");
        }
        if(!(this.validarCorreo(paciente.getCorreo()))){
            throw new AtributosIncompletos("El paciente no tine un correo valido");
        }
        if(!(this.verificarPassword(paciente.getPassword()))){
            throw new AtributosIncompletos("El paciente no tine una contrasela para ingresar al sistema");
        }
    }
    public void verificarPacienteCreado(Paciente paciente)throws AtributosIncompletos{
        if(!(this.validarNombre(paciente.getNombre()))){
            throw new AtributosIncompletos("El paciente no tiene un nombre valido debe ser de la forma Juan Perez");
        }
        if(!(this.validarSexo(paciente.getSexo()))){
            throw new AtributosIncompletos("El paciente no tiene un sexo valido");
        }
        if(paciente.getCumple()==null){
            throw new AtributosIncompletos("El paciente no tiene una fecha de cumpleaños valida");
        }
        if(!(this.validarDPI(paciente.getDPI()))){
            throw new AtributosIncompletos("El paciente no tiene numero de DPI valido");
        }
        if(!(this.validarTelefono(paciente.getTelefono()))){
            throw new AtributosIncompletos("El paciente no tiene numero de telefono valido");
        }
        if(!(this.validarPeso(paciente.getPeso()))){
            throw new AtributosIncompletos("");
        }
        if(!(this.validarTipoSangre(paciente.getSangre()))){
            throw new AtributosIncompletos("El paciente no tiene un tipo de sangre valido");
        }
        if(!(this.validarCorreo(paciente.getCorreo()))){
            throw new AtributosIncompletos("El paciente no tine un correo valido");
        }
        if(!(this.verificarPassword(paciente.getPassword()))){
            throw new AtributosIncompletos("El paciente no tine una contrasela para ingresar al sistema");
        }
    }
    public void verificarLaboratorista(Laboratorista laboratorista) throws AtributosIncompletos{
        if(!(this.validarCodigoLabora(laboratorista.getCodigo()))){
            throw new AtributosIncompletos("El laboratorista no posee un codigo de identificacion valido");
        }
        if(!(this.validarNombre(laboratorista.getNombre()))){
            throw new AtributosIncompletos("El laboratorista no posee un nombre valido debe ser de la forma Juan Perez");
        }
        if(!(this.validarRegistroSalud(laboratorista.getRegistro()))){
            throw new AtributosIncompletos("El laboratorista no posee un numero de registro valido debe ser SALUD-XXXX");
        }
        if(!(this.validarDPI(laboratorista.getDPI()))){
            throw new AtributosIncompletos("El laboratorista no posee un numero de DPI valido");
        }
        if(!(this.validarTelefono(laboratorista.getTelefono()))){
            throw new AtributosIncompletos("El laboratorista no posee un numero de telefono valido");
        }
        if(!(this.validarTexto(laboratorista.getExamen()))){
            throw new AtributosIncompletos("El nombre del examen asignado al laboratorista no el valido");
        }
        if(!(this.validarCorreo(laboratorista.getCorreo()))){
            throw new AtributosIncompletos("El correo del laboratorista no es valido");
        }
        if(laboratorista.getDias()==null){
            throw new AtributosIncompletos("El laboratorista no tiene dias de trabajo");
        }
        if(laboratorista.getDias().isEmpty()){
            throw new AtributosIncompletos("El laboratorista no tiene dias de trabajo");
        }
        if(!(laboratorista.getDias().isEmpty())){
            for(String dia:laboratorista.getDias()){
                if(!(this.validarDia(dia))){
                    throw new AtributosIncompletos("El laboratorista tiene error en la definicion de dia de trabajo");
                }
            }
        }
        if(laboratorista.getInicioTrabajo()==null){
            throw new AtributosIncompletos("El laboratorista no tine asignado un dia de inicio de labores");
        }
        if(!(this.verificarPassword(laboratorista.getPassword()))){
            throw new AtributosIncompletos("El laboratorista no tiene una password para ingresar al sistema");
        }
    }
    private boolean verificarPassword(String password){
        if(password==null){
            return false;
        }else if(password.equals("")){
            return false;
        }else{
            return true;
        }
    }
    private boolean validarNombre(String nombre){
        if(nombre==null){
            return false;
        }else{
            return nombre.matches("^[A-ZÀ-ÿ\\u00d1a-zÀ-ÿ\\u00f1]+([\\s][A-ZÀ-ÿ\\u00d1a-zÀ-ÿ\\u00f1]+){1,5}$");
        }
    }
    private boolean validarCorreo(String correo){
        if(correo==null){
            return false;
        }
        else{
            return correo.matches("^[a-zA-Z0-9_-]+@[a-zA-z]+\\.[a-z]+$");
        }
    }
    private boolean validarTelefono(String telefono){
        if(telefono==null){
            return false;
        }else
        {
            return telefono.matches("^[0-9]{8}$");
        }
    }
    private boolean validarDPI(String DPI){
        if(DPI==null){
            return false;
        }else{
            return DPI.matches("^[0-9]{13}$");
        }
    }
    private boolean validarCodigoDoctor(String codigo){
        if(codigo==null){
            return false;
        }else{
            return  codigo.matches("^[M][E][D][-][0-9]+$");
        }
        
    }
    private boolean validarCodigoPaciente(Long codigo){
        if(codigo==null){
            return false;
        }else{
            return  codigo.toString().matches("^[0-9]+$");
        }
    }
    private boolean validarCodigoLabora(String codigo){
        if(codigo==null){
            return false;
        }else{
            return  codigo.matches("^[L][A][B][-][0-9]+$");
        }
    }
    private boolean validarCodigoAdmin(String codigo){
        if(codigo==null){
            return false;
        }else{
            return  codigo.matches("^[A][D][M][I][N][0-9]+$");
        }
        
    }
    private boolean validarColegiado(String colegiado){
        if(colegiado==null){
            return false;
        }else{
            return  colegiado.matches("^[0-9]+$");
        }
    }
    private boolean validarTexto(String texto){
        if(texto==null){
            return false;
        }else{
            return texto.matches("^[A-ZÀ-ÿ\\u00d1a-z\\u00f1-]+$");
        }
    }
    private boolean validarSexo(String sexo){
        if(sexo==null){
            return false;
        }
        else{
            sexo=sexo.toLowerCase();
            if(sexo.equals("hombre")||sexo.equals("mujer")){
                return true;
            }
            else{
                return false;
            }
        }
    }
    private boolean validarPeso(Double peso){
        if(peso==null){
            return false;
        }else{
            return peso.toString().matches("^(([0-9]+\\.[0-9]+)|([0-9]+))$");
        }
    }
    public boolean validarTipoSangre(String tipoSangre){
        if(tipoSangre==null){
            return false;
        }
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
                return true;
            default :
                return false;
        }
    }

    private boolean validarRegistroSalud(String registro) {
        if(registro ==null){
            return false;
        }else{
            return registro.matches("^[S][A][L][U][D][-][0-9]+$");
        }
    }
    
    private boolean validarDia(String dia){
        if(dia==null){
            return false;
        }else{
            dia=dia.toLowerCase();
            if(dia.equals("lunes")||dia.equals("martes")||dia.equals("miercoles")||dia.equals("jueves")||dia.equals("viernes")||dia.equals("sabado")||dia.equals("domingo")){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
