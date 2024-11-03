package com.example.controller.tda.list;

import com.example.controller.exception.ListEmptyException;

public class LinkedList <E> {
    private Node <E> header;
    private Node <E> last;
    private Integer size  ;

    public LinkedList(){
        this.header = null;
        this.last = null;
        this.size = 0;
    }


      

    public Boolean isEmpty(){
        return (this.header == null || this.size == 0);
            
    }

    public void addHeader(E dato) {
        Node<E> help;
        if (isEmpty()) {
            help = new Node<>(dato);
            this.header = help;
            this.last = help; // Inicializa last cuando se agrega el primer nodo
        } else {
            help = new Node<>(dato);
            help.setNext(this.header);
            this.header = help;
        }
        this.size++;
    }




    public void addLast(E info){
        Node<E> help;
        if(isEmpty()){
            addHeader(info);
        }else{
            help = new Node<>(info, null);
            last.setNext(help);
            last = help;
            this.size++;
        }
    }

    public void add(E info){
        addLast(info);
    }

    public Node<E> getNode(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if(isEmpty()){
            throw new ListEmptyException("Error, List empty");
        } else if(index.intValue()< 0 || index.intValue() >= this.size){
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if(index.intValue()== 0){
            return header;
        } else if(index.intValue()==(this.size -1)){
            return last;
        } else{
            Node<E> search = header;
            int cont = 0;
            while(cont < index.intValue()){
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    public E getFirst()throws ListEmptyException {
        if(isEmpty()){
            throw new ListEmptyException("Error, lista vacia");
        } 
         return header.getInfo();
    }


    public E getLast() throws ListEmptyException {
        if(isEmpty()){
            throw new ListEmptyException("Error, lista vacia");
        } 
         return last.getInfo();
    }


    public E get(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if(isEmpty()){
            throw new ListEmptyException("Error, List empity");
        } else if(index.intValue() < 0 || index.intValue() >= this.size.intValue()){
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if(index.intValue() == 0){
            return header.getInfo();
        } else if(index.intValue() == (this.size - 1)){
            return last.getInfo();
        } else{
            Node<E> search = header ;
            int cont = 0;
            while(cont < index.intValue()){ 
                cont++;
                search = search.getNext();
            }
            return search.getInfo();
        }
    }

    public void add(E info , Integer index ) throws ListEmptyException , IndexOutOfBoundsException{
        if(isEmpty()|| index.intValue()==  0){
            addHeader(info);
        }else if(index.intValue() == this.size.intValue()){
            addLast(info);
        }else{
            Node<E> search_preview = getNode(index-1);
            Node<E> search = getNode(index);
            Node<E> help = new Node<>(info , search);
            search_preview.setNext(help);
            this.size++;
        }
    }

    public void update(E info, Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista está vacía, no se puede actualizar.");
        } 
        if (index < 0 || index >= this.size.intValue()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites.");
        }
    
        // Caso especial: actualiza la cabeza de la lista
        if (index.intValue() == 0) {
            this.header.setInfo(info); 
        } 
        // Caso especial: actualiza el último nodo
        else if (index.intValue() == this.size.intValue() - 1) {
            this.last.setInfo(info); 
        } 
        // Caso general: actualiza un nodo intermedio
        else {
            Node<E> targetNode = getNode(index); 
            targetNode.setInfo(info); 
        }
    }
    

    
    public void reset(){
        this.header = null;
        this.last = null; 
        this.size = 0;
    }

    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("List Data \n");
        try{

            Node<E> help = header;
            while(help != null){
                sb.append(help.getInfo()).append("->");
                help = help.getNext();
            }
        } catch(Exception e){
            sb.append(e.getMessage());
        }

        return sb.toString();
    }


    public Integer getSize() {
        return this.size;
    }



    public E[] toArray(){
        E[] matriz = null;
        if(!isEmpty()){
            Class clazz = header.getInfo().getClass();
            matriz = (E[])java.lang.reflect.Array.newInstance(clazz , size);
            Node<E> aux = header;
            for(int i = 0; i < this.size ; i++){
                matriz[i] = aux.getInfo();
                aux = aux.getNext();
            }
        }
        return matriz;
    }


    public LinkedList<E> toList(E[] matriz){
        reset();
        for(int i = 0; i < matriz.length; i++){
            this.add(matriz[i]);
        }
        return this;
    }   

    
} 


