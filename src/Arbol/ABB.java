package Arbol;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ABB {
    public Nodo raiz;

    public ABB() {
        raiz = null;
    }

    //Metodos de arbol
    public void insertar(int x) {
        raiz = insertar(x, raiz);
    }

    private Nodo insertar(int x, Nodo p) {
        if (p == null) {
            return new Nodo(x);
        }
        if (x < p.elem) {
            p.izq = insertar(x, p.izq);
        } else {
            p.der = insertar(x, p.der);
        }
        return p;
    }

    public void preOrden() {
        preOrden(raiz);
    }

    private void preOrden(Nodo p) {
        if (p == null) {
            System.out.println(p.elem);
            preOrden(p.izq);
            preOrden(p.der);
        }
    }

    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(Nodo p) {
        if (p == null) {
            return;
        }
        inOrden(p.izq);
        System.out.print(p.elem + " ");
        inOrden(p.der);
    }

    public void postOrden() {
        postOrden(raiz);
    }

    private void postOrden(Nodo p) {
        if (p == null) {
            return;
        }
        postOrden(p.izq);
        postOrden(p.der);
        System.out.println(p.elem);
    }

    public boolean seEncuentra(int x) {
        return seEncuentra(x, raiz);
    }

    private boolean seEncuentra(int x, Nodo p) {
        if (p == null) {
            return false;
        }
        if (x == p.elem) {
            return true;
        }
        if (x < p.elem) {
            return seEncuentra(x, p.izq);
        } else {
            return seEncuentra(x, p.der);
        }
    }

    public int cantidad() {
        return cantidad(raiz);
    }

    private int cantidad(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantidad(p.izq) + cantidad(p.der);
    }

    public int suma() {
        return suma(raiz);
    }

    private int suma(Nodo p) {
        if (p == null) {
            return 0;
        } else {
            return suma(p.izq) + suma(p.der) + p.elem;
        }
    }

    public int menor() {
        return menor(raiz);
    }

    private int menor(Nodo p) {
        if (p.izq == null) {
            return p.elem;
        } else {
            return menor(p.izq);
        }
    }

    public int mayor() {
        return mayor(raiz);
    }

    private int mayor(Nodo p) {
        if (p.der == null) {
            return p.elem;
        } else {
            return mayor(p.der);
        }
    }

    public int cantidadTerm() {
        return cantidadTerm(raiz);
    }

    private int cantidadTerm(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (p.izq == null && p.der == null) {
            return 1;
        }
        return cantidadTerm(p.izq) + cantidadTerm(p.der);
    }

    public int sumaPares() {
        return sumaPares(raiz);
    }

    private int sumaPares(Nodo p) {
        if (p == null) {
            return 0;
        }
        int suma = p.elem % 2 == 0 ? p.elem : 0;
        return suma + sumaPares(p.izq) + sumaPares(p.der);
    }
    //Tarea 1


    //Laboratorio 9/05/2024
    public void elementoNivel() {
        elementoNivel(raiz, 1);
    }

    private void elementoNivel(Nodo p, int nivel) {
        if (p == null) {
            return;
        }
        elementoNivel(p.izq, nivel + 1);
        System.out.println(p.elem + "\t" + nivel);
        elementoNivel(p.der, nivel + 1);
    }

    public void mostrarNivel(int nivel) {
        LinkedList<Nodo> l1 = new LinkedList<>();
        if (raiz == null) {
            return;
        }
        l1.add(raiz);
        while (!l1.isEmpty()) {
            Nodo p = l1.getFirst();
            System.out.println(p.elem);
            if (p.izq != null) {
                l1.add(p.izq);
            }
            if (p.der != null) {
                l1.add(p.der);
            }
            l1.removeFirst();
        }
    }

    public void sumaNivel() {
        int max = this.cantidad();
        ArrayList<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            l1.add(0);
        }
        sumaNivel(raiz, 0, l1);
        int i = 0;
        while (l1.get(i) != 0) {
            System.out.println(i + 1 + "\t" + l1.get(i));
            i++;
        }
    }

    private void sumaNivel(Nodo p, int nivel, ArrayList<Integer> l1) {
        if (p == null) {
            return;
        }
        l1.set(nivel, l1.get(nivel) + p.elem);
        sumaNivel(p.izq, nivel + 1, l1);
        sumaNivel(p.der, nivel + 1, l1);
    }

    //ejercicios
    //A1.niveles(): Método que muestra los
    // elementos del árbol A1, por niveles.
    public void niveles() {
        LinkedList<Nodo> l1 = new LinkedList<>();
        if (raiz == null) {
            return;
        }
        l1.add(raiz);
        while (!l1.isEmpty()) {
            Nodo p = l1.getFirst();
            System.out.println(p.elem);
            if (p.izq != null) {
                l1.add(p.izq);
            }
            if (p.der != null) {
                l1.add(p.der);
            }
            l1.removeFirst();
        }
    }

    //2 A1.desc(): Método que muestra los
    // elementos del árbol A1 de mayor a menor.
    public void desc() {
        desc(raiz);
    }

    private void desc(Nodo p) {
        if (p != null) {
            desc(p.der);
            System.out.println(p.elem);
            desc(p.izq);
        }
    }
    //A1.seEncuentra(x) : Métodos lógico que devuelve True,
    // si el elemento x, se encuentra en el árbol A1.

    public void preoOrden(List<Integer> L1) {
        preoOrden(raiz, L1);
    }

    private void preoOrden(Nodo p, List<Integer> L1) {
        if (p != null) {
            L1.add(p.elem);
            preoOrden(p.izq, L1);
            preoOrden(p.der, L1);
        }
    }

    public void inOrden(List<Integer> L1) {
        inOrden(raiz, L1);
    }

    private void inOrden(Nodo p, List<Integer> L1) {
        if (p != null) {
            inOrden(p.izq, L1);
            L1.add(p.elem);
            inOrden(p.der, L1);
        }
    }

    public void postOrden(List<Integer> L1) {
        postOrden(raiz, L1);
    }

    private void postOrden(Nodo p, List<Integer> L1) {
        if (p != null) {
            postOrden(p.izq, L1);
            postOrden(p.der, L1);
            L1.add(p.elem);
        }
    }

    public void niveles(List<Integer> L1) {
        niveles(raiz, L1);
    }

    private void niveles(Nodo p, List<Integer> L1) {
        if (p == null) {
            return;
        }

        LinkedList<Nodo> queue = new LinkedList<>();
        queue.add(p);

        while (!queue.isEmpty()) {
            Nodo current = queue.poll();
            L1.add(current.elem);

            if (current.izq != null) {
                queue.add(current.izq);
            }

            if (current.der != null) {
                queue.add(current.der);
            }
        }
    }

    public void sumarNivel(List<Integer> L1) {
        if (raiz == null) {
            return;
        }

        LinkedList<Nodo> queue = new LinkedList<>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                Nodo current = queue.poll();
                sum += current.elem;

                if (current.izq != null) {
                    queue.add(current.izq);
                }

                if (current.der != null) {
                    queue.add(current.der);
                }
            }

            L1.add(sum);
        }
    }

    // Tarea 3 - Arboles con libreria de listas
    public int alturaMayor() {
        return alturaMayor(raiz);
    }

    private int alturaMayor(Nodo p) {
        if (p == null) {
            return -1;
        } else {
            int izqAltura = alturaMayor(p.izq);
            int derAltura = alturaMayor(p.der);
            return Math.max(izqAltura, derAltura) + 1;
        }
    }

    public int alturaMenor() {
        return alturaMenor(raiz);
    }

    private int alturaMenor(Nodo p) {
        if (p == null) {
            return -1;
        } else {
            int izqAltura = alturaMenor(p.izq);
            int derAltura = alturaMenor(p.der);
            return Math.min(izqAltura, derAltura) + 1;
        }
    }

    public void mostrarTerm() {
        mostrarTerm(raiz);
    }

    private void mostrarTerm(Nodo p) {
        if (p != null) {
            if (p.izq == null && p.der == null) {
                System.out.println(p.elem);
            } else {
                mostrarTerm(p.izq);
                mostrarTerm(p.der);
            }
        }
    }

    public boolean lineal() {
        return lineal(raiz);
    }

    private boolean lineal(Nodo p) {
        if (p == null) {
            return true;
        }
        if (p.izq != null && p.der != null) {
            return false;
        }
        return lineal(p.izq) && lineal(p.der);
    }

    public int inmediatoSup(int x) {
        Nodo nodoX = buscarNodo(x, raiz);
        if (nodoX == null) {
            return x;
        }
        if (nodoX.der != null) {
            return menor(nodoX.der);
        }
        Nodo ancestro = raiz;
        int inmediatoSup = x;
        while (ancestro != nodoX) {
            if (nodoX.elem < ancestro.elem) {
                inmediatoSup = ancestro.elem;
                ancestro = ancestro.izq;
            } else {
                ancestro = ancestro.der;
            }
        }
        return inmediatoSup;
    }

    private Nodo buscarNodo(int x, Nodo p) {
        if (p == null || p.elem == x) {
            return p;
        }
        if (x < p.elem) {
            return buscarNodo(x, p.izq);
        } else {
            return buscarNodo(x, p.der);
        }
    }

    public int inmediatoInf(int x) {
        Nodo nodoX = buscarNodo(x, raiz);
        if (nodoX == null) {
            return x;
        }
        if (nodoX.izq != null) {
            return mayorInmediatoInf(nodoX.izq);
        }
        Nodo ancestro = raiz;
        int inmediatoInf = x;
        while (ancestro != nodoX) {
            if (nodoX.elem > ancestro.elem) {
                inmediatoInf = ancestro.elem;
                ancestro = ancestro.der;
            } else {
                ancestro = ancestro.izq;
            }
        }
        return inmediatoInf;
    }

    private int mayorInmediatoInf(Nodo p) {
        if (p.der == null) {
            return p.elem;
        } else {
            return mayorInmediatoInf(p.der);
        }
    }

    //pregunta 26
    //1. Método que devuelve el número de nodos hoja en el árbol: Un nodo hoja es un nodo que no tiene hijos.
    // Este método recorrerá el árbol y contará el número de nodos hoja.
    public int contarNodosHoja() {
        return contarNodosHoja(raiz);
    }

    private int contarNodosHoja(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (p.izq == null && p.der == null) {
            return 1;
        }
        return contarNodosHoja(p.izq) + contarNodosHoja(p.der);
    }

    //2.Método que devuelve la altura del árbol: La altura de un árbol es la longitud
    // del camino más largo desde la raíz hasta cualquier hoja.
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo p) {
        if (p == null) {
            return -1;
        }
        return 1 + Math.max(altura(p.izq), altura(p.der));
    }

    //3.Método que verifica si un árbol está balanceado: Un árbol está balanceado si para cada nodo,
    // la altura de sus dos subárboles difiere en no más de uno.
    public boolean estaBalanceado() {
        return estaBalanceado(raiz);
    }

    private boolean estaBalanceado(Nodo p) {
        if (p == null) {
            return true;
        }
        int alturaIzq = altura(p.izq);
        int alturaDer = altura(p.der);
        return Math.abs(alturaIzq - alturaDer) <= 1 && estaBalanceado(p.izq) && estaBalanceado(p.der);
    }

    //4.Método que devuelve el número de nodos en un nivel dado:
    // Este método recorrerá el árbol y contará el número de nodos en un nivel específico
    public int nodosEnNivel(int nivel) {
        return nodosEnNivel(raiz, nivel);
    }

    private int nodosEnNivel(Nodo p, int nivel) {
        if (p == null) {
            return 0;
        }
        if (nivel == 0) {
            return 1;
        }
        return nodosEnNivel(p.izq, nivel - 1) + nodosEnNivel(p.der, nivel - 1);
    }

    //5.Método que devuelve el espejo del árbol:
    // Este método creará un nuevo árbol que es el espejo del árbol original.
    public ABB espejo() {
        ABB espejo = new ABB();
        espejo.raiz = espejo(raiz);
        return espejo;
    }

    private Nodo espejo(Nodo p) {
        if (p == null) {
            return null;
        }
        Nodo nuevoNodo = new Nodo(p.elem);
        nuevoNodo.izq = espejo(p.der);
        nuevoNodo.der = espejo(p.izq);
        return nuevoNodo;
    }

    public void eliminar(int x) {
        this.raiz = eliminar(x, raiz);
    }

    public Nodo eliminar(int x, Nodo p) {
        if (p == null) {
            return null;
        }
        if (x == p.elem) {
            return eliminarNodo(p);
        }
        if (x < p.elem) {
            p.izq = eliminar(x, p.izq);
        } else {
            p.der = eliminar(x, p.der);
        }
        return p;
    }

    public Nodo eliminarNodo(Nodo p) {
        if (p.izq == null && p.der == null) {
            return null;
        }
        if (p.izq != null && p.der == null) {
            return p.izq;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        Nodo q = p.izq;
        while (q.der != null) {
            q = p.der;
        }
        int y = q.elem;
        eliminar(y);
        p.elem = y;
        return p;
    }
    //Lab7 04/06/2024 arboles binarios de busqueda eliminar

    /*
     * A1.eliminarSup(x) : Método que elimina el elemento x,
     *  del árbol A1. Si el elemento a eliminar es un nodo raíz,
     * buscar el elemento inmediato Superior, para eliminar.
     * */
    public void eliminarSup(int x) {
        Nodo nodoX = buscarNodo2(x, raiz);
        if (nodoX == null) {
            return;
        }
        if (nodoX == raiz) {
            if (raiz.der != null) {
                int inmediatoSup = menor2(raiz.der);
                eliminar(inmediatoSup);
                raiz.elem = inmediatoSup;
            } else {
                raiz = raiz.izq;
            }
        } else {
            eliminar(x);
        }
    }

    private int menor2(Nodo p) {
        if (p.izq == null) {
            return p.elem;
        } else {
            return menor2(p.izq);
        }
    }

    private Nodo buscarNodo2(int x, Nodo p) {
        if (p == null || p.elem == x) {
            return p;
        }
        if (x < p.elem) {
            return buscarNodo2(x, p.izq);
        } else {
            return buscarNodo2(x, p.der);
        }
    }
    //2
    public void eliminarInf(int x) {
        Nodo nodoX = buscarNodo2(x, raiz);
        if (nodoX == null) {
            return;
        }
        if (nodoX == raiz) {
            if (raiz.izq != null) {
                int inmediatoInf = mayor(raiz.izq);
                eliminar(inmediatoInf);
                raiz.elem = inmediatoInf;
            } else {
                raiz = raiz.der;
            }
        } else {
            eliminar(x);
        }
    }

    private int mayor2(Nodo p) {
        if (p.der == null) {
            return p.elem;
        } else {
            return mayor2(p.der);
        }
    }
    //3
    public void eliminarHojas() {
        raiz = eliminarHojas(raiz);
    }

    private Nodo eliminarHojas(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq == null && p.der == null) {
            return null;
        }
        p.izq = eliminarHojas(p.izq);
        p.der = eliminarHojas(p.der);
        return p;
    }
    //
    public void eliminarPares() {
        raiz = eliminarPares2(raiz);
    }

    private Nodo eliminarPares2(Nodo p) {
        if (p == null) {
            return null;
        }
        p.izq = eliminarPares2(p.izq);
        p.der = eliminarPares2(p.der);
        if (p.elem % 2 == 0) {
            p = eliminarNodo(p);
        }

        return p;
    }
    //5
    public void eliminar(List<Integer> L1) {
        for (int x : L1) {
            eliminar(x);
        }
    }
    public void eliminarMenor() {
        raiz = eliminarMenor(raiz);
    }

    private Nodo eliminarMenor(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq == null) {
            return p.der;
        }
        p.izq = eliminarMenor(p.izq);
        return p;
    }
    //7
    public void eliminarMayor() {
        raiz = eliminarMayor(raiz);
    }

    private Nodo eliminarMayor(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.der == null) {
            return p.izq;
        }
        p.der = eliminarMayor(p.der);
        return p;
    }
}
