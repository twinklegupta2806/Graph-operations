package graph.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeightedDirectedGraph
{
    ArrayList<HashMap<Integer, Integer>> adj;

    public WeightedDirectedGraph(int v){
        adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new HashMap<>());
        }
    }

    public void addEdgeWithWeight(int u, int v, int weight){
        adj.get(u).put(v, weight);
    }

    public void display(){
        for(int i=0;i<adj.size();i++){
            System.out.print("\nElement = "+ i);
            for(HashMap.Entry<Integer, Integer> me: adj.get(i).entrySet()){
                System.out.print(" Connected element = "+ me.getKey() + " with weight "+ me.getValue());
            }
        }
    }
}
