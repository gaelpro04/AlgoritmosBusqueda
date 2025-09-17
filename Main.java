public class Main {
    public static void main(String[] args) {

        System.out.println("\nPrueba lectura archivos");
        LecturaGrafo lg = new LecturaGrafo();

        Grafo grafo = lg.lecturaGrafo("C:\\Users\\sgsg_\\IdeaProjects\\AlgoritmosBusqueda\\prueba2");

        System.out.println(grafo);

        AlgoritmosBP algo = new AlgoritmosBP();
        algo.DFS(grafo,new Nodo(5));

    }
}
