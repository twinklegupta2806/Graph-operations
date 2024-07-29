package graph.dsa;

import java.util.ArrayList;

public class DirectedGraph
{
    ArrayList<ArrayList<Integer>> adjList;

    public DirectedGraph(int v){
        adjList = new ArrayList<>(v);
        for(int i=0;i<v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        this.adjList.get(u).add(v);
    }

    public void display(){
        for(int i=0;i< adjList.size();i++){
            System.out.print("\nElement = "+ i);
            for(Integer connectedElement: adjList.get(i)){
                System.out.print(" connected element = "+ connectedElement);
            }
        }
    }
}
