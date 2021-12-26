package Algorithms;

import datastructures.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {

    void breadthFirstSearch(Graphs graphs){
        Queue <LinkedList<Integer>>queue = new LinkedList<>();
        Map<Integer,Boolean> visited = new HashMap<>();
        LinkedList<Integer> linkedList = graphs.getAdjacencyList()[graphs.getStartingVertex()];
        System.out.print(graphs.getStartingVertex()+" ");
        visited.put(graphs.getStartingVertex(),true);
        queue.add(linkedList);
        while(!queue.isEmpty()){
            LinkedList<Integer> linkedList1 = queue.remove();
            for(Integer num: linkedList1){
                if(!visited.containsKey(num)){
                    visited.put(num,true);
                    System.out.print(num+" ");
                }
                queue.add(graphs.getAdjacencyList()[num]);
            }
        }
    }

    public static void main(String[] args) {
        Graphs graphs = new Graphs(5);
        graphs.addEdge(2,4);
        graphs.addEdge(2,3);
        graphs.addEdge(2,0);
        graphs.addEdge(0,1);
        graphs.setStartingVertex(2);
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.breadthFirstSearch(graphs);
    }
}
