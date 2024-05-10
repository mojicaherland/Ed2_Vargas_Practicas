package Arbol;

public class ListaArbol {
    public int cantElem;
    public int max;
    public ABB arbol[];

    public ListaArbol() {
        this.max = this.cantElem = 0;
        arbol = new ABB[10];
    }

    public void generar(int n, int a, int b) {
        for (int i = 0; i <= n; i++) {
            int r = (int) (a + (b - a) * Math.random());
            arbol[r % 10].insertar(r);
        }
    }
}
