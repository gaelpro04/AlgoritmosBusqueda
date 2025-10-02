import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

public class LecturaGrafoP {
    private HashMap<String, Integer> heuristica;

    public LecturaGrafoP() {
        heuristica = new HashMap<>();
        int[] values = {14,7,4,6,3,2,0};
        String[] keys = {"A","B","C","D","E","F","G"};

        for (int i = 0; i < values.length; i++) {
            heuristica.put(keys[i],values[i]);
        }
    }

    public GrafoP lecturaGrafo(String ruta) {

        GrafoP grafoP = new GrafoP();
        String linea;

        try {
            BufferedReader rd = new BufferedReader(new FileReader(ruta));
            int contador = 0;
            String[] nodos = null;

            while ((linea = rd.readLine()) != null) {
                String[] contenido = linea.trim().split("\\s+");


                if (contador == 0) {
                    nodos = contenido;
                    for (int i = 0; i < contenido.length; i++) {
                        grafoP.agregarNodo(new NodoPonderado(nodos[i], heuristica.get(nodos[i])));
                    }
                } else {
                    NodoPonderado nodo = grafoP.getNodo(contenido[0]);
                    for (int i = 1; i < contenido.length; i++) {
                        if (esNumero(contenido[i])) {
                            NodoPonderado nodoVecino = grafoP.getNodo(nodos[i-1]);
                            nodo.agregarVecino(nodoVecino, Integer.parseInt(contenido[i]));
                        }
                    }
                }
                ++contador;
            }
            rd.close();
            return grafoP;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean esNumero(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
