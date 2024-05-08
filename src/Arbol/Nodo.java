package Arbol;

public class Nodo {
    public Nodo izq;
    public Nodo der;
    public int elem;

    public Nodo(int elem) {
        this.elem = elem;
        izq = der = null;
    }
}
