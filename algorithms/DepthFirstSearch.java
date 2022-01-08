package algorithms;


import datastructures.Graphs;

import java.util.LinkedList;

public class DepthFirstSearch {

    public void depthFirstSearch(Graphs graphs,int vertex,boolean[] visited){
        LinkedList<Integer> linkedList = graphs.getAdjacencyList()[vertex];
        visited[vertex] = true;
        System.out.println(vertex);
        for(int num : linkedList){
            if(!visited[num])
                depthFirstSearch(graphs,num,visited);
        }
    }

    public static void main(String[] args) {
        Graphs graphs = new Graphs(6);
        graphs.addEdge(0,1);
        graphs.addEdge(0,2);
        graphs.addEdge(1,3);
        graphs.addEdge(3,4);
        graphs.addEdge(2,5);
        graphs.addEdge(1,5);
        graphs.setStartingVertex(0);

        DepthFirstSearch firstSearch = new DepthFirstSearch();
        boolean[] visited = new boolean[graphs.getVertices()];
        firstSearch.depthFirstSearch(graphs, graphs.getStartingVertex(),visited);
    }



}
