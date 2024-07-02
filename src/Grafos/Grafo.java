package Grafos;

public class Grafo {
    public Nodo prim;
    public Nodo ult;
    public int cantNodos;

    public Grafo() {
        prim = ult = null;
        this.cantNodos = 0;
    }

    public boolean vacia() {
        return prim == null;
    }

    public boolean seEncuentra(String name) {
        if (ult == null && prim == null) {
            return false;
        } else {
            Nodo p = prim;
            while (p != null) {
                if (p.name == name) {
                    return true;
                }
                p = p.prox;
            }
        }
        return false;
    }

    public void insertarUlt(String name) {
        if (prim == null && ult == null) {
            ult = prim = new Nodo(name);
        } else if (ult != null) {
            ult.prox = new Nodo(name);
            ult = ult.prox;
        }
    }

    public Nodo buscar(String name) {
        if (ult == null && prim == null) {
            return null;
        } else {
            Nodo p = prim;
            while (p != null) {
                if (p.name == name) {
                    return p;
                }
                p = p.prox;
            }
        }
        return null;
    }

    public void insertarNodo(String name) {
        if (!seEncuentra(name)) {
            insertarUlt(name);
        }
    }

    public void insertarArco(String name1, String name2, int valor) {
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);
        if (pOrigen == null) {
            insertarNodo(name1);
            insertarArco(name1, name2, valor);
        }
        if (pDest == null) {
            insertarNodo(name2);
            insertarArco(name1, name2, valor);
        }
    }

}
