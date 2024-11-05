package com.example.controller.tda.models;


import com.example.controller.tda.models.enumerator.Combustible;

public class Generador {
    private int id;
    private float costo;
    private float consumo;
    private String energiagenerada;
    private Combustible combustible;
    




    public Combustible getCombustible() {
        return combustible;
    }
    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getCosto() {
        return costo;
    }
    public void setCosto(float costo) {
        this.costo = costo;
    }
    public float getConsumo() {
        return consumo;
    }
    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
    public String getEnergiagenerada() {
        return energiagenerada;
    }
    public void setEnergiagenerada(String energiagenerada) {
        this.energiagenerada = energiagenerada;
    }

    
}
