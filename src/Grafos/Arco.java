package Grafos;

public class Arco {
    public Nodo pDest;
    public int valor;
    public Arco prox;

    public Arco(Nodo pDest, int valor) {
        this.pDest = pDest;
        this.valor = valor;
    }
}
