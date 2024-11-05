package com.example.controller.dao.implement;

// Usamos DynamicArrayList en lugar de LinkedList

public interface InterfazDao<T> {
    public void persist(T object) throws Exception;         // Inserta un objeto en la lista
    public void marge(T object, Integer index) throws Exception;  // Actualiza un objeto en el índice dado
    public T[] listAll();                                   // Lista todos los elementos en el arreglo
    public T get(Integer id) throws Exception;              // Obtiene un elemento según el índice
}
