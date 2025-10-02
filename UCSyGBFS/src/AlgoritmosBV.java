import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AlgoritmosBV {

    /**
     * Metodo de algoritmos de busqueda UCS
     * @param grafo
     * @param nodoRaiz
     * @param nodoObjetivo
     */
    public void UCS(GrafoP grafo, NodoPonderado nodoRaiz, NodoPonderado nodoObjetivo) {

        //Se crean la cola de prioridad para los caminos y visitados
        PriorityQueue<Camino> cola = new PriorityQueue<>(Comparator.comparingInt(Camino::getCostoAcumulado));
        List<NodoPonderado> visitados = new ArrayList<>();

        //Se mete primero el nodo raiz propuesto a la cola
        cola.offer(new Camino(grafo.getNodo(nodoRaiz.getId()),0,new ArrayList<>(List.of(nodoRaiz))));

        System.out.println("=============================Uniform Cost Search");
        int contador = 0;
        while (!cola.isEmpty()) {
            System.out.println("===================ITERACION " + contador);
            System.out.println("Cola: " + mostrarCola(cola));
            System.out.println("Visitados: " + mostrarVisitados(visitados));

            //Se saca el camino actual(al inicio sera solo un nodo) y se verifica si ya fue visitado,
            //si no lo fue visitado se mete ahi mismo
            Camino caminoActual = cola.poll();
            if (visitados.contains(caminoActual.getNodo())) {
                ++contador;
                continue;
            }
            visitados.add(caminoActual.getNodo());

            //Se verifica si es el nodo objetivo, si lo es se acaba la busqueda y se imprime
            if (caminoActual.getNodo().equals(nodoObjetivo)) {
                System.out.println("Nodo encontrado: " + caminoActual.getNodo().getId());
                System.out.println("Camino: " + caminoActual);
                return;
            }

            //Si no es el objetivo, se meten a la cola todos los nodos vecinos del nodo actual junto a su camino actua;
            //y costo acumulado. Ademas se verifica si ya fue visitado algun nodo vecino del nodo actual.
            for (Arista arista : caminoActual.getNodo().getVecinos()) {
                if (!visitados.contains(arista.getNodoDestino())) {
                    NodoPonderado nodo = arista.getNodoDestino();
                    int costoAcumulado = arista.getValor() + caminoActual.getCostoAcumulado();
                    List<NodoPonderado> nuevoCamino = new ArrayList<>(caminoActual.getCamino());
                    nuevoCamino.add(nodo);

                    cola.offer(new Camino(nodo, costoAcumulado, nuevoCamino));
                }
            }
            ++contador;
        }
    }

    public void GBFS(GrafoP grafo, NodoPonderado nodoRaiz, NodoPonderado nodoObjetivo) {
        PriorityQueue<Camino> cola = new PriorityQueue<>(Comparator.comparingInt(camino -> camino.getNodo().getHeuristica()));
        List<NodoPonderado> visitados = new ArrayList<>();

        cola.offer(new Camino(nodoRaiz, 0,new ArrayList<>(List.of(nodoRaiz))));
        System.out.println("=============================Greedy Bredth First Search");
        int contador = 0;

        while (!cola.isEmpty()) {
            System.out.println("===================ITERACION " + contador);
            System.out.println("Cola: " + mostrarColaH(cola));
            System.out.println("Visitados: " + mostrarVisitados(visitados));

            Camino caminoActual = cola.poll();
            if (visitados.contains(caminoActual.getNodo())) {
                ++contador;
                continue;
            }
            visitados.add(caminoActual.getNodo());

            if (caminoActual.getNodo().equals(nodoObjetivo)) {
                System.out.println("Nodo encontrado: " + caminoActual.getNodo().getId());
                System.out.println("Camino: " + caminoActual.toStringH());
                int heuristicaFinal = 0;
                for (int i = 1; i < caminoActual.getCamino().size(); i++) {
                    heuristicaFinal = heuristicaFinal + caminoActual.getCamino().get(i).getHeuristica();
                }
                caminoActual.setHeuristicaAcumulada(heuristicaFinal);
                System.out.println("Heuristica: " + caminoActual.getHeuristicaAcumulada());
                return;
            }

            for (Arista arista : caminoActual.getNodo().getVecinos()) {
                if (!visitados.contains(arista.getNodoDestino())) {
                    NodoPonderado nodo = arista.getNodoDestino();
                    int costoAcumulado = arista.getValor() + caminoActual.getCostoAcumulado();
                    List<NodoPonderado> nuevoCamino = new ArrayList<>(caminoActual.getCamino());
                    nuevoCamino.add(nodo);

                    cola.offer(new Camino(nodo, costoAcumulado, nuevoCamino));
                }
            }

            ++contador;
        }
    }

    public String mostrarCola(PriorityQueue<Camino> cola) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Camino> colaTemp = new PriorityQueue<>(Comparator.comparingInt(Camino::getCostoAcumulado));

        sb.append("[ ");
        while (!cola.isEmpty()) {
            Camino camino = cola.poll();
            sb.append(camino + " ");
            colaTemp.offer(camino);
        }
        sb.append("]");

        while (!colaTemp.isEmpty()) {
            Camino camino = colaTemp.poll();
            cola.offer(camino);
        }

        return sb.toString();
    }

    public String mostrarColaH(PriorityQueue<Camino> cola) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Camino> colaTemp = new PriorityQueue<>(Comparator.comparingInt(Camino::getCostoAcumulado));

        sb.append("[ ");
        while (!cola.isEmpty()) {
            Camino camino = cola.poll();
            sb.append(camino.toStringH() + " ");
            colaTemp.offer(camino);
        }
        sb.append("]");

        while (!colaTemp.isEmpty()) {
            Camino camino = colaTemp.poll();
            cola.offer(camino);
        }

        return sb.toString();
    }

    public String mostrarVisitados(List<NodoPonderado> visitados) {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");

        for (NodoPonderado nodo : visitados) {
            sb.append(nodo.getId() + " ");
        }
        sb.append("]");

        return sb.toString();
    }
}
