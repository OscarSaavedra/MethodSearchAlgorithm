import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        GraphCreation creation=new GraphCreation();
        Graph graph=creation.graphProcess1(creation);
        System.out.println(graph.toString());
        System.out.println("------------------------");

        try{
            Method meth1Object = creation.getClass().getMethod("meth1");
            System.out.println(graph.getAdjacents(new Node(meth1Object)));
        }catch (NoSuchMethodException nsme){
            System.out.println("Método no encontrado");
        }
    }
}
