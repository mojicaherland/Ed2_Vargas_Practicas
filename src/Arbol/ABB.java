package Arbol;

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

    //1.  A1.generarElem(n, a, b) : Método que genera
    // n elementos
    // aleatorios enteros diferentes entre a y b inclusive.
    private void generarElem(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * (b - a + 1) + a);
            insertar(x);
        }
    }

}
