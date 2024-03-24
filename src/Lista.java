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
    //Metodos Esenciales

    //1. metodo para insertar un elemento en la posicion i
    public void insertarIesimo(int x, int i) {
        int k = this.cantElem - 1; //penultima pos
        while (k >= i) {
            this.arreglo[k + 1] = this.arreglo[k];
            k--;
        }
        this.arreglo[i] = x; //pone el dato en esa posicion
        this.cantElem++; // aumenta el tamaño de la lista(vector)
    }

    //2. metodo para insertar en la primera posicion
    public void insertarPrimero(int x) {
        this.insertarIesimo(x, 0); //t(n) = 1
    }

    //3. metodo para insertar en la ultima posicion
    public void insertarUltimo(int x) {
        this.insertarIesimo(x, this.cantElem);
    }

    //4. metodo para eliminar un dato en cualquier posicion
    public void eliminarIesimo(int i) {
        int k = i + 1;
        while (k < this.cantElem) {
            this.arreglo[k - 1] = this.arreglo[k];
            k++;
        }
        this.cantElem--;
    }

    //5.metodo para elmiminar primer elemento de la lista
    public void eliminarPrimero() {
        this.eliminarIesimo(0);//t(n) = 1
    }

    //6. metodo para eliminar ultimo elemento de la lista
    public void eliminarUltimo() {
        this.eliminarIesimo(this.cantElem - 1);
    }

    //7. metodo que elimina todos los elementos x de la lista L1(datos repetidos)
    public void eliminarTodo(int x) {
        int i = 0;
        while (i < this.cantElem) {
            if (this.arreglo[i] == x) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //8. metodo que elimina los elementos pares de la lista L1
    public void eliminarPares() {
        int i = 0;
        while (i < this.cantElem) {
            if (this.arreglo[i] % 2 == 0) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //9. metodo que elimina los elementos que aparecen solo una vez en la lista L1
    public void eliminarUnicos() {
        int i = 0;
        while (i < this.cantElem) {
            boolean esUnico = true;
            for (int j = 0; j < this.cantElem; j++) {
                if (i != j && this.arreglo[i] == this.arreglo[j]) {
                    esUnico = false;
                    break;
                }
            }
            if (esUnico) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //10. metodo que elimina todos los elementos de la lista L1, que aparecen en la lista L2
    public void eliminarTodo(Lista l2) {
        int i = 0;
        while (i < this.cantElem) {
            boolean encontrado = false;
            for (int j = 0; j < l2.cantElem; j++) {
                if (this.arreglo[i] == l2.arreglo[j]) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    //Lab2 --> Trabajos en pareja (Jueves 14/03/2023)

    /*    CHECK --> YA HECHOS
     * 1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.
     * 2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.
     * 3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.
     * 4. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
     * 5. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
     * 6. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
     * */

    //7. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la Lista L1.
    // Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7, 8, 1]
    public void pasarDigitos(int n) {
        while (n > 0) {
            int modulo = n % 10;
            n = n / 10;
            this.insertarPrimero(modulo);
        }
    }

    //8. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha.
    // Sugerencia, utilizar los métodos de insertar y eleminar por los extremos de la Lista.
    public void rotarIzqDer(int n) {
        while (n > 0) {
            int aux = this.arreglo[0];
            this.insertarUltimo(aux);
            this.eliminarPrimero();
            n--;
        }
    }

    //9. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda
    public void rotarDerIzq(int n) {
        while (n > 0) {
            int aux = this.arreglo[cantElem - 1];
            this.insertarPrimero(aux);
            this.eliminarUltimo();
            n--;
        }
    }

    //10. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.
    public void eliminarPrim(int n) {
        while (n > 0) {
            this.eliminarPrimero();
            n--;
        }
    }

    //11. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.
    public void eliminarUlt(int n) {
        while (n > 0) {
            this.eliminarUltimo();
            n--;
        }
    }

    //12. L1.insertarIesimo(L2, i) : Método que inserta la Lista L2 en la Lista L1, en la posición i.
    public void insertarIesimo(Lista l2, int i) {
        int j = 0;
        while (j < l2.cantElem) {
            this.insertarIesimo(l2.arreglo[j], i);
            i++;
            j++;
        }
    }

    /* TAREA1. Listas en arreglo --> Lunes(18/03/2024) --> YA HECHOS */

    /*1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.
     *2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.
     *3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.
     *4. L1.eliminarIesimo(i) : Método que elimina el elemento de la posición i.
     *5. L1.eliminarPrim() : Método que elimina el elemento de la primer posición.
     *6. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.
     *8. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la lista L1.
     *8. L1.eliminarPares() : Método que elimina los elementos pares de la lista L1. Verificar en listas dónde todos los elementos sean pares.
     *9. L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo una vez en la lista L1.
     *10. L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista L1, que aparecen en la lista L2.
     *11. L1.pasarDigitos( n ) : Método que pasa los dígitos del entero n, a la Lista L1. Ejemplo: Si n = 546781, L1 = []. El resultado es L1 = [5, 4, 6, 7, 8, 1]
     *12. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha. Sugerencia, utilizar los métodos de insertar y eleminar por los extremos de la Lista.
     *13. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
     *14. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.
     *15. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1
     *16. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista L2 en la lista L1, desde la posición i.
     * */

    //17. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al principio de la lista L1.
    public void insertarPrim(Lista l2) {
        int i = 0;
        while (i < l2.cantElem) {
            this.insertarPrimero(l2.arreglo[i]);
            i++;
        }
    }

    //18. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al final de la lista L1.
    public void insertarUlt(Lista l2) {
        int i = 0;
        while (i < l2.cantElem) {
            this.insertarUltimo(l2.arreglo[i]);
            i++;
        }
    }

    //19. L1.eliminarIesimo(i, n) : Método que elimina los n-elementos de la lista L1, desde la posición i.
    public void eliminarIesimo(int i, int n) {
        while (n > 0) {
            this.eliminarIesimo(i);
            n--;
        }
    }

    //20. L1.eliminarExtremos( n ) : Método que eliminar la n-elementos de los extremos de la lista L1.
    public void eliminarExtremos(int n) {
        while (n > 0) {
            this.eliminarPrimero();
            this.eliminarUltimo();
            n--;
        }
    }

    //21. L1.eliminarVeces(k) : Método que elimina los elementos que se repiten k-veces en la lista L1.
    public void eliminarVeces(int k) {
        int i = 0;
        while (i < this.cantElem) {
            int contador = 0;
            for (int j = 0; j < this.cantElem; j++) {
                if (this.arreglo[i] == this.arreglo[j]) {
                    contador++;
                }
            }
            if (contador == k) {
                this.eliminarTodo(this.arreglo[i]);
            } else {
                i++;
            }
        }
    }

    //22. L1.eliminarAlternos() : Método que elimina los elementos de las posiciones alternas. (permanece, se elimina, permanece, se elimina, etc.)
    public void eliminarAlternos() { //CORREGIR
        int i = 0;
        while (i < this.cantElem) {
            if (i % 2 == 1) {
                this.eliminarIesimo(i);
            } else {
                i++;
            }
        }
    }

    /* LAB 3. Mas sobre listas en arreglos --> Jueves(21/03/2024)* CHECK/
    /*1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.
    *2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.
    *3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.
    * */

    //4. L1.insertarLugasAsc(x) : Método que inserta el elemento x,
    // en su lugar correspondiente en la Lista L1, ordenada de menor a mayor.
    public void insertarLugarAsc(int x) {
        int i = 0;
        while (i < this.cantElem && this.arreglo[i] < x) {
            i++;
        }
        this.insertarIesimo(x, i);
    }

    //5. L1.insertarLugasDesc(x) : Método que inserta el elemento x,
    // en su lugar correspondiente en la Lista L1, ordenada de mayor a menor.
    public void insertarLugarDesc(int x) {
        int i = 0;
        while (i < this.cantElem && this.arreglo[i] > x) {
            i++;
        }
        this.insertarIesimo(x, i);
    }

    //6. L1.comunes(L2, L3) : Método que encuentra en L1,
    // los elementos comunes en las Listas L2, L3.
    public void comunes(Lista l2, Lista l3) {
        for (int i = 0; i < l2.cantElem; i++) {
            for (int j = 0; j < l3.cantElem; j++) {
                if (l2.arreglo[i] == l3.arreglo[j]) {
                    System.out.println(l2.arreglo[i]);
                }
            }
        }
    }

    //7. L1.intercalar(L2, L3) : Método que encuentra en L1,
    // los elementos intercalados de las Listas L2 y L3.
    public void intercalar(Lista l2, Lista l3) {
        int i = 0;
        int j = 0;
        while (i < l2.cantElem && j < l3.cantElem) {
            this.insertarUltimo(l2.arreglo[i]);
            this.insertarUltimo(l3.arreglo[j]);
            i++;
            j++;
        }
        while (i < l2.cantElem) {
            this.insertarUltimo(l2.arreglo[i]);
            i++;
        }
        while (j < l3.cantElem) {
            this.insertarUltimo(l3.arreglo[j]);
            j++;
        }
    }

    //8. L1.ordenado() : Método lógico que devuelve True,
    // si los elementos de la lista L1, están ordenados en forma ascendente o descendente.
    public void ordenado() {
        boolean asc = false;
        boolean desc = false;
        for (int i = 0; i < this.cantElem - 1; i++) {
            if (this.arreglo[i] < this.arreglo[i + 1]) {
                asc = true;
            }
            if (this.arreglo[i] > this.arreglo[i + 1]) {
                desc = true;
            }
        }
        if (asc) {
            System.out.println("Lista Ordenada Ascendemente");
        }
        if (desc) {
            System.out.println("Lista Ordenada Descendemente");
        }
    }

    //9. L1.iguales() : Método lógico que devuelve True,
    // si todos los elementos de la lista L1, son iguales.
    public boolean iguales() {
        boolean igual = false;
        for (int i = 0; i < this.cantElem - 1; i++) {
            if (this.arreglo[i] == this.arreglo[i + 1]) {
                igual = true;
            }
        }
        return igual;
    }

    //10. L1.diferentes() : Método lógico que devuelve True,
    // si todos los elementos de la lista L1, son diferentes.
    public boolean diferentes() {
        boolean dif = false;
        for (int i = 0; i < this.cantElem - 1; i++) {
            if (this.arreglo[i] != this.arreglo[i + 1]) {
                dif = true;
            }
        }
        return dif;
    }

    //11. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
    public int menor() {
        int menor = this.arreglo[0];
        for (int i = 0; i < this.cantElem; i++) {
            if (this.arreglo[i] < menor) {
                menor = this.arreglo[i];
            }
        }
        return menor;
    }

    //12. L1.parImpar() : Método lógico que devuelve True, en la Lista L1,
    // existe al menos un elemento par y al menor un elemento impar.
    public boolean parImpar() {
        boolean encontradoPar = false;
        boolean encontradoImpar = false;
        for (int i = 0; i < this.cantElem; i++) {
            if (this.arreglo[i] % 2 == 0) {
                encontradoPar = true;
            } else {
                encontradoImpar = true;
            }
            if (encontradoPar && encontradoImpar) {
                return true;
            }
        }
        return false;
    }
    //13. L1.mismaFrec() : Método lógico que devuelve True,
    // si todos los elementos tienen la misma frecuencia de aparición en la Lista L1.

}