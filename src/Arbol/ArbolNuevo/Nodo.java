package Arbol.ArbolNuevo;

public class Nodo {
    public int elem;
    public int fre;
    public Nodo izq;
    public Nodo der;

    public Nodo(int elem) {
        this.elem = elem;
        this.fre = 1;
        this.izq = this.der = null;
    }
    public Nodo(int elem, int fre){
        this.elem = elem;
        this.fre = fre;
        this.izq = this.der = null;
    }

}
