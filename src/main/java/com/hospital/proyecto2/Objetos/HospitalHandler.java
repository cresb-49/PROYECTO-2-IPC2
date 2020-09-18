/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.proyecto2.Objetos;

import com.hospital.proyecto2.Converciones.*;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author benjamin
 */
public class HospitalHandler extends DefaultHandler{
    private ConvercionesVariables conv = new ConvercionesVariables();
    private ArrayList<Admin> admins = new ArrayList();
    private ArrayList<Doctor> doctores = new ArrayList();
    private ArrayList<Laboratorista> laboratoristas = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private Object objeto;
    
    private StringBuilder buffer = new StringBuilder();
    
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
         switch(qName){
            case "hospital":
                break;
            case "admin":
                break;
            case "CODIGO":
                asignarCodigo();
                break;
            case "DPI":
                asignarDPI();
                break;
            case "NOMBRE":
                asignarNombre();
                break;
            case "PASSWORD":
                asignarPassword();
                break;
            case "COLEGIADO":
                if(objeto instanceof Doctor){
                    Doctor doctor = (Doctor) objeto;
                    doctor.setColegiado(buffer.toString());
                }
                break;
            case "TELEFONO":
                asignarTelefono();
                break;
            case "ESPECIALIDAD":
                break;
            case "TITULO":
                if(objeto instanceof Doctor){
                    Doctor doctor = (Doctor) objeto;
                    doctor.agregarEspecialidad(buffer.toString());
                }
                break;
            case "CORREO":
                asignarCorreo();
                break;
            case "HORARIO":
                break;
            case "INICIO":
                convercionHora(qName);
                break;
            case "FIN":
                convercionHora(qName);
                break;
            case "TRABAJO":
                asignaInicioTrabajo();
                break;
            case "REGISTRO":
                if(objeto instanceof Laboratorista){
                    Laboratorista lab = (Laboratorista) objeto;
                    lab.setRegistro(buffer.toString());
                }
                break;
            case "EXAMEN":
                if(objeto instanceof Laboratorista){
                    Laboratorista lab = (Laboratorista) objeto;
                    lab.setExamen(buffer.toString());
                }
                break;
            case "DIA":
                if(objeto instanceof Laboratorista){
                    Laboratorista lab = (Laboratorista) objeto;
                    lab.agregarDia(buffer.toString());
                }
                break;
            case "SEXO":
                if(objeto instanceof Paciente){
                    Paciente paciente = (Paciente) objeto;
                    paciente.setSexo(buffer.toString());
                }
                break;
            case "BIRTH":
                if(objeto instanceof Paciente){
                    Paciente paciente = (Paciente) objeto;
                    paciente.setCumple(this.conv.stringToDate(buffer.toString()));
                }
                break;
            case "PESO":
                if(objeto instanceof Paciente){
                    Paciente paciente = (Paciente) objeto;
                    paciente.setPeso(this.conv.stringToDouble(buffer.toString()));
                }
                break;
            case "SANGRE":
                if(objeto instanceof Paciente){
                    Paciente paciente = (Paciente) objeto;
                    paciente.setSangre(buffer.toString());
                }
                break;
                
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "hospital":
                break;
            case "admin":
                objeto=new Admin();
                admins.add((Admin) objeto);
                break;
            case "doctor":
                objeto=new Doctor();
                doctores.add((Doctor) objeto);
                break;
            case "laboratorista":
                objeto = new Laboratorista();
                laboratoristas.add((Laboratorista)objeto);
                break;
            case "paciente":
                objeto = new Paciente();
                pacientes.add((Paciente) objeto);
                break;
            case "CODIGO":
                buffer.delete(0, buffer.length());
                break;
            case "DPI":
                buffer.delete(0, buffer.length());
                break;
            case "NOMBRE":
                buffer.delete(0, buffer.length());
                break;
            case "PASSWORD":
                buffer.delete(0, buffer.length());
                break;
            case "COLEGIADO":
                buffer.delete(0, buffer.length());
                break;
            case "TELEFONO":
                buffer.delete(0, buffer.length());
                break;
            case "ESPECIALIDAD":
                buffer.delete(0, buffer.length());
                break;
            case "TITULO":
                buffer.delete(0, buffer.length());
                break;
            case "CORREO":
                buffer.delete(0, buffer.length());
                break;
            case "HORARIO":
                buffer.delete(0, buffer.length());
                break;
            case "INICIO":
                buffer.delete(0, buffer.length());
                break;
            case "FIN":
                buffer.delete(0, buffer.length());
                break;
            case "TRABAJO":
                buffer.delete(0, buffer.length());
                break;
            case "REGISTRO":
                buffer.delete(0, buffer.length());
                break;
            case "EXAMEN":
                buffer.delete(0, buffer.length());
                break;
            case "DIA":
                buffer.delete(0, buffer.length());
            case "SEXO":
                buffer.delete(0, buffer.length());
                break;
            case "BIRTH":
                buffer.delete(0, buffer.length());
                break;
            case "PESO":
                buffer.delete(0, buffer.length());
                break;
            case "SANGRE":
                buffer.delete(0, buffer.length());
                break;
        }
    }
    private void asignarCodigo(){
        if(objeto instanceof Persona){
            Persona persona = (Persona) objeto;
            persona.setCodigo(buffer.toString());
        }
        
    }
    private void asignarDPI(){
        if(objeto instanceof Persona){
            Persona persona = (Persona) objeto;
            persona.setDPI(buffer.toString());
        }
    }
    private void asignarNombre(){
        if(objeto instanceof Persona){
            Persona persona = (Persona) objeto;
            persona.setNombre(buffer.toString());
        }
    }
    public ArrayList<Admin> getAdmins() {
        return admins;
    }    

    private void asignarPassword() {
        if(objeto instanceof Persona){
            Persona persona = (Persona) objeto;
            persona.setPassword(buffer.toString());
        }
    }
    private void asignarTelefono(){
        if(objeto instanceof Persona){
            Persona persona = (Persona) objeto;
            persona.setTelefono(buffer.toString());
        }
    }

    private void asignarCorreo() {
        if(objeto instanceof Persona){
            if(!(objeto instanceof Admin)){
                Persona persona = (Persona) objeto;
                persona.setCorreo(buffer.toString());
            }
        }
    }
    private void convercionHora(String tipo){
        
        if(tipo.equals("INICIO")){
            if(objeto instanceof Doctor){
                Doctor doctor = (Doctor) objeto;
                doctor.setInicio(this.conv.stringToTime(buffer.toString()));
            }
        }
        if(tipo.equals("FIN")){
            if(objeto instanceof Doctor){
                Doctor doctor = (Doctor) objeto;
                doctor.setFin(this.conv.stringToTime(buffer.toString()));
            }
        }
    }

    private void asignaInicioTrabajo() {
        if(objeto instanceof Doctor){
            Doctor doctor = (Doctor) objeto;
            doctor.setInicioTrabajo(this.conv.stringToDate(buffer.toString()));
        }
        if(objeto instanceof Laboratorista){
            Laboratorista lab = (Laboratorista) objeto;
            lab.setInicioTrabajo(this.conv.stringToDate(buffer.toString()));
        }
    }
    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public ArrayList<Laboratorista> getLaboratoristas() {
        return laboratoristas;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
}
