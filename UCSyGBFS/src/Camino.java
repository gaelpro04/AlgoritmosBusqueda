import java.util.ArrayList;
import java.util.List;

public class Camino implements Comparable<Camino> {
    private NodoPonderado nodoActual;
    private int costoAcumulado;
    private List<NodoPonderado> camino;
    private int heuristicaAcumulada;

    public Camino(NodoPonderado nodoActual, int costoAcumulado, List<NodoPonderado> camino, int heuristicaAcumulada) {
        this.nodoActual = nodoActual;
        this.costoAcumulado = costoAcumulado;
        this.camino = camino;
        this.heuristicaAcumulada = heuristicaAcumulada;
    }

    public Camino(NodoPonderado nodoActual, int costoAcumulado, List<NodoPonderado> camino) {
        this.nodoActual = nodoActual;
        this.costoAcumulado = costoAcumulado;
        this.camino = camino;
        heuristicaAcumulada = 0;
    }

    public Camino(NodoPonderado nodoInicial) {
        nodoActual = nodoInicial;
        costoAcumulado = 0;
        camino = new ArrayList<>();
    }

    public NodoPonderado getNodo() {
        return nodoActual;
    }

    public void setNodo(NodoPonderado nodo) {
        this.nodoActual = nodo;
    }

    public int getCostoAcumulado() {
        return costoAcumulado;
    }

    public void setCostoAcumulado(int costoAcumulado) {
        this.costoAcumulado = costoAcumulado;
    }

    public List<NodoPonderado> getCamino() {
        return camino;
    }

    public void setCamino(List<NodoPonderado> camino) {
        this.camino = camino;
    }

    public NodoPonderado getNodoActual() {
        return nodoActual;
    }

    public void setNodoActual(NodoPonderado nodoActual) {
        this.nodoActual = nodoActual;
    }

    public int getHeuristicaAcumulada() {
        return heuristicaAcumulada;
    }

    public void setHeuristicaAcumulada(int heuristicaAcumulada) {
        this.heuristicaAcumulada = heuristicaAcumulada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (NodoPonderado nodo : camino) {
            sb.append(nodo.getId());
        }
        sb.append("]");
        sb.append("(" + costoAcumulado + ")");

        return sb.toString();
    }

    public String toStringH() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (NodoPonderado nodo : camino) {
            sb.append(nodo.getId());
        }
        sb.append("]");
        sb.append("(" + nodoActual.getHeuristica() + ")");

        return sb.toString();
    }

    @Override
    public int compareTo(Camino o) {
        return Integer.compare(this.costoAcumulado, o.costoAcumulado);
    }
}
