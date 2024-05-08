package Arbol;

public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(40);
        arbol.insertar(50);
        arbol.insertar(60);
        arbol.insertar(70);
        System.out.println("El mayor elemento de un arbol es : " + arbol.mayor());
        System.out.println("La suma de los elementos pares del arbol es : " + arbol.sumaPares());
        System.out.println("La cantidad de nodos en el arbol es : " + arbol.cantidad());
        System.out.println("La cantidad de nodos temrinales en el arbol es : " + arbol.cantidadTerm());
//        System.out.println("La cantidad de nodos pares en el arbol es : " + arbol.cantidadPares());
    }
}
