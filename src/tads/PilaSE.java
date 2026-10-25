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
public class PilaSE<T> {

    // Referencia al nodo que está en la cima de la pila.
    private NodoSE<T> tope;

    // Constructor: crea una pila vacía.
    public PilaSE() {
        tope = null;
    }

    // Agrega un elemento en la cima de la pila.
    public void apilar(T dato) {

        // Creamos un nodo nuevo con el dato recibido.
        NodoSE<T> nodo_nuevo = new NodoSE<T>(dato);

        // El nuevo nodo apunta al antiguo tope.
        // Si la pila estaba vacía, el antiguo tope era null.
        nodo_nuevo.setSiguiente(tope);

        // El nuevo nodo pasa a ser el tope de la pila.
        tope = nodo_nuevo;
    }

    // Elimina y devuelve el elemento que está en la cima.
    public T desapilar() {

        // Si la pila está vacía, el resultado seguirá siendo null.
        T dato = null;

        // Solo quitamos un elemento si existe.
        if (!estaVacia()) {

            // Guardamos el dato del nodo que vamos a eliminar.
            dato = tope.getDato();

            // El siguiente nodo pasa a ser el nuevo tope.
            tope = tope.getSiguiente();
        }

        // Devolvemos el dato que estaba en la cima.
        return dato;
    }

    // Comprueba si la pila está vacía.
    public boolean estaVacia() {
        return tope == null;
    }

    // Devuelve el dato de la cima sin eliminarlo.
    public T getTope() {
        return !estaVacia() ? tope.getDato() : null;
    }

    // Devuelve los elementos de la pila en una lista
    // sin modificar la pila original.
    public List<T> obtenerElementos() {

        // Lista donde se guardarán los datos.
        List<T> elementos = new ArrayList<>();

        // Se empieza por el tope de la pila.
        NodoSE<T> actual = tope;

        // Recorremos los nodos hasta llegar a null.
        while (actual != null) {

            // Añadimos el dato del nodo actual.
            elementos.add(actual.getDato());

            // Avanzamos al siguiente nodo.
            actual = actual.getSiguiente();
        }

        // Devolvemos la lista obtenida.
        return elementos;
    }
}

