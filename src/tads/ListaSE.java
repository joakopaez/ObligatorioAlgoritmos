package tads;

/* Clase ListaSE: Implementacion del TDA Lista usando
 * nodos simplemente enlazados, con apuntador al primer nodo 
 */

public class ListaSE<T extends Comparable<T>> implements ILista<T> {
    private NodoSE<T> cabeza;
    private int longitud;

    public ListaSE() {
        cabeza = null;
        longitud = 0;
    }

    @Override
    public void Adicionar(T x) {
        if (Vacia()) {
            adicionarInicio(x);
        } else {
            NodoSE<T> nuevo_nodo = new NodoSE<>(x);
            NodoSE<T> aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo_nodo);
            longitud++;
        }
    }

    @Override
    public void Insertar(T x, int pos) throws PosFueraDeRangoException, ListaVaciaException {
        if (pos < 0 || pos > longitud) throw new PosFueraDeRangoException();
        
        if (pos == 0) {
            adicionarInicio(x);
        } else {
            NodoSE<T> nuevo = new NodoSE<>(x);
            NodoSE<T> aux = cabeza;
            for (int i = 0; i < pos - 1; i++) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            longitud++;
        }
    }

    @Override
    public T Obtener(int pos) throws PosFueraDeRangoException, ListaVaciaException {
        if (Vacia()) throw new ListaVaciaException();
        if (pos < 0 || pos >= longitud) throw new PosFueraDeRangoException();

        NodoSE<T> aux = cabeza;
        for (int i = 0; i < pos; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getDato();
    }

    @Override
    public void Eliminar(int pos) throws PosFueraDeRangoException, ListaVaciaException {
        if (Vacia()) throw new ListaVaciaException();
        if (pos < 0 || pos >= longitud) throw new PosFueraDeRangoException();

        if (pos == 0) {
            eliminarInicio();
        } else {
            NodoSE<T> aux = cabeza;
            for (int i = 0; i < pos - 1; i++) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
            longitud--;
        }
    }

    @Override
    public int Longitud() {
        return longitud;
    }

    @Override
    public boolean Vacia() {
        return longitud == 0;
    }

    public void adicionarInicio(T elem) {
        NodoSE<T> aux = new NodoSE<>(elem);
        aux.setSiguiente(cabeza);
        cabeza = aux;
        longitud++;
    }

    public boolean existeElemento(T elem) throws ListaVaciaException {
        if (Vacia()) throw new ListaVaciaException();

        NodoSE<T> aux = cabeza;
        while (aux != null) {
            if (aux.getDato().equals(elem)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public void eliminarInicio() throws ListaVaciaException {
        if (Vacia()) throw new ListaVaciaException();
        cabeza = cabeza.getSiguiente();
        longitud--;
    }

    public void eliminarFinal() throws ListaVaciaException {
        if (Vacia()) throw new ListaVaciaException();

        if (longitud == 1) {
            cabeza = null;
        } else {
            NodoSE<T> aux = cabeza;
            while (aux.getSiguiente().getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
        }
        longitud--;
    }

    public void invertirIterativo() {
        NodoSE<T> anterior = null;
        NodoSE<T> actual = cabeza;
        NodoSE<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.getSiguiente();
            actual.setSiguiente(anterior);
            anterior = actual;
            actual = siguiente;
        }
        cabeza = anterior;
    }

    public void invertirRecursivo() {
    }


    public boolean estaOrdenada() {
        if (longitud <= 1) return true;

        NodoSE<T> aux = cabeza;
        while (aux.getSiguiente() != null) {
            if (aux.getDato().compareTo(aux.getSiguiente().getDato()) > 0) {
                return false;
            }
            aux = aux.getSiguiente();
        }
        return true;
    }

    public void insertarOrdenado(T elem) {
        if (Vacia() || cabeza.getDato().compareTo(elem) >= 0) {
            adicionarInicio(elem);
            return;
        }

        NodoSE<T> nuevo = new NodoSE<>(elem);
        NodoSE<T> aux = cabeza;

        while (aux.getSiguiente() != null && aux.getSiguiente().getDato().compareTo(elem) < 0) {
            aux = aux.getSiguiente();
        }

        nuevo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nuevo);
        longitud++;
    }
    
}
