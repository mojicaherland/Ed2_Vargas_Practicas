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
        System.out.println(p.elem);
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
    public int alturaMenor(){
        return alturaMenor(raiz);
    }
    private int alturaMenor(Nodo p){
        if (p == null){
            return -1;
        }else{
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
            } else{
                mostrarTerm(p.izq);
                mostrarTerm(p.der);
            }
        }
    }
}
