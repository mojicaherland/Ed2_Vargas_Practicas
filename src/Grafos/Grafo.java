package Grafos;

import java.util.Stack;

public class Grafo {
    public Nodo prim;
    public Nodo ult;
    public int cantNodos;

    public Grafo() {
        prim = ult = null;
        this.cantNodos = 0;
    }

    public boolean vacia() {
        return prim == null;
    }

    public boolean seEncuentra(String name) {
        if (ult == null && prim == null) {
            return false;
        } else {
            Nodo p = prim;
            while (p != null) {
                if (p.name == name) {
                    return true;
                }
                p = p.prox;
            }
        }
        return false;
    }

    public void insertarUlt(String name) {
        if (prim == null && ult == null) {
            ult = prim = new Nodo(name);
        } else if (ult != null) {
            ult.prox = new Nodo(name);
            ult = ult.prox;
        }
    }

    public Nodo buscar(String name) {
        if (ult == null && prim == null) {
            return null;
        } else {
            Nodo p = prim;
            while (p != null) {
                if (p.name == name) {
                    return p;
                }
                p = p.prox;
            }
        }
        return null;
    }

    public void insertarNodo(String name) {
        if (!seEncuentra(name)) {
            insertarUlt(name);
        }
    }

    public void insertarArco(String name1, String name2, int valor) {
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);
        if (pOrigen == null) {
            insertarNodo(name1);
            insertarArco(name1, name2, valor);
        }
        if (pDest == null) {
            insertarNodo(name2);
            insertarArco(name1, name2, valor);
        }
    }

    public void mostrar() {
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            System.out.println("Nodo: " + nodoActual.name);
            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                System.out.println("  Arco a: " + arcoActual.pDest.name + " con valor: " + arcoActual.valor);
                arcoActual = arcoActual.prox;
            }
            nodoActual = nodoActual.prox;
        }
    }

    public int cantidadArcos() {
        int count = 0;
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                count++;
                arcoActual = arcoActual.prox;
            }
            nodoActual = nodoActual.prox;
        }
        return count;
    }

    public int cantidadLlegadas(String name1) {
        int count = 0;
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                if (arcoActual.pDest.name.equals(name1)) {
                    count++;
                }
                arcoActual = arcoActual.prox;
            }
            nodoActual = nodoActual.prox;
        }
        return count;
    }

    public int cantidadSalidas(String name1) {
        Nodo nodo = buscar(name1);
        if (nodo == null) {
            return 0;
        }
        int count = 0;
        Arco arcoActual = nodo.prim;
        while (arcoActual != null) {
            count++;
            arcoActual = arcoActual.prox;
        }
        return count;
    }

    public void mostrarNodosBucle() {
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                if (arcoActual.pDest == nodoActual) {
                    System.out.println("Nodo: " + nodoActual.name);
                    break;
                }
                arcoActual = arcoActual.prox;
            }
            nodoActual = nodoActual.prox;
        }
    }

    public void mostrarNodosIslas() {
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            if (nodoActual.prim == null && cantidadLlegadas(nodoActual.name) == 0) {
                System.out.println("Nodo isla: " + nodoActual.name);
            }
            nodoActual = nodoActual.prox;
        }
    }

    public boolean mismosNodos(Grafo G2) {
        if (this.cantNodos != G2.cantNodos) {
            return false;
        }
        Nodo nodoActual = this.prim;
        while (nodoActual != null) {
            if (G2.buscar(nodoActual.name) == null) {
                return false;
            }
            nodoActual = nodoActual.prox;
        }
        return true;
    }

    public int mayorValor() {
        if (prim == null) {
            return -1; // or throw an exception, depending on your requirements
        }
        int maxValor = Integer.MIN_VALUE;
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                if (arcoActual.valor > maxValor) {
                    maxValor = arcoActual.valor;
                }
                arcoActual = arcoActual.prox;
            }
            nodoActual = nodoActual.prox;
        }
        return maxValor;
    }

    public int cantidadIdaVuelta() {
        int count = 0;
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                Nodo nodoDest = arcoActual.pDest;
                Arco arcoDest = nodoDest.prim;
                while (arcoDest != null) {
                    if (arcoDest.pDest == nodoActual) {
                        count++;
                        break;
                    }
                    arcoDest = arcoDest.prox;
                }
                arcoActual = arcoActual.prox;
            }
            nodoActual = nodoActual.prox;
        }
        return count;
    }

    public void mostrarParalelos() {
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                Arco otherArco = arcoActual.prox;
                while (otherArco != null) {
                    if (arcoActual.pDest == otherArco.pDest) {
                        System.out.println("Nodo: " + nodoActual.name + " tiene arcos paralelos al nodo: " + arcoActual.pDest.name);
                        break;
                    }
                    otherArco = otherArco.prox;
                }
                arcoActual = arcoActual.prox;
            }
            nodoActual = nodoActual.prox;
        }
    }

    public boolean nodosVecinos(String node1, String node2) {
        Nodo nodo1 = buscar(node1);
        Nodo nodo2 = buscar(node2);
        if (nodo1 == null || nodo2 == null) {
            return false;
        }
        Arco arcoActual = nodo1.prim;
        while (arcoActual != null) {
            if (arcoActual.pDest == nodo2) {
                return true;
            }
            arcoActual = arcoActual.prox;
        }
        return false;
    }

    public int cantidadVecinos(String node1) {
        Nodo nodo1 = buscar(node1);
        if (nodo1 == null) {
            return 0;
        }
        int count = 0;
        Arco arcoActual = nodo1.prim;
        while (arcoActual != null) {
            count++;
            arcoActual = arcoActual.prox;
        }
        return count;
    }

    public boolean regular() {
        if (prim == null) {
            return true; // An empty graph is considered regular
        }
        int numNeighbors = cantidadVecinos(prim.name);
        Nodo nodoActual = prim.prox;
        while (nodoActual != null) {
            if (cantidadVecinos(nodoActual.name) != numNeighbors) {
                return false;
            }
            nodoActual = nodoActual.prox;
        }
        return true;
    }

    public boolean subGrafo(Grafo G2) {
        Nodo nodoActual = this.prim;
        while (nodoActual != null) {
            Nodo nodoG2 = G2.buscar(nodoActual.name);
            if (nodoG2 == null) {
                return false;
            }
            Arco arcoActual = nodoActual.prim;
            while (arcoActual != null) {
                if (!G2.nodosVecinos(nodoActual.name, arcoActual.pDest.name)) {
                    return false;
                }
                arcoActual = arcoActual.prox;
            }
            nodoActual = nodoActual.prox;
        }
        return true;
    }

    public void eliminarNodo(String name) {
        // If the graph is empty, there is nothing to do
        if (prim == null) {
            return;
        }

        // If the node to be deleted is the first node
        if (prim.name.equals(name)) {
            prim = prim.prox;
        } else {
            // Find the node before the node to be deleted
            Nodo nodoActual = prim;
            while (nodoActual.prox != null && !nodoActual.prox.name.equals(name)) {
                nodoActual = nodoActual.prox;
            }

            // If the node to be deleted was found
            if (nodoActual.prox != null) {
                nodoActual.prox = nodoActual.prox.prox;
            }
        }

        // Remove all arcs that point to the deleted node
        Nodo nodoActual = prim;
        while (nodoActual != null) {
            if (nodoActual.prim != null && nodoActual.prim.pDest.name.equals(name)) {
                nodoActual.prim = nodoActual.prim.prox;
            } else {
                Arco arcoActual = nodoActual.prim;
                while (arcoActual != null && arcoActual.prox != null) {
                    if (arcoActual.prox.pDest.name.equals(name)) {
                        arcoActual.prox = arcoActual.prox.prox;
                    } else {
                        arcoActual = arcoActual.prox;
                    }
                }
            }
            nodoActual = nodoActual.prox;
        }
    }

    // Método 1: Verificar si el grafo contiene un ciclo
    public boolean esCiclicoUtil(int i, boolean[] visitado, boolean[] pilaRec) {
        if (pilaRec[i]) {
            return true;
        }
        if (visitado[i]) {
            return false;
        }
        visitado[i] = true;
        pilaRec[i] = true;
        Nodo hijos = prim;
        while (hijos != null) {
            if (esCiclicoUtil(Integer.parseInt(hijos.name), visitado, pilaRec)) {
                return true;
            }
            hijos = hijos.prox;
        }
        pilaRec[i] = false;
        return false;
    }

    public boolean esCiclico() {
        boolean[] visitado = new boolean[cantNodos];
        boolean[] pilaRec = new boolean[cantNodos];
        for (int i = 0; i < cantNodos; i++) {
            if (esCiclicoUtil(i, visitado, pilaRec)) {
                return true;
            }
        }
        return false;
    }

    // Método 2: Encontrar el camino más corto desde nodoInicio hasta nodoFin
    public int caminoMasCorto(String nodoInicio, String nodoFin) {
        // Este es un marcador de posición. La implementación real del algoritmo de Dijkstra es compleja y está más allá del alcance de esta respuesta.
        return -1;
    }

    // Método 3: Devolver un ordenamiento topológico de los nodos en el grafo
    public void ordenacionTopologicaUtil(int v, boolean visitado[], Stack pila) {
        visitado[v] = true;
        Nodo i = prim;
        while (i != null) {
            if (!visitado[Integer.parseInt(i.name)]) {
                ordenacionTopologicaUtil(Integer.parseInt(i.name), visitado, pila);
            }
            i = i.prox;
        }
        pila.push(new Integer(v));
    }

    public void ordenacionTopologica() {
        Stack pila = new Stack();
        boolean visitado[] = new boolean[cantNodos];
        for (int i = 0; i < cantNodos; i++) {
            if (visitado[i] == false) {
                ordenacionTopologicaUtil(i, visitado, pila);
            }
        }
        while (pila.empty() == false) {
            System.out.print(pila.pop() + " ");
        }
    }
}
