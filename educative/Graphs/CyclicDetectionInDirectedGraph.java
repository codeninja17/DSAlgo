package educative.Graphs;

import datastructures.Graphs;

public class CyclicDetectionInDirectedGraph {

    public void findCycle(Graphs graphs){
        boolean result = false;
        boolean [] visited = new boolean[graphs.getVertices()];
        boolean [] vertexStack = new boolean[graphs.getVertices()];
        for(int i = 0; i< graphs.getVertices();i++){
            if(isCyclic(graphs,i,visited,vertexStack)){
               result = true;
                break;
            }
        }
        System.out.println(result);
    }

    public boolean isCyclic(Graphs graphs,int vertex, boolean[] visited , boolean[] vertexStack){
        if(vertexStack[vertex])
            return true;
        if(visited[vertex])
            return false;
        visited[vertex] = true;
        vertexStack[vertex] = true;
        for(int num : graphs.getAdjacencyList()[vertex]){
            if(isCyclic(graphs,num,visited,vertexStack))
                return true;
        }
        vertexStack[vertex] = false;
        return false;
    }

    public static void main(String[] args) {
        Graphs graphs = new Graphs(5);
        graphs.addEdge(0,1);
        graphs.addEdge(0,2);
        graphs.addEdge(2,3);
        graphs.addEdge(3,1);
        graphs.addEdge(3,4);
        graphs.addEdge(4,2);
        CyclicDetectionInDirectedGraph cyclicDetectionInDirectedGraph = new CyclicDetectionInDirectedGraph();
        cyclicDetectionInDirectedGraph.findCycle(graphs);
    }

}
