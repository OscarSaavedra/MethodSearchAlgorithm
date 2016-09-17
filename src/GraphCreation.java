import java.lang.reflect.Method;

public class GraphCreation {

    GraphCreation(){
    }
    //arithmetic meths/nodes
    public static int meth1(int num){
        return num*2;
    }
    public static int meth2(int num){
        return num-50;
    }
    public static int meth3(int num){
        return num*10;
    }
    public static int meth4(int num){
        return num/10;
    }
    public static void meth5(int num){

    }
    public static void meth6(int num){

    }
    public static void meth7(int num){

    }
    public static void meth8(int num){

    }
    ///////////////////////////////////////////////////


    //logical meths/nodes
    public static boolean andMeth(boolean b){
        boolean out=true;
        return b&&out;
    }
    public static boolean orMeth (boolean b){
        boolean out=true;
        return b||out;
    }
    public static boolean notMeth(boolean b){
        return !b;
    }
    public static boolean equalMeth(boolean b){
        boolean out=true;
        return b==out;
    }
    public static boolean notEqualMeth (boolean b){
        boolean out=true;
        return b!=out;
    }
    public static boolean xorMeth (boolean b){
        boolean out=true;
        return b^out;
    }
    //////////////////////////////////////////////////////

    public Graph graphProcess1(GraphCreation obj){
        Graph graph=new Graph();
        try{
            Method meth1Object = obj.getClass().getMethod("meth1",int.class);
            Method meth2Object = obj.getClass().getMethod("meth2",int.class);
            Method meth3Object = obj.getClass().getMethod("meth3",int.class);
            Method meth4Object = obj.getClass().getMethod("meth4",int.class);
            Method meth5Object = obj.getClass().getMethod("meth5",int.class);
            Method meth6Object = obj.getClass().getMethod("meth6",int.class);
            Method meth7Object = obj.getClass().getMethod("meth7",int.class);
            Method meth8Object = obj.getClass().getMethod("meth8",int.class);

            Node meth1node=new Node(meth1Object);
            Node meth2node=new Node(meth2Object);
            Node meth3node=new Node(meth3Object);
            Node meth4node=new Node(meth4Object);
            Node meth5node=new Node(meth5Object);
            Node meth6node=new Node(meth6Object);
            Node meth7node=new Node(meth7Object);
            Node meth8node=new Node(meth8Object);


            graph.addNode(meth1node);
            graph.addNode(meth2node);
            graph.addNode(meth3node);
            graph.addNode(meth4node);
            graph.addNode(meth5node);
            graph.addNode(meth6node);
            graph.addNode(meth7node);
            graph.addNode(meth8node);

            graph.connect(meth1node,meth3node);
            graph.connect(meth1node,meth2node);

            graph.connect(meth2node,meth4node);
            graph.connect(meth2node,meth1node);

            graph.connect(meth3node,meth1node);
            graph.connect(meth3node,meth5node);

            graph.connect(meth4node,meth2node);
            graph.connect(meth4node,meth6node);
            graph.connect(meth4node,meth7node);

            graph.connect(meth5node,meth3node);
            graph.connect(meth5node,meth6node);

            graph.connect(meth6node,meth4node);
            graph.connect(meth6node,meth5node);

            graph.connect(meth7node,meth4node);
            graph.connect(meth7node,meth8node);

            graph.connect(meth8node,meth7node);

        }catch (NoSuchMethodException nsme){
            System.out.println("Alguno de los métodos no existe");
        }
        return graph;
    }
    public Graph graphProcess2(GraphCreation obj){
        Graph graph=new Graph();
        try{
            Method andMethObj=obj.getClass().getMethod("andMeth",boolean.class);
            Method orMethObj=obj.getClass().getMethod("orMeth",boolean.class);
            Method notMethObj=obj.getClass().getMethod("notMeth",boolean.class);
            Method equalMethObj=obj.getClass().getMethod("equalMeth",boolean.class);
            Method notEqualMethObj=obj.getClass().getMethod("notEqualMeth",boolean.class);
            Method xorMethObj=obj.getClass().getMethod("xorMeth",boolean.class);

            Node andMethNode=new Node(andMethObj);
            Node orMethNode=new Node(orMethObj);
            Node notMethNode=new Node(notMethObj);
            Node equalMethNode=new Node(equalMethObj);
            Node notEqualMethNode=new Node(notEqualMethObj);
            Node xorMethNode=new Node(xorMethObj);

            graph.addNode(andMethNode);
            graph.addNode(orMethNode);
            graph.addNode(notMethNode);
            graph.addNode(equalMethNode);
            graph.addNode(notEqualMethNode);
            graph.addNode(xorMethNode);


            graph.connect(andMethNode,xorMethNode);
            graph.connect(andMethNode,notMethNode);
            graph.connect(andMethNode,equalMethNode);
            graph.connect(andMethNode,notEqualMethNode);
            graph.connect(andMethNode,orMethNode);


            graph.connect(xorMethNode,notMethNode);
            graph.connect(xorMethNode,equalMethNode);
            graph.connect(xorMethNode,notEqualMethNode);
            graph.connect(xorMethNode,orMethNode);
            graph.connect(xorMethNode,andMethNode);


            graph.connect(notMethNode,equalMethNode);
            graph.connect(notMethNode,notEqualMethNode);
            graph.connect(notMethNode,orMethNode);
            graph.connect(notMethNode,andMethNode);
            graph.connect(notMethNode,xorMethNode);


            graph.connect(equalMethNode,notEqualMethNode);
            graph.connect(equalMethNode,orMethNode);
            graph.connect(equalMethNode,andMethNode);
            graph.connect(equalMethNode,xorMethNode);
            graph.connect(equalMethNode,notEqualMethNode);


            graph.connect(notEqualMethNode,orMethNode);
            graph.connect(notEqualMethNode,andMethNode);
            graph.connect(notEqualMethNode,xorMethNode);
            graph.connect(notEqualMethNode,notMethNode);
            graph.connect(notEqualMethNode,equalMethNode);


            graph.connect(orMethNode,andMethNode);
            graph.connect(orMethNode,xorMethNode);
            graph.connect(orMethNode,notMethNode);
            graph.connect(orMethNode,equalMethNode);
            graph.connect(orMethNode,notEqualMethNode);

        }catch (NoSuchMethodException nsme){
            System.out.println("Método no encontrado");
        }
        return graph;
    }
}

