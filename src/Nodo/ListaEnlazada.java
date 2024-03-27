package Nodo;

public class ListaEnlazada {
    public Nodo prim;
    public int cantElem;
    public Nodo ult;
    public ListaEnlazada(){
        prim = ult = null;
        cantElem = 0;
    }
    public String toString(){
        String s1 = "[";
        Nodo p = prim;
        while (p != null){
            s1 = s1 + p.elem;
            if (p.prox != null){
                s1 = s1 + " ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }
    //Metodos de lista
    public boolean vacia(){
        return ((prim == null) && (ult == null));
    }
    public void insertarPrim(int x){
        if (vacia()){
            prim = ult = new Nodo(x,null);
        }else{
            prim = new Nodo(x,prim);
        }
        cantElem++;
    }
    public void insertarUlt(int x){
        if (vacia()){
            prim = ult = new Nodo(x,null);
        }else{
            ult = ult.prox = new Nodo(x,null);
        }
    }
    public void insertarIesimo(int x,int i){
        int k = 0;
        Nodo p = prim,ap = null;
        while (p != null && k < i){
            ap = p;
            p = p.prox;
            k++;
        }
        insertarNodo(x,ap,p);
    }
    public void insertarNodo(int x,Nodo ap,Nodo p){
        if (ap == null){
            insertarPrim(x);
        }else{
            if (p == null){
                insertarUlt(x);
            }else{
                ap.prox = new Nodo(x,p);
                cantElem++;
            }
        }
    }
    public boolean iguales(){
        Nodo p = prim;
        return true;
    }

}
