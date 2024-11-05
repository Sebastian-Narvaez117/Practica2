package com.example.controller.dao.implement;

import com.example.controller.tda.list.DynamicArrayList;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;

public class DynamicArrayDao<T> implements InterfazDao<T> {
    private DynamicArrayList<T> dataList;
    private Class<T> clazz;
    private Gson gson;
    public static final String URL = "media/";

    // Constructor que recibe la clase para serializar y deserializar
    public DynamicArrayDao(Class<T> clazz) {
        this.dataList = new DynamicArrayList<>();
        this.clazz = clazz;
        this.gson = new Gson();
        loadData(); // Cargar los datos desde el JSON al inicializar
    }

    // Método para agregar un objeto al final del arreglo y guardarlo en JSON
    @Override
    public void persist(T object) throws Exception {
        if (object == null) throw new Exception("El objeto no puede ser nulo.");
        dataList.add(object);
        saveData(); // Guardar los datos en el archivo JSON
    }

    // Método para actualizar un objeto en el índice especificado y guardarlo en JSON
    @Override
    public void marge(T object, Integer index) throws Exception {
        if (object == null) throw new Exception("El objeto no puede ser nulo.");
        if (index == null || index < 0 || index >= dataList.getSize()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        dataList.update(object, index);
        saveData(); // Guardar los datos en el archivo JSON
    }

    // Método para listar todos los objetos en el arreglo
    @Override
    public T[] listAll() {
        return dataList.toArray(); // Retorna el contenido de DynamicArrayList como arreglo
    }

    // Método para obtener un objeto según el índice
    @Override
    public T get(Integer id) throws Exception {
        if (id == null || id < 0 || id >= dataList.getSize()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        return dataList.get(id);
    }

    // Método para guardar el contenido de dataList en un archivo JSON
    private void saveData() throws Exception {
        String json = gson.toJson(dataList.toArray());
        try (FileWriter writer = new FileWriter(URL + clazz.getSimpleName() + ".json")) {
            writer.write(json);
            writer.flush();
        }
    }

    // Método para cargar los datos desde el archivo JSON al DynamicArrayList
    private void loadData() {
        try {
            String data = readFile();
            if (data == null || data.trim().isEmpty()) {
                System.out.println("Archivo vacío o no encontrado.");
                return;
            }
            // Convertir el JSON a un array y agregarlo a dataList
            T[] array = (T[]) gson.fromJson(data, java.lang.reflect.Array.newInstance(clazz, 0).getClass());
            for (T item : array) {
                dataList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para leer el archivo JSON
    private String readFile() throws Exception {
        Scanner in = new Scanner(new FileReader(URL + clazz.getSimpleName() + ".json"));
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        return sb.toString();
    }
}
