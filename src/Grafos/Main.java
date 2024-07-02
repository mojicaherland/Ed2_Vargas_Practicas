package Grafos;

public class Main {
    public static void main(String[] args) {
        Grafo g1 = new Grafo();

        g1.insertarNodo("A");
        g1.insertarNodo("B");
        g1.insertarArco("A", "B", 2);
        g1.insertarArco("D", "E", 1);
        g1.mostrar();
        System.out.println(g1.cantidadArcos());
    }
}
