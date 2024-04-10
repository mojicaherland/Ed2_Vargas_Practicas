package ListaEncadenadaDobles;

public class Nodo {
    public Nodo ant;
    public int elem;
    public Nodo prox;

    public Nodo(Nodo ant, int elem, Nodo prox) {
        this.ant = ant;
        this.elem = elem;
        this.prox = prox;
    }

}
