package com.example.controller.dao;



import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.controller.tda.models.Familia;
import com.example.controller.tda.models.enumerator.Combustible;

public class FamiliaDao extends AdapterDao<Familia> {
    private Familia familia;
    private LinkedList<Familia> listAll;


    public FamiliaDao() {
        super(Familia.class);
    }

    public Familia getFamilia() {
        if(familia == null){
            familia = new Familia();
        }
        return this.familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public LinkedList<Familia> getlistAll() {
        if(listAll == null){
            listAll = new LinkedList<>();
        }
        return listAll();
    }

    public  Boolean update() throws Exception{
        this.marge(getFamilia(), getFamilia().getId()-1);
        this.listAll = listAll();
        return true;
    }


    public Boolean save() throws Exception{
        Integer id = listAll().getSize() + 1;
        familia.setId(id); 
        this.persist(this.familia);
        this.listAll = listAll();
        return true;
    }


    public Combustible getCombustibles(String tipo){
        return Combustible.valueOf(tipo);
    }


    public Combustible[] getCombustibles(){
        return Combustible.values();
    }



}

