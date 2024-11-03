package com.example.controller.tda.models;

import com.example.controller.tda.models.enumerator.Combustible;

public class Familia {
    private Integer id;
    private String apellido;
    private String direccion;
    private String telefono;
    private String uso;
    private Combustible combustible;
    private float consumo_Litros;
    private float costo;
    private float energiagenerada_KW;

   
    public Familia() {
      
    }

    public String getUso() {
        return uso;
    }


    public void setUso(String uso) {
        this.uso = uso;
    }

    public float getConsumo() {
        return consumo_Litros;
    }


    public void setConsumo(float consumo) {
        this.consumo_Litros = consumo;
    }



    public float getCosto() {
        return costo;
    }


    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getEnergiagenerada_KW() {
        return energiagenerada_KW;
    }

    public void setEnergiagenerada_KW(float energiagenerada) {
        this.energiagenerada_KW = energiagenerada;
    }


    public Combustible getCombustible() {
        return combustible;
    }


    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }


 

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
  

    
}

