import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AlgoritmosBP {

    public void DFS(Grafo grafo, Nodo nodoObjetivo) {
        Nodo[] visitados = new Nodo[grafo.size()];
        Stack<Nodo> pila = new Stack<>();

        //Agregar nodo raiz a la pila
        pila.push(grafo.getNodoRaiz());

        while (!pila.isEmpty()) {
            Nodo nodo = pila.pop();

            if (nodoObjetivo.getNumero() == nodo.getNumero()) {
                System.out.println("Nodo encontrado: " + nodoObjetivo);
                return;
            } else {
                if (nodo.sizeVecinos() > 0) {
                    for (Nodo nodoVecino : nodo.getVecinos()) {
                        pila.push(nodoVecino);
                    }
                }
            }
        }
    }

    public void BFS(Grafo grafo, Nodo nodoObjetivo) {
        Nodo[] visitados = new Nodo[grafo.size()];
        Queue<Nodo> cola = new LinkedList<>();

        while (!cola.isEmpty()) {

        }
    }
}

