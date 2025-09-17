public class Main {
    public static void main(String[] args) {

        System.out.println("\nPrueba lectura archivos");
        LecturaGrafo lg = new LecturaGrafo();

        Grafo grafo = lg.lecturaGrafo("C:\\Users\\sgsg_\\IdeaProjects\\AlgoritmosBusqueda\\prueba1");

        System.out.println(grafo);

        AlgoritmosBP algo = new AlgoritmosBP();
        algo.BFS(grafo,new Nodo(8));

    }
}
