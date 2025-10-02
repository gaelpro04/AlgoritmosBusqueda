public class Arista {
    private NodoPonderado nodoPonderadoDestino;
    private int valor;

    public Arista() {
        nodoPonderadoDestino = null;
        valor = 0;
    }

    public Arista(NodoPonderado nodoPonderadoDestino, int valor) {
        this.nodoPonderadoDestino = nodoPonderadoDestino;
        this.valor = valor;
    }

    public NodoPonderado getNodoDestino() {
        return nodoPonderadoDestino;
    }

    public void setNodoDestino(NodoPonderado nodoPonderadoDestino) {
        this.nodoPonderadoDestino = nodoPonderadoDestino;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoPonderado getNodoPonderadoDestino() {
        return nodoPonderadoDestino;
    }

    public void setNodoPonderadoDestino(NodoPonderado nodoPonderadoDestino) {
        this.nodoPonderadoDestino = nodoPonderadoDestino;
    }
}

