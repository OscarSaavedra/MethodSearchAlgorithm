import java.lang.reflect.Method;

public class GraphCreation {
    GraphCreation(){
    }

    public static void meth1(){

    }
    public static void meth2(){

    }
    public static void meth3(){

    }
    public static void meth4(){

    }
    public static void meth5(){

    }
    public static void meth6(){

    }

    public  Graph graphProcess1(GraphCreation obj){
        Graph graph=new Graph();
        try{
            Method meth1Object = obj.getClass().getMethod("meth1");
            Method meth2Object = obj.getClass().getMethod("meth2");
            Method meth3Object = obj.getClass().getMethod("meth3");
            Method meth4Object = obj.getClass().getMethod("meth4");
            Method meth5Object = obj.getClass().getMethod("meth5");
            Method meth6Object = obj.getClass().getMethod("meth6");

            Node meth1node=new Node(meth1Object);
            Node meth2node=new Node(meth2Object);
            Node meth3node=new Node(meth3Object);
            Node meth4node=new Node(meth4Object);
            Node meth5node=new Node(meth5Object);
            Node meth6node=new Node(meth6Object);

            graph.addNode(meth1node);
            graph.addNode(meth2node);
            graph.addNode(meth3node);
            graph.addNode(meth4node);
            graph.addNode(meth5node);
            graph.addNode(meth6node);

            graph.connect(meth1node,meth3node);

            graph.connect(meth2node,meth4node);

            graph.connect(meth3node,meth1node);
            graph.connect(meth3node,meth5node);

            graph.connect(meth4node,meth2node);
            graph.connect(meth4node,meth6node);

            graph.connect(meth5node,meth4node);
            graph.connect(meth5node,meth6node);

            graph.connect(meth6node,meth4node);
            graph.connect(meth6node,meth5node);

        }catch (NoSuchMethodException nsme){
            System.out.println("Alguno de los métodos no existe");
        }
        return graph;
    }
}

