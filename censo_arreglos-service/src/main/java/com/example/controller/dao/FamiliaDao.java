package com.example.controller.dao;

import com.example.controller.dao.implement.DynamicArrayDao;
import com.example.controller.tda.list.DynamicArrayList;
import com.example.controller.tda.models.Familia;
import com.example.controller.tda.models.enumerator.Combustible;

public class FamiliaDao extends DynamicArrayDao<Familia> {
    private Familia familia;
    private DynamicArrayList<Familia> listAll;  // Cambiado a DynamicArrayList<Familia>

    public FamiliaDao() {
        super(Familia.class);
        listAll = new DynamicArrayList<>();  // Inicialización de listAll como DynamicArrayList
    }

    public Familia getFamilia() {
        if (familia == null) {
            familia = new Familia();
        }
        return this.familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public DynamicArrayList<Familia> getlistAll() {
        if (listAll == null ) {
            listAll = new DynamicArrayList<>();
        }
        return listAll;
    }


    public Boolean update() throws Exception {
        this.marge(getFamilia(), getFamilia().getId() - 1);  // Actualiza el elemento en el índice dado
        this.listAll = getlistAll();  // Obtiene el DynamicArrayList actualizado
        return true;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;  // Ahora debería funcionar
        familia.setId(id);
        this.persist(this.familia);  // Guarda el objeto en el arreglo
        this.listAll = getlistAll();  // Actualiza listAll
        return true;
    }

    public Combustible getCombustibles(String tipo) {
        return Combustible.valueOf(tipo);
    }

    public Combustible[] getCombustibles() {
        return Combustible.values();
    }
}
