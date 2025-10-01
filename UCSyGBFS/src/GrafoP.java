import java.util.ArrayList;
import java.util.List;

public class GrafoP {
    private List<NodoPonderado> nodos;

    public GrafoP() {
        nodos = new ArrayList<>();
    }

    public GrafoP(List<NodoPonderado> nodos) {
        this.nodos = nodos;
    }

    public void agregarNodo(NodoPonderado nodo) {
        nodos.add(nodo);
    }

    public boolean contains(String id) {
        for (NodoPonderado nodo : nodos) {
            if (nodo.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public NodoPonderado getNodo(String id) {
        for (NodoPonderado nodo : nodos) {
            if (nodo.getId().equals(id)) {
                return nodo;
            }
        }

        return null;
    }

    public int size() {
        return nodos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (NodoPonderado nodo : nodos) {
            sb.append(nodo + "\n");
        }

        return sb.toString();
    }
}
