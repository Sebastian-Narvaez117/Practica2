package com.example.controller.dao.services;

import com.example.controller.dao.FamiliaDao;
import com.example.controller.tda.list.DynamicArrayList; // Cambiado a DynamicArrayList
import com.example.controller.tda.models.Familia;
import com.example.controller.tda.models.enumerator.Combustible;

public class Familiaservices {

    private FamiliaDao obj;

    public Familiaservices() {
        obj = new FamiliaDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    // Cambiado el tipo de retorno a DynamicArrayList
    public DynamicArrayList<Familia> listAll() {
        return obj.getlistAll();
    }

    public Familia getFamilia() {
        return obj.getFamilia();
    }

    public void setFamilia(Familia familia) {
        obj.setFamilia(familia);
    }

    public Combustible getCombustibles(String tipo) {
        return obj.getCombustibles(tipo);
    }

    public Combustible[] getCombustibles() {
        return obj.getCombustibles();
    }

    public Familia get(Integer id) throws Exception {
        return obj.get(id);
    }
}
