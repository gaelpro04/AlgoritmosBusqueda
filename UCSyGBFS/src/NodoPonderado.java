import java.util.ArrayList;
import java.util.List;

public class NodoPonderado {
    private String id;
    private List<Arista> vecinos;
    private int heuristica;

    public NodoPonderado() {
        id = null;
        vecinos = new ArrayList<>();
        heuristica = -1;
    }

    public NodoPonderado(String id, List<Arista> vecinos) {
        this.id = id;
        this.vecinos = vecinos;
        heuristica = -1;
    }

    public NodoPonderado(String id, int heuristica) {
        this.id = id;
        vecinos = new ArrayList<>();
        this.heuristica = heuristica;
    }

    public NodoPonderado(String id) {
        this.id = id;
        vecinos = new ArrayList<>();
        heuristica = -1;
    }

    public NodoPonderado(String id, List<Arista> vecinos, int heuristica) {
        this.id = id;
        this.vecinos = vecinos;
        this.heuristica = heuristica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Arista> getVecinos() {
        return vecinos;
    }

    public void setVecinos(List<Arista> vecinos) {
        this.vecinos = vecinos;
    }

    public void agregarVecino(NodoPonderado nodoPonderado, int valor) {
        vecinos.add(new Arista(nodoPonderado, valor));
    }

    public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + id + "] -> ");

        int contador = 0;
        for (Arista arista : vecinos) {
            NodoPonderado vecino = arista.getNodoDestino();
            int costo = arista.getValor();

            if (contador == vecinos.size() - 1) {
                sb.append("[" + vecino.getId() + "|" + vecino.getHeuristica() + "]");
            } else {
                sb.append("[" + vecino.getId() + "|" + vecino.getHeuristica() + "] " + costo + "-> ");
                ++contador;
            }
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof NodoPonderado nodoPonderado)) return false;

        return id.equals(nodoPonderado.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public NodoPonderado buscarNodoVecino(String id) {
        for (Arista arista : vecinos) {
            NodoPonderado nodoPonderado = arista.getNodoDestino();

            if (nodoPonderado.getId().equals(id)) {
                return nodoPonderado;
            }
        }

        return null;
    }
}
