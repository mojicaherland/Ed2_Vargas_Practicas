package ListaEncadenadaDobles;

public class ListaEncadenaDoble {
    public Nodo prim;
    public Nodo ult;
    public int cantElem;

    public ListaEncadenaDoble() {
        prim = ult = null;
        cantElem = 0;
    }

    /*public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                p = p.prox;
            }
        }
        return s1 + "]";
    }*/
    public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                s1 = s1 + ", ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    //Otros Metodos
    public boolean vacia() {
        if (prim == null && ult == null) {
            return true;
        }
        return false;
    }

    public void inseratrPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        }
    }

    public void insertarUlt(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            ult = ult.prox = new Nodo(ult, x, null);
        }
    }

    public void insertarNodo(Nodo ap, Nodo p, int x) {
        if (ap == null) {
            inseratrPrim(x);
        } else {
            if (p == null) {
                insertarUlt(x);
            } else {
                ap.prox = p.ant = new Nodo(ap, x, p);
                cantElem++;
            }
        }
    }

    public void insertarLugar(int x) {
        Nodo p = prim, ap = null;
        while (p != null && x > p.elem) {
            ap = p;
            p = p.prox;
        }
        insertarNodo(ap, p, x);
    }

    public void insertarIesimo(int x, int i) {
        int k = 0;
        Nodo p = prim, ap = null;
        while (p != null && k < i) {
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(ap, p, x);
    }

    //elimina el primer nodo
    public void eliminarPrim() {
        if (vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            prim.prox.ant = null;
            prim = prim.prox;
        }
        cantElem--;
    }

    public void eliminarUlt() {
        if (vacia()) {
            return;
        }
        if (prim == ult) {
            prim = ult = null;
        } else {
            ult.ant.prox = null;
            ult = ult.ant;
        }
        cantElem--;
    }

    public void eliminarIesimo(int i) {
        int k = 0;
        Nodo p = prim, ap = null;
        while (k < i && p != null) {
            ap = p;
            p = p.prox;
            k++;
        }
        eliminarNodo(ap, p);
    }

    private Nodo eliminarNodo(Nodo ap, Nodo p) {
        if (p == null) {
            return null;
        }
        if (ap == null) {
            eliminarPrim();
            return prim;
        }
        if (p.prox == null) {
            eliminarUlt();
            return null;
        }
        ap.prox = p.prox;
        p.prox.ant = ap;
        cantElem--;
        return ap.prox;
    }

    public void eliminarTodo(int x) {
        Nodo p = prim, ap = null;
        while (p != null) {
            if (p.elem == x) {
                ap.prox = eliminarNodo(ap, p);
                p = p.prox;
            } else {
                ap = p;
                p = p.prox;
            }
        }
    }

    //. L1.eliminarPrim( n ) : Método que
    // eliminar los primeros n-elementos de la lista L1
    public void eliminarPrim(int n) {
        int i = 0;
        while (n > 0) {
            eliminarPrim();
            n--;
        }
    }
    public void eliminarUlt(int n){
        int i = 0;
        while (n > 0){
            eliminarUlt();
            n--;
        }
    }


}
