package com.example.controller.tda.list;

import com.example.controller.exception.ListEmptyException;

public class DynamicArrayList<E> {
    private E[] elements;       // Arreglo para almacenar los elementos
    private int size;           // Número de elementos actuales en la lista
    private static final int DEFAULT_CAPACITY = 10;  // Capacidad inicial

    // Constructor sin argumentos (capacidad inicial predeterminada)
    @SuppressWarnings("unchecked")
    public DynamicArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Constructor con capacidad inicial personalizada
    @SuppressWarnings("unchecked")
    public DynamicArrayList(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacidad debe ser mayor que 0");
        this.elements = (E[]) new Object[capacity];
        this.size = 0;
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Método para agregar un elemento al final de la lista
    public void add(E element) {
        ensureCapacity(); // Verifica si hay suficiente capacidad antes de agregar
        elements[size++] = element;
    }

    // Método para agregar un elemento en una posición específica
    public void add(E element, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Índice fuera de rango");
        ensureCapacity(); // Verifica si hay suficiente capacidad antes de agregar
        // Mueve los elementos a la derecha para dejar espacio
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    // Método para obtener un elemento en una posición específica
    public E get(int index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) throw new ListEmptyException("Error, la lista está vacía");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fuera de rango");
        return elements[index];
    }

    // Método para actualizar un elemento en una posición específica
    public void update(E element, int index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) throw new ListEmptyException("Error, la lista está vacía");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fuera de rango");
        elements[index] = element;
    }

    // Método para eliminar un elemento en una posición específica
    public void remove(int index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) throw new ListEmptyException("Error, la lista está vacía");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fuera de rango");

        // Desplaza los elementos hacia la izquierda para eliminar el elemento
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null; // Elimina la referencia al último elemento
        size--;
    }

    // Método para limpiar la lista
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Método para convertir la lista en un arreglo
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    // Método para obtener el tamaño actual de la lista
    public int getSize() {
        return size;
    }

    // Método privado para asegurar que haya suficiente capacidad en el arreglo
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            @SuppressWarnings("unchecked")
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DynamicArrayList Data: ");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append(" -> ");
        }
        return sb.toString();
    }
}
