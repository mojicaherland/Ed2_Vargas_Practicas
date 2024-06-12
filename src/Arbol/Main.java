package Arbol;

public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        arbol.insertar(5);
        arbol.insertar(2);
        arbol.insertar(7);
        arbol.inOrden();
        arbol.eliminarSup(7);
        arbol.eliminarInf(2);
        arbol.eliminarHojas();
        arbol.eliminarPares();
        arbol.eliminarMenor();
        arbol.eliminarMayor();
        arbol.inOrden();

    }
}
