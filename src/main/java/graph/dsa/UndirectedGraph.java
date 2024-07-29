package graph.dsa;
import java.util.*;

public class UndirectedGraph
{
    ArrayList<ArrayList<Integer>> adjList;

    public UndirectedGraph(int v){
        adjList = new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        this.adjList.get(u).add(v); this.adjList.get(v).add(u);
    }

    public void display(){
        for(ArrayList<Integer> edges: adjList){
            System.out.print("\nvertex = " + adjList.indexOf(edges));

            for(Integer edge: edges) {
                System.out.print(" connected to = " + edge);
            }
        }
    }
}
