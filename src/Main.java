import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {

        GraphCreation creation=new GraphCreation();
        Graph graph=creation.graphProcess1(creation);
        System.out.println(graph.toString());
        System.out.println("------------------------");


        System.out.println("Buscar métodos adyacentes");
        String methString=sc.next();
        try{
            Method methObject = creation.getClass().getMethod(methString);
            System.out.println(graph.getAdjacents(new Node(methObject)));
        }catch (NoSuchMethodException nsme){
            System.out.println("Método no encontrado");
        }

        System.out.println("Buscar camino corto entre métodos");
        System.out.println("Método inicio");
        String methStringInicio=sc.next();
        System.out.println("Método final");
        String methStringFinal=sc.next();
        System.out.println(graph.getConexionPath(methStringInicio,methStringFinal,1000,creation));
    }
}
