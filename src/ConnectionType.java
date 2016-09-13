import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ConnectionType {
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
        for (Node procesos :procesoList) {
            try{
                numResult=numResult+(Integer)procesos.getName().invoke(null,num);
                System.out.println(num);
            }catch (IllegalAccessException | InvocationTargetException err){
                System.out.println("Error!");
                err.getMessage();
            }
        }
        return numResult;
    }
}
