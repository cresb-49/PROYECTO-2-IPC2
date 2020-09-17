package com.hospital.proyecto2.Objetos;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=PSlrLVKg-Ws


public class hospital {
    private ArrayList<admin> admins= new ArrayList<>();
    public hospital(){

    }
    public ArrayList<admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<admin> admins) {
        this.admins = admins;
    }
    
}