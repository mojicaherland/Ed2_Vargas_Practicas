package Arbol.ArbolNuevo;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Arbol {
    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(Arbol a1) {
        raiz = copiar(a1.raiz);
    }

    public Nodo copiar(Nodo p) {
        if (p == null) {
            return null;
        }
        Nodo q = new Nodo(p.elem, p.fre);
        p.izq = copiar(p.izq);
        p.der = copiar(p.der);
        return q;
    }

    public void insertar(int x) {
        raiz = insertar(x, raiz);
    }

    public Nodo insertar(int x, Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.elem == x) {
            p.fre = p.fre + 1;
        } else {
            if (x < p.elem) {
                p.izq = insertar(x, p.izq);
            } else {
                p.der = insertar(x, p.der);
            }

        }
        return p;
    }
    public void generarElementos(int n, int a, int b) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int r = a + rand.nextInt(b - a + 1);
            insertar(r);
        }
    }
    public void mostrarElementosConFrecuenciaDescendente() {
        mostrarElementosConFrecuenciaDescendente(raiz);
    }

    private void mostrarElementosConFrecuenciaDescendente(Nodo p) {
        if (p != null) {
            mostrarElementosConFrecuenciaDescendente(p.der);
            System.out.println("Elemento: " + p.elem + ", Frecuencia: " + p.fre);
            mostrarElementosConFrecuenciaDescendente(p.izq);
        }
    }


    public void mostrarElementosConFrecuencia() {
        mostrarElementosConFrecuencia(raiz);
    }

    private void mostrarElementosConFrecuencia(Nodo p) {
        if (p != null) {
            mostrarElementosConFrecuencia(p.izq);
            System.out.println("Elemento: " + p.elem + ", Frecuencia: " + p.fre);
            mostrarElementosConFrecuencia(p.der);
        }
    }
    public Arbol crearArbolPorFrecuencia() {
        Arbol nuevoArbol = new Arbol();
        crearArbolPorFrecuencia(raiz, nuevoArbol);
        return nuevoArbol;
    }

    private void crearArbolPorFrecuencia(Nodo p, Arbol nuevoArbol) {
        if (p != null) {
            for (int i = 0; i < p.fre; i++) {
                nuevoArbol.insertar(p.elem);
            }
            crearArbolPorFrecuencia(p.izq, nuevoArbol);
            crearArbolPorFrecuencia(p.der, nuevoArbol);
        }
    }

    public void mostrarElementosPorFrecuenciaAscendente() {
        mostrarElementosPorFrecuenciaAscendente(raiz);
    }

    private void mostrarElementosPorFrecuenciaAscendente(Nodo p) {
        if (p != null) {
            mostrarElementosPorFrecuenciaAscendente(p.izq);
            System.out.println("Elemento: " + p.elem + ", Frecuencia: " + p.fre);
            mostrarElementosPorFrecuenciaAscendente(p.der);
        }
    }

    public void mostrarElementosPorFrecuenciaDescendente() {
        mostrarElementosPorFrecuenciaDescendente(raiz);
    }

    private void mostrarElementosPorFrecuenciaDescendente(Nodo p) {
        if (p != null) {
            mostrarElementosPorFrecuenciaDescendente(p.der);
            System.out.println("Elemento: " + p.elem + ", Frecuencia: " + p.fre);
            mostrarElementosPorFrecuenciaDescendente(p.izq);
        }
    }
}
