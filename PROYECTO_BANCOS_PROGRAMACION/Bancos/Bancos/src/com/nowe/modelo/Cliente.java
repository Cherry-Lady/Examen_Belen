/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.modelo;

import java.time.LocalDate;

/**
 *
 * @author Programacion
 */
public class Cliente {
    //campos
    private String nif;
    private String nombre;
    private String direccion;
    private LocalDate fApertura;
    
    //Métodos

    @Override
    public String toString() {
        return "Cliente{" + "nif=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + ", fApertura=" + fApertura + '}' + '\n';
    }
    //constructor

    public Cliente() {
    }

    public Cliente(String nif, String nombre, String direccion, LocalDate fApertura) {
        this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fApertura = fApertura;
    }
    
    
    //Getters y Setters

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getfApertura() {
        return fApertura;
    }

    public void setfApertura(LocalDate fApertura) {
        this.fApertura = fApertura;
    }
    
    
    
    
    
    
    
}
