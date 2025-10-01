import java.util.*;

public class Grafo {
    private List<Nodo> grafo;

    public Grafo() {
        grafo = new ArrayList<>();
    }

    public Grafo(List<Nodo> grafo) {
        this.grafo = grafo;
    }

    public void agregarNodo(Nodo nodo) {
        grafo.add(nodo);
    }

    public Nodo getNodo(int numero) {
        for (Nodo nodo : grafo) {
            if (nodo.getNumero() == numero) {
                return nodo;
            }
        }
        return null;
    }

    public boolean contains(int numero) {
        for (Nodo nodo : grafo) {
            if (nodo.getNumero() == numero) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Nodo nodo : grafo) {
            if (nodo.getVecinos().isEmpty()) {
                sb.append(nodo);
            } else {
                sb.append(nodo + "-> ");
                for (Nodo nodoVecino : nodo.getVecinos()) {
                    sb.append(nodoVecino + " ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public int size() {
        return grafo.size();
    }

    public Nodo getNodoRaiz() {
        return grafo.getFirst();
    }
}
