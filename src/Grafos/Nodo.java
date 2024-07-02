package Grafos;

public class Nodo {
    public String name;
    public Nodo prox;
    public Arco prim;
    public Arco ult;
    public int cantArcos;

    public Nodo(String name) {
        this.name = name;
        this.prox = null;
        this.prim = null;
        this.ult = null;
        this.cantArcos = 0;
    }
}
