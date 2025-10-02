import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LecturaGrafoP lgp = new LecturaGrafoP();
        GrafoP gpLectura = lgp.lecturaGrafo("C:\\Users\\sgsg_\\IdeaProjects\\AlgoritmosBusqueda\\UCSyGBFS\\pruebaP1");
        System.out.println(gpLectura);
        AlgoritmosBV algo = new AlgoritmosBV();
        String letra = "X";
        Scanner sc = new Scanner(System.in);

        while (!letra.equals("C")) {
            System.out.println("A) UCS");
            System.out.println("B) GBFS");
            System.out.println("C) Salir");
            letra = sc.next();

            switch (letra) {
                case "A":
                    System.out.println("Ingresa el nodo raiz");
                    String nodoRaiz = sc.next();
                    System.out.println("Ingresa el nodo objetivo");
                    String nodoObjetivo = sc.next();

                    algo.UCS(gpLectura, gpLectura.getNodo(nodoRaiz), gpLectura.getNodo(nodoObjetivo));
                    break;
                case "B":
                    System.out.println("Ingresa el nodo raiz");
                    String nodoRaiz1 = sc.next();
                    System.out.println("Ingresa el nodo objetivo");
                    String nodoObjetivo1 = sc.next();

                    algo.GBFS(gpLectura, gpLectura.getNodo(nodoRaiz1), gpLectura.getNodo(nodoObjetivo1));
                    break;
                case "C":
                    System.out.println("Adios");
                    break;
            }
        }
    }
}