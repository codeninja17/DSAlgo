package datastructures;

import java.util.LinkedList;

/**
 * Graphs using Adjacency List
 */
public class Graphs {
    int vertices;
    LinkedList<Integer>[] adjacencyList;
    int startingVertex;

    public Graphs(int vertices){
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i<vertices;i++){
            adjacencyList[i] = new LinkedList<>();
        }
        this.vertices = vertices;
    }

    public void addEdge(int source,int destination){
        if(source<vertices && destination<vertices){
            adjacencyList[source].add(destination);
           //  adjacencyList[destination].add(source);
        }
    }

 public  void printGraph(){
        for (int i=0;i<vertices;i++){
            LinkedList<Integer> linkedList = adjacencyList[i];
            System.out.print(i + "->");
            for (Integer integer : linkedList) {
                System.out.print(integer + "->");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Graphs graphs = new Graphs(4);
        graphs.addEdge(0,1);
        graphs.addEdge(0,2);
        graphs.addEdge(1,3);
        graphs.addEdge(2,3);
        graphs.addEdge(4,3);
        graphs.printGraph();
    }


    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(LinkedList<Integer>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public int getStartingVertex() {
        return startingVertex;
    }

    public void setStartingVertex(int startingVertex) {
        this.startingVertex = startingVertex;
    }
}
