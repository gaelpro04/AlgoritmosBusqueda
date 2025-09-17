import java.util.*;

public class AlgoritmosBP {

    /**
     * Algoritmo de busqueda Depth-Firs Serach
     * @param grafo
     * @param nodoObjetivo
     */
    public void DFS(Grafo grafo, Nodo nodoObjetivo) {

        //Se crean la pila y el arreglo para visitados.
        List<Nodo> visitados = new ArrayList<>();
        Stack<Nodo> pila = new Stack<>();
        int contador = 0;

        //Agregar nodo raiz a la pila
        pila.push(grafo.getNodoRaiz());

        System.out.println("================================Depth-First Search");
        //Mientras que la pila no este vacia seguira ejecutando el ciclo.
        while (!pila.isEmpty()) {

            if (contador == 50) {
                break;
            }

            System.out.println("===================ITERACION " + contador);
            System.out.println("Pila: " + mostrarPila(pila));
            System.out.println("Visitados: " + mostrarVisitados(visitados));

            //Se sada un nodo de la pila para verificar si es el nodo objetivo
            Nodo nodo = pila.pop();

            //Si el nodo sacado es igual al nodo objetivo quiere decir que hemos encontrado el nodo en cuestion
            if (nodoObjetivo.getNumero() == nodo.getNumero()) {
                visitados.add(nodo);
                System.out.println();
                System.out.println("Nodo encontrado: " + nodoObjetivo);
                System.out.println("Pila: " + mostrarPila(pila));
                System.out.println("Visitados: " + mostrarVisitados(visitados));
                return;

                //Sino se mete el nodo a visitados y se meten sus nodos vecinos a la pila.
            } else {
                visitados.add(nodo);
                if (nodo.sizeVecinos() > 0) {
                    nodo.getVecinos().sort(Comparator.comparingInt(Nodo::getNumero));
                    for (Nodo nodoVecino : nodo.getVecinos()) {
                        pila.push(nodoVecino);
                    }
                }
            }

            ++contador;
        }
    }

    /**
     * Algoritmo de busqueda Breadth-First Serach
     * @param grafo
     * @param nodoObjetivo
     */
    public void BFS(Grafo grafo, Nodo nodoObjetivo) {

        //Se crea la cola y el arreglo para visitados.
        List<Nodo> visitados = new ArrayList<>();
        Queue<Nodo> cola = new LinkedList<>();
        int contador = 0;

        //Se mete el nodo raiz a la cola
        cola.offer(grafo.getNodoRaiz());

        System.out.println("================================Breath-First Search");
        //El ciclo se seguira ejecutando mientras la cola no este vacia
        while (!cola.isEmpty()) {
            boolean contiene = false;

            if (contador == 50) {
                break;
            }

            System.out.println("===================ITERACION " + contador);
            System.out.println("Cola: " + mostrarCola(cola));
            System.out.println("Visitados: " + mostrarVisitados(visitados));


            //Se cada un nodo de la cola para verificar si es el nodo buscado
            Nodo nodo = cola.poll();
            if (nodo.getNumero() == nodoObjetivo.getNumero()) {
                visitados.add(nodo);
                System.out.println();
                System.out.println("Nodo encontrado: " + nodo);
                System.out.println("Cola: " + mostrarCola(cola));
                System.out.println("Visitados: " + mostrarVisitados(visitados));

                return;

                //Si no lo es, se verifica que el nodo no haya sido descubierto antes
            } else {
                for (Nodo nodoVisitado : visitados) {
                    if (nodoVisitado.getNumero() == nodo.getNumero()) {
                        contiene = true;
                        break;
                    }
                }

                //Si el nodo en cuestion no ha sido descubierto se mete a visitados, de lo contrario no lo hace.
                if (!contiene) {
                    visitados.add(nodo);
                }

                //Se ordenan los nodos vecinos del nodo para poder meterlos a la cola
                nodo.getVecinos().sort(Comparator.comparingInt(Nodo::getNumero));

                //Se meten los nodos vecinos a la cola
                for (Nodo nodoVecinos : nodo.getVecinos()) {
                    boolean visitado = false;

                    Queue<Nodo> colaTemp = new LinkedList<>();
                    while (!cola.isEmpty()) {
                        Nodo nodo1 = cola.poll();
                        if (nodoVecinos.getNumero() == nodo1.getNumero()) {
                            visitado = true;
                        }

                        colaTemp.offer(nodo1);
                    }

                    while (!colaTemp.isEmpty()) {
                        cola.offer(colaTemp.poll());
                    }

                    if (!visitado) {
                        cola.offer(nodoVecinos);
                    }
                }
            }

            ++contador;
        }
    }

    private String mostrarCola(Queue<Nodo> cola) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Queue<Nodo> colaTemp = new LinkedList<>();

        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            sb.append(nodo.getNumero() + " ");
            colaTemp.offer(nodo);
        }

        while (!colaTemp.isEmpty()) {
            Nodo nodo = colaTemp.poll();
            cola.offer(nodo);
        }
        sb.append("]");

        return sb.toString();
    }

    private String mostrarPila(Stack<Nodo> pila) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Stack<Nodo> pilaTemp = new Stack<>();

        while (!pila.isEmpty()) {
            Nodo nodo = pila.pop();
            pilaTemp.push(nodo);

            sb.append(nodo.getNumero() + " ");
        }

        while (!pilaTemp.isEmpty()) {
            Nodo nodo = pilaTemp.pop();
            pila.push(nodo);
        }

        sb.append("]");

        return sb.toString();
    }

    private String mostrarVisitados(List<Nodo> visitados) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        for (Nodo nodo : visitados) {
            sb.append(nodo.getNumero() + " ");
        }
        sb.append("]");

        return sb.toString();
    }
}

