import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static Scanner sc=new Scanner(System.in);
    public static Graph graph;
    public static void main(String[] args) {

        GraphCreation creation=new GraphCreation();

        System.out.println("Elige [1].grafo aritmético  [2].grafo lógico");
        int ans=sc.nextInt();
        switch (ans){
            case 1:
                graph=creation.graphProcess1(creation);
                System.out.println(graph.toString());
                break;
            case 2:
                graph=creation.graphProcess2(creation);
                System.out.println(graph.toString());
                break;
        }
        System.out.println("///////////////////////");
        System.out.println("Simple meth names");
        Set<Method>methodSet=graph.getNodeGeneralListInMeth();
        for (Method meths : methodSet) {
            System.out.println(meths.getName());
        }
        System.out.println("------------------------");




        System.out.println("Buscar métodos adyacentes");
        String methString=sc.next();
        try{
            if (ans==1){
                Method methObject = creation.getClass().getMethod(methString,int.class);
                System.out.println(graph.getAdjacents(new Node(methObject)));
            }else{
                if (ans==2){
                    Method methObject = creation.getClass().getMethod(methString,boolean.class);
                    System.out.println(graph.getAdjacents(new Node(methObject)));
                }
            }

        }catch (NoSuchMethodException nsme){
            System.out.println("Método no encontrado");
        }

        System.out.println("Realizar operación lógica");
        System.out.println("Método inicio");
        String iniStringBol=sc.next();
        System.out.println("Método final");
        String finalStringBol=sc.next();
        System.out.println("Valor booleano a pasar");
        boolean valorBooleano=sc.nextBoolean();

        List<Node>procesoListBooleano=graph.getConexionPath(iniStringBol,finalStringBol,1000,creation);
        boolean booleano=ConnectionType.andConnection(valorBooleano,procesoListBooleano);
        System.out.println("El resultado del proceso ha sido: "+booleano);



        /*System.out.println("Buscar camino corto entre métodos");
        System.out.println("Método inicio");
        String methStringInicio=sc.next();
        System.out.println("Método final");
        String methStringFinal=sc.next();

        List<Node>procesoList=graph.getConexionPath(methStringInicio,methStringFinal,1000,creation);
        System.out.println("Número para pasar a los métodos:");
        int numParam=sc.nextInt();
        int num=ConnectionType.additionConnection(numParam,procesoList);
        System.out.println("El resultado del proceso ha sido: ["+num+"]");

        System.out.println("GenericConnection");
        String strParam=sc.next();
        ConnectionType.genericConnection(strParam,procesoList);

        System.out.println("Ranking de nodos con más conexiones");
        System.out.println(graph.getNodeCR());*/
    }
}
