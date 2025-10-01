

public class Main {
    public static void main(String[] args) {
        NodoPonderado nodoPonderado = new NodoPonderado("A");
        nodoPonderado.agregarVecino(new NodoPonderado("B"),2);
        nodoPonderado.agregarVecino(new NodoPonderado("C"),5);
        NodoPonderado nodoPonderado1 = nodoPonderado.buscarNodoVecino("B");
        nodoPonderado1.agregarVecino(new NodoPonderado("D"),5);
        NodoPonderado nodoPonderado2 = nodoPonderado1.buscarNodoVecino("D");
        nodoPonderado2.agregarVecino(new NodoPonderado("E"),9);
        nodoPonderado2.agregarVecino(new NodoPonderado("F"),5);

        System.out.println(nodoPonderado);
        System.out.println(nodoPonderado1);
        System.out.println(nodoPonderado2);

        GrafoP gp = new GrafoP();
        gp.agregarNodo(nodoPonderado);
        gp.agregarNodo(nodoPonderado1);
        gp.agregarNodo(nodoPonderado.buscarNodoVecino("C"));
        gp.agregarNodo(nodoPonderado2);
        gp.agregarNodo(nodoPonderado2.buscarNodoVecino("E"));
        gp.agregarNodo(nodoPonderado2.buscarNodoVecino("F"));

        System.out.println();

        System.out.println(gp);
        System.out.println(gp.contains("E"));

        LecturaGrafoP lgp = new LecturaGrafoP();
        GrafoP gpLectura = lgp.lecturaGrafo("C:\\Users\\sgsg_\\IdeaProjects\\AlgoritmosBusqueda\\UCSyGBFS\\pruebaP1");
        System.out.println(gpLectura);
    }
}