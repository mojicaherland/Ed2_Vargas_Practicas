public class MainLista {
    public static void main(String[] args) {
        Lista lista = new Lista(10);

        lista.insertarIesimo(10,0);
        lista.insertarIesimo(20,1);
        lista.insertarIesimo(30,2);
        System.out.println(lista.toString());

        lista.eliminarIesimo(1);
        System.out.println(lista.toString());
    }
}
