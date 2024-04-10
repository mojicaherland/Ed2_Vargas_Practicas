package ListaEncadenadaDobles;

public class ListaEncadenaDoble {
    public Nodo prim;
    public Nodo ult;
    public int cantElem;

    public ListaEncadenaDoble() {
        prim = ult = null;
        cantElem = 0;
    }

    public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                p = p.prox;
            }
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
        insertarNodo(ap,p,x);
    }
    public void insertarIesimo(int x,int i){
        int k = 0;
        Nodo p = prim,ap = null;
        while (p != null && k < i){
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(ap,p,x);
    }
}
