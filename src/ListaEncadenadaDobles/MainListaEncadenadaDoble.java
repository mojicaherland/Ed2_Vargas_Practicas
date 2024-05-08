package ListaEncadenadaDobles;

public class MainListaEncadenadaDoble {
    public static void main(String[] args) {
        ListaEncadenaDoble lista = new ListaEncadenaDoble();

        lista.insertarIesimo(10,0);
        lista.insertarIesimo(20,1);
        lista.insertarIesimo(30,2);
        lista.insertarIesimo(40,3);
        lista.insertarIesimo(50,4);
        System.out.println(lista.toString());

        lista.eliminarUlt(2);
        System.out.println(lista.toString());
    }
}
