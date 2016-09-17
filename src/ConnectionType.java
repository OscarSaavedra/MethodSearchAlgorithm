import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ConnectionType {
    //arithmetic connections block
    public static int neutralConnection(int num, List<Node> procesoList){

        for (Node procesos :procesoList) {
            try{
                num=(Integer)procesos.getName().invoke(null,num);
                System.out.println(num);
            }catch (IllegalAccessException | InvocationTargetException err){
                System.out.println("Error!");
                err.getMessage();
            }
        }
        return num;
    }

    public static int additionConnection(int num, List<Node> procesoList){
        int numResult=0;
        System.out.println("Valor de la entrada: "+num);
        for (Node procesos :procesoList) {
            try{
                numResult=numResult+(Integer)procesos.getName().invoke(null,num);
                System.out.println("Valor de input: "+procesos.getName().invoke(null,num));
            }catch (IllegalAccessException | InvocationTargetException err){
                System.out.println("Error!");
                err.getMessage();
            }
        }
        return numResult;
    }

    public static <T> void genericConnection(T a, List<Node> procesoList){
        for (Node procesos : procesoList) {
            System.out.println(a);
        }
    }
    ///////////////////////////////////////////////////////////////////////////

    //logic connections block
    public static boolean andConnection(boolean bool,List<Node> procesoList){
        boolean resultado=true;
        System.out.println("Valor de la entrada: "+bool);
        try{
            for (Node proceso : procesoList) {
                resultado=resultado&&((Boolean) proceso.getName().invoke(null,bool));
                System.out.println("Valor del input: "+proceso.getName().invoke(null,bool));
            }
        }catch (IllegalAccessException|InvocationTargetException err){
            System.out.println("Error");
        }
        return resultado;
    }
}
