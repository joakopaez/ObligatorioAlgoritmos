package tads;


import java.util.ArrayList;
import java.util.List;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yanete
 */
public class ColaSE<T> {

    // Referencia al primer nodo de la cola.
    private NodoSE<T> frente;

    // Referencia al último nodo de la cola.
    private NodoSE<T> fondo;

    // Constructor: crea una cola vacía.
    // Al principio no hay primer ni último nodo.
    public ColaSE() {
        frente = null;
        fondo = null;
    }

    // Agrega un nuevo elemento al final de la cola.
    public void encolar(T dato) {

        // Se crea un nodo con el dato que queremos agregar.
        NodoSE<T> nodo_nuevo = new NodoSE<T>(dato);

        // Si la cola está vacía, el nuevo nodo será el primero.
        if (estaVacia()) {
            frente = nodo_nuevo;
        } else {
            // Si ya hay elementos, el último nodo actual
            // debe apuntar al nuevo nodo.
            fondo.setSiguiente(nodo_nuevo);
        }

        // En ambos casos, el nuevo nodo pasa a ser el último.
        fondo = nodo_nuevo;
    }

    // Elimina y devuelve el elemento que está al frente.
    public T desencolar() {

        // Se inicializa el resultado en null por si la cola está vacía.
        T dato = null;

        // Solo se puede quitar un elemento si hay alguno.
        if (!estaVacia()) {

            // Si frente y fondo son el mismo nodo,
            // significa que hay un único elemento.
            // Al quitarlo, la cola quedará vacía.
            if (frente == fondo) {
                fondo = null;
            }

            // Guardamos el dato antes de quitar el nodo.
            dato = frente.getDato();

            // El segundo nodo pasa a ser el primero.
            // Si no existía un segundo nodo, frente pasa a null.
            frente = frente.getSiguiente();
        }

        // Devolvemos el dato eliminado.
        return dato;
    }

    // Indica si la cola está vacía.
    public boolean estaVacia() {
        return frente == null;
    }

    // Devuelve el dato del primer elemento sin eliminarlo.
    public T getFrente() {
        return !estaVacia() ? frente.getDato() : null;
    }

    // Devuelve el dato del último elemento sin eliminarlo.
    public T getFondo() {
        return !estaVacia() ? fondo.getDato() : null;
    }

    // Devuelve los elementos de la cola en una lista
    // para poder mostrarlos sin quitar nada de la cola.
    public List<T> obtenerElementos() {

        // Lista que contendrá los datos en orden.
        List<T> elementos = new ArrayList<>();

        // Empezamos a recorrer desde el frente de la cola.
        NodoSE<T> actual = frente;

        // Mientras exista un nodo, seguimos recorriendo.
        while (actual != null) {

            // Guardamos el dato del nodo actual en la lista.
            elementos.add(actual.getDato());

            // Avanzamos al siguiente nodo.
            actual = actual.getSiguiente();
        }

        // Devolvemos la lista con los elementos encontrados.
        return elementos;
    }
}

