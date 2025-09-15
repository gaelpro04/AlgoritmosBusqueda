import java.util.*;

public class Nodo {
    private int numero;
    private List<Nodo> vecinos;

    public Nodo(int numero) {
        this.numero = numero;
        vecinos = new ArrayList<>();
    }

    public Nodo(int numero, List<Nodo> vecinos) {
        this.numero = numero;
        this.vecinos = vecinos;
    }

    public void agregarVecino(Nodo nodo) {
        vecinos.add(nodo);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int sizeVecinos() {
        return vecinos.size();
    }

    public List<Nodo> getVecinos() {
        return vecinos;
    }

    public void setVecinos(List<Nodo> vecinos) {
        this.vecinos = vecinos;
    }

    public String toString() {
        return "[" + numero + "]";
    }
}
