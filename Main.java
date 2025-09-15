public class Main {
    public static void main(String[] args) {
        Grafo grafo1 = new Grafo();

        Nodo uno = new Nodo(1);
        Nodo dos = new Nodo(2);
        Nodo tres = new Nodo(3);
        Nodo cuatro = new Nodo(4);

        uno.agregarVecino(dos);
        uno.agregarVecino(tres);
        dos.agregarVecino(cuatro);
        tres.agregarVecino(dos);

        grafo1.agregarNodo(uno);
        grafo1.agregarNodo(dos);
        grafo1.agregarNodo(tres);
        grafo1.agregarNodo(cuatro);

        System.out.println(grafo1);

        System.out.println("\nPrueba lectura archivos");
        LecturaGrafo lg = new LecturaGrafo();

        Grafo grafo = lg.lecturaGrafo("C:\\Users\\sgsg_\\IdeaProjects\\AlgoritmosBusqueda\\prueba1");

        System.out.println(grafo);


    }
}
