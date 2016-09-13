import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
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
            Method methObject = creation.getClass().getMethod(methString,int.class);
            System.out.println(graph.getAdjacents(new Node(methObject)));
        }catch (NoSuchMethodException nsme){
            System.out.println("Método no encontrado");
        }



        System.out.println("Buscar camino corto entre métodos");
        System.out.println("Método inicio");
        String methStringInicio=sc.next();
        System.out.println("Método final");
        String methStringFinal=sc.next();

        List<Node>procesoList=graph.getConexionPath(methStringInicio,methStringFinal,1000,creation);
        System.out.println("Número para pasar a los métodos:");
        int numParam=sc.nextInt();
        int num=ConnectionType.additionConnection(numParam,procesoList);
        System.out.println("El resultado del proceso ha sido: ["+num+"]");

        System.out.println("Ranking de nodos con más conexiones");
        System.out.println(graph.getNodeCR());
    }
}
