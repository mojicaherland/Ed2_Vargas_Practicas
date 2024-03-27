public class MainLista {
    public static void main(String[] args) {
        Lista lista = new Lista(10);
        Lista lista2 = new Lista(10);
        Lista listaPrueba = new Lista(10);

        lista.insertarIesimo(10, 0);
        lista.insertarIesimo(20, 1);
        lista.insertarIesimo(30, 2);
        lista.insertarIesimo(40, 3);
        lista.insertarIesimo(5, 4);
        lista.insertarIesimo(1, 5);

        System.out.println("Lista 1: " + lista.toString());

        lista2.insertarIesimo(10, 0);
        lista2.insertarIesimo(6, 1);
        lista2.insertarIesimo(1, 2);
        lista2.insertarIesimo(27, 3);
        System.out.println("Lista 2: " + lista2.toString());

        listaPrueba.pasarDigitos(546781);
        System.out.println("Lista Prueba: " + listaPrueba.toString());

        lista.dividirLista(1,3);
        //System.out.println(lista.toString());
    }
}
