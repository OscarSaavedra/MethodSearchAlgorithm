import java.lang.reflect.Method;

public class GraphCreation {

    GraphCreation(){
    }

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

    public  Graph graphProcess1(GraphCreation obj){
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
}

