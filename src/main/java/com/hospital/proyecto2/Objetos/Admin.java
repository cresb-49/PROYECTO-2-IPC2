
package com.hospital.proyecto2.Objetos;

public class Admin extends Trabajador{
    
    public Admin(){
        
    }
    @Override
    public String toString() {
        return "Admin{" + "codigo=" + this.getCodigo() + ", DPI=" + this.getDPI() + ", nombre=" + this.getNombre() + ", password=" + this.getPassword() + '}';
    }
    
}
