public class MainLista {
    public static void main(String[] args) {
        Lista lista = new Lista(10);
        Lista lista2 = new Lista(10);
        Lista listaPrueba = new Lista(10);

        lista.insertarIesimo(5,0);
        lista.insertarIesimo(20,1);
        lista.insertarIesimo(30,2);
        lista.insertarIesimo(40,3);
        System.out.println("Lista 1: " + lista.toString());

        lista2.insertarIesimo(5,0);
        lista2.insertarIesimo(20,1);
        lista2.insertarIesimo(30,2);
        lista2.insertarIesimo(27,3);
        System.out.println("Lista 2: " + lista2.toString());

        lista.eliminarTodo(lista2);
        System.out.println("Lista Alterada: " + lista.toString());

        listaPrueba.pasarDigitos(546781);
        System.out.println(listaPrueba.toString());

        lista.insertarIesimo(lista2,1);
        System.out.println(lista.toString());

    }
}
