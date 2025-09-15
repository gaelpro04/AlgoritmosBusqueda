import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturaGrafo {

    public Grafo lecturaGrafo(String ruta) {

        Grafo grafo = new Grafo();
        String linea;

        try {
            BufferedReader read = new BufferedReader(new FileReader(ruta));
            int contador = 0;
            while ((linea = read.readLine()) != null) {
                String[] contenido = linea.split(" ");

                if (contador == 0) {
                    for (int i = 1; i < contenido.length; i++) {
                        grafo.agregarNodo(new Nodo(Integer.parseInt(contenido[i])));
                    }
                } else {
                    Nodo nodo = grafo.getNodo(grafo.contains(0) ? contador-1 : contador);
                    for (int i = 1; i < contenido.length; i++) {
                       if (Integer.parseInt(contenido[i]) == 1) {
                           Nodo nodoVecino = grafo.getNodo(grafo.contains(0) ? i-1 : i);
                           nodo.agregarVecino(nodoVecino);
                       }
                    }
                }

                ++contador;
            }
            read.close();
            return grafo;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
