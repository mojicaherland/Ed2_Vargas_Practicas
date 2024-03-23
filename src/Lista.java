public class Lista {
    private int max;
    private int cantElem;
    private int[] arreglo;

    //Constructor
    public Lista(int max) {
        this.max = max;
        this.cantElem = 0;
        this.arreglo = new int[max];
    }

    //imprimir la lista
    public String toString() {
        String s1 = "[";
        int i = 0;
        while (i < this.cantElem) {
            if (i == this.cantElem - 1) {
                s1 = s1 + this.arreglo[i];
            } else {
                s1 = s1 + this.arreglo[i] + ", ";
            }
            i++;
        }
        return s1 + "]";
    }

    //Otros metodos
    public void insertarIesimo(int x, int i) {
        int k = this.cantElem - 1;
        while (k >= i) {
            this.arreglo[k + 1] = this.arreglo[k];
            k--;
        }
        this.arreglo[i] = x;
        this.cantElem++;
    }

    public void insertarPrimero(int x) {
        insertarIesimo(x, 0);
    }

    public void insertarUltimo(int x) {
        insertarIesimo(x, this.cantElem);
    }

    public void eliminarIesimo(int i) {
        int k = i + 1;
        while (k < this.cantElem) {
            this.arreglo[k - 1] = this.arreglo[k];
            k++;
        }
        this.cantElem--;
    }

    public void eliminarPrimero() {
        eliminarIesimo(0);
    }

    public void eliminarUltimo() {
        eliminarIesimo(this.cantElem - 1);
    }

    public void eliminarUnicos(){
        System.out.println("hola");
    }
}
